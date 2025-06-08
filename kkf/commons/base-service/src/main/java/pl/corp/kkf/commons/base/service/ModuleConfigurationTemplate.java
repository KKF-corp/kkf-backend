package pl.corp.kkf.commons.base.service;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.flywaydb.core.Flyway;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

public abstract class ModuleConfigurationTemplate {

    public static final String COMMON_ROOT_PACKAGE = "pl.corp.kkf";

    protected DataSource dataSource;

    private Properties jpaProperties = new Properties();

    private Properties flywayProperties = new Properties();

    public abstract String getModuleName();

    public DataSource getDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setPoolName(getModuleName() + "HikariPool");
        dataSource = hikariDataSource;
        return dataSource;
    }

    protected void flywayMigrate() {
        Flyway flyway = Flyway.configure()
                .locations(getSchemaLocation())
                .schemas(getModuleName().toLowerCase())
                .configuration(flywayProperties)
                .dataSource(dataSource)
                .load();

        flyway.migrate();
    }

    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(String persistenceUnitName) {
//        flywayMigrate();
        LocalContainerEntityManagerFactoryBean entity = new LocalContainerEntityManagerFactoryBean();
        entity.setDataSource(dataSource);
        entity.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entity.setPersistenceUnitName(persistenceUnitName);
        entity.setPackagesToScan(getModelPackage());
        entity.setJpaProperties(jpaProperties);
        return entity;
    }

    public PlatformTransactionManager getTransactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    protected String getModelPackage() {
        return "pl.corp.kkf." + getModuleNameAsDotted() + ".services.model";
    }

    private String getModuleNameAsDotted() {
        return getModuleName()
                .replaceAll("([A-Z]+)([A-Z][a-z])", "$1\\.$2")
                .replaceAll("([a-z])([A-Z])", "$1\\.$2")
                .toLowerCase();
    }

    private String getSchemaLocation() {
        String schemaName = getModuleName();
        return "classpath:db/" + getModuleName()
                .replaceAll("([A-Z]+)([A-Z][a-z])", "$1\\/$2")
                .replaceAll("([a-z])([A-Z])", "$1\\/$2")
                .toLowerCase() + "/migration";
    }

    public Properties getJpaProperties() {
        return jpaProperties;
    }

    public void setJpaProperties(Properties jpaProperties) {
        this.jpaProperties = jpaProperties;
    }

    public Properties getFlywayProperties() {
        return flywayProperties;
    }

    public void setFlywayProperties(Properties flywayProperties) {
        this.flywayProperties = flywayProperties;
    }
}

package pl.corp.kkf.kkf.services.impl;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import pl.corp.kkf.commons.base.service.ModuleConfigurationTemplate;

import javax.sql.DataSource;

import static pl.corp.kkf.commons.base.service.db.DataSourceConstants.DATA_SOURCE_PROPERTIES_NAME;
import static pl.corp.kkf.kkf.services.impl.KKFModuleConstants.*;

@Configuration
@ConfigurationProperties(PROPERTIES_PREFIX)
//@EntityScan("pl.corp.kkf.kkf.services.model")
@EnableJpaRepositories(entityManagerFactoryRef = ENTITY_MANAGER_FACTORY_BEAN_NAME, transactionManagerRef = TRANSACTION_MANAGER, basePackages = REPOSITORY_PACKAGES)
public class KKFModuleConfiguration extends ModuleConfigurationTemplate {

    @Override
    public String getModuleName() {
        return "kkf";
    }

//    @Ov`erride
//    protected String getModelPackage() {
//        return COMMON_ROOT_PACKAGE;
//    }`

    @Override
    @Bean(name = DATA_SOURCE_BEAN_NAME)
    @ConfigurationProperties(DATA_SOURCE_PROPERTIES_NAME)
    public DataSource getDataSource() {
        return super.getDataSource();
    }

    @Bean(name = ENTITY_MANAGER_FACTORY_BEAN_NAME)
    @DependsOn(DATA_SOURCE_BEAN_NAME)
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
        return getEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    @Override
    @Bean(name = TRANSACTION_MANAGER)
    public PlatformTransactionManager getTransactionManager(@Qualifier(ENTITY_MANAGER_FACTORY_BEAN_NAME)
                                                            EntityManagerFactory entityManagerFactory) {
        return super.getTransactionManager(entityManagerFactory);
    }

}

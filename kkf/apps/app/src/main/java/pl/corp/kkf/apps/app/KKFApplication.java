package pl.corp.kkf.apps.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.jms.JmsHealthContributorAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude = {FlywayAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class, JmsHealthContributorAutoConfiguration.class})
@ComponentScan({KKFApplication.ROOT_PACKAGE})
@ConfigurationPropertiesScan({KKFApplication.ROOT_PACKAGE})
@EnableAsync
@OpenAPIDefinition(info = @Info(title = "KKF API", version = "1.0"))
//@EnableConfigurationProperties(ModuleConfigurationTemplate.class)
public class KKFApplication {

    public static final String ROOT_PACKAGE = "pl.corp.kkf";

    public static void main(String[] args) {
        SpringApplication.run(KKFApplication.class, args);
    }

    @Bean
    public ResourceConfig getResourceConfig() {
        return new ServiceResourceConfig();
    }

    @ApplicationPath("/kkf/services")
    static class ServiceResourceConfig extends ResourceConfig {
        public ServiceResourceConfig() {
            packages(ROOT_PACKAGE);
            register(org.glassfish.jersey.media.multipart.MultiPartFeature.class);
        }
    }
}
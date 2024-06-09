package eu.fr.indyli.formation.transactionnel.ecolis.boot;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import eu.fr.indyli.formation.business.config.EcolisBusinessConfig;

@Configuration
@EnableWebMvc
@ComponentScan("eu.fr.indyli.formation.transactionnel.ecolis.controller")
@ComponentScan("eu.fr.insee.formation.transactionnel.ecolis.interceptor")
@ComponentScan("eu.fr.insee.formation.transactionnel.ecolis.modele")
@Import({EcolisBusinessConfig.class})
public class WSConfig implements WebMvcConfigurer {
	
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    @Bean
    WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> enableDefaultServlet() {
        return (factory) -> factory.setRegisterDefaultServlet(true);
    }
}

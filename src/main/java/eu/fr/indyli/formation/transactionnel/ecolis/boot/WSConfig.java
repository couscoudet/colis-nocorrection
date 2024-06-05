package eu.fr.indyli.formation.transactionnel.ecolis.boot;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import eu.fr.indyli.formation.business.config.AppConfig;

@Configuration
@EnableWebMvc
@ComponentScan("eu.fr.indyli.formation.transactionnel.ecolis.controller")
@ComponentScan("eu.fr.insee.formation.transactionnel.ecolis.interceptor")
@ComponentScan("eu.fr.insee.formation.transactionnel.ecolis.modele")
@Import({AppConfig.class})
public class WSConfig implements WebMvcConfigurer {
	
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/resources/**")
          .addResourceLocations("/resources/"); 
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }
    
    @Bean
    public LocaleResolver localeResolver() {
     CookieLocaleResolver slr = new CookieLocaleResolver();
     return slr;
    }
     
    @Bean
    public ResourceBundleMessageSource messageSource() {
     ResourceBundleMessageSource source = new ResourceBundleMessageSource();
     source.setBasenames("messages");  // name of the resource bundle 
     source.setUseCodeAsDefaultMessage(true);
     return source;
    }
    
    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/vues/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    
    @Bean
    WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> enableDefaultServlet() {
        return (factory) -> factory.setRegisterDefaultServlet(true);
    }
}

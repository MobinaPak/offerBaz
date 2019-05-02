package ir.alzahra.offerBaz.config;

import ir.alzahra.offerBaz.view.util.ViewScope;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @Autor: Mobina Pak
 * @Date: 2/5/2019, Sun
 **/

@Configuration
@ComponentScan("ir.alzahra.offerBaz")
public class ContextConfig {
    @Bean
    public static ViewScope viewScope() {
        return new ViewScope();
    }

    /**
     * Allows the use of @Scope("view") on Spring @Component, @Service and @Controller
     * beans
     */
    @Bean
    public static CustomScopeConfigurer scopeConfigurer() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("view", viewScope());
        configurer.setScopes(hashMap);
        return configurer;
    }

}

package ir.alzahra.offerBaz.config;

import ir.alzahra.offerBaz.view.util.ViewScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Autor: Mobina Pak
 * @Date: 2/5/2019, Sun
 **/

@Configuration
@ComponentScan("ir.alzahra.offerBaz")
public class ContextConfig {

    @Autowired
    private ApplicationContext appContext;

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

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    //property config
    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        List<String> sources = new ArrayList<>();
        try {
            Resource[] resources = ((ResourcePatternResolver) appContext).getResources("classpath:spring/*_messages.properties");
            for (Resource resource : resources) {
                try{
                    sources.add("spring/" + resource.getFilename().replace(".properties",""));
                }catch(Throwable t){

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] arr = sources.toArray(new String[sources.size()]);
        messageSource.setBasenames(arr);
        return messageSource;
    }


}

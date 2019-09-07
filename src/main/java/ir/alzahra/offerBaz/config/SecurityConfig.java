package ir.alzahra.offerBaz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //ROLE_ADMIN , ROLE_USER
        //you must set special permissions using these roles
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/web/user/edit.xhtml").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
                .antMatchers("/web/javax.faces.resource/**"
                        , "/web/user/register.xhtml")
                .permitAll()
                .antMatchers("/**").authenticated();
        http
                .headers()
                .addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN));
        http.formLogin().loginPage("/web/login.xhtml").loginProcessingUrl("/web/login.xhtml").permitAll()
                .usernameParameter("user").passwordParameter("pass").defaultSuccessUrl("/web/index.xhtml");

        http.logout().logoutUrl("/web/logout").logoutSuccessUrl("/web/index.xhtml");
        http.exceptionHandling().accessDeniedPage("/web/accessDeniedWebPage.xhtml");

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

}

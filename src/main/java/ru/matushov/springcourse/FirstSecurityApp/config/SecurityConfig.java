package ru.matushov.springcourse.FirstSecurityApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.matushov.springcourse.FirstSecurityApp.services.PersonDetailsService;

//https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final PersonDetailsService personDetailsService;

    @Autowired
    public SecurityConfig(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    //Override auth webview, rules
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //config spring security
        //configure auth
        http.csrf().disable() //TODO enable csrf protect
                .authorizeRequests()
                .antMatchers("/auth/login", "/error", "/auth/registration").permitAll() //access granted to all
                .anyRequest().authenticated() //only after auth
                .and()//go to configure
                .formLogin().loginPage("/auth/login")
                .loginProcessingUrl("/process_login")
                .defaultSuccessUrl("/hello", true)
                .failureUrl("/auth/login?error")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/auth/login"); //logout config, clear cookies + end session
    }

    //Config authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(personDetailsService);
    }

    //TODO PasswordEncode
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}

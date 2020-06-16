package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import service.LogoutSuccessHandler;

@EnableWebSecurity
@ComponentScan("config")
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //authorize requests
        http.authorizeRequests().
        antMatchers("/register").permitAll().
        and().
        authorizeRequests().antMatchers("/user").hasRole("USER").
        and().
        authorizeRequests().antMatchers("/admin").hasRole("ADMIN");

        //login
        http.formLogin().
        loginPage("/login").
        usernameParameter("username").
        passwordParameter("password").
//                .defaultSuccessUrl("/admin")
        failureUrl("/login?error").
        and().
        exceptionHandling().
        accessDeniedPage("/403");

        //logout
        http.logout().
        logoutUrl("/logout").
        logoutSuccessHandler(logoutSuccessHandler);
    }
}

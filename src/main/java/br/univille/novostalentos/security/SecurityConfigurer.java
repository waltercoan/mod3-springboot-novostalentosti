package br.univille.novostalentos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfigurer 
    extends WebSecurityConfigurerAdapter{
        //WebSecurityConfigurerAdapter
    @Autowired
    private UserDetailsService service;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .authorizeRequests().antMatchers("/fonte_dados/**","/api/**","/swagger-ui.html","/webjars/**","/v2/api-docs/**","/swagger-resources/**").permitAll()
        .and().headers().frameOptions().disable()
        .and()
        .authorizeRequests().antMatchers("/**").authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
        .and()
        .formLogin().permitAll().defaultSuccessUrl("/", true)
        .and().logout().permitAll();
        
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(service);
    }

    
}

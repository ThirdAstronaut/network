package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class SecurityConfiguration extends ResourceServerConfigurerAdapter {



    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated();

        /*  http.authorizeRequests()
                .antMatchers("/index", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();;
*/
        /*http
           *//*     .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
           *//*   //  .antMatcher("/api/**")
                .authorizeRequests()

                .antMatchers("/api/signin**").permitAll()
                .antMatchers("/api/signin/**").permitAll()
                .antMatchers("/api/glee**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/api/users**").hasAuthority("ADMIN")
                .antMatchers("/api/**").authenticated()
                .anyRequest().authenticated()

        ;*/
    /*   http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors().and().csrf().disable()
//                .antMatcher("/api/**")
                .authorizeRequests()
                .antMatchers("/api/signin**").permitAll()
                .antMatchers("/api/signin/**").permitAll()
                .antMatchers("/api/glee/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/api/users/**").hasAuthority("ADMIN")
                .antMatchers("/api/**").authenticated()
                .anyRequest().authenticated();
             //   .and().exceptionHandling().authenticationEntryPoint(customAuthenticationEntryPoint).accessDeniedHandler(new CustomAccessDeniedHandler());
    */
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("api");
    }
}
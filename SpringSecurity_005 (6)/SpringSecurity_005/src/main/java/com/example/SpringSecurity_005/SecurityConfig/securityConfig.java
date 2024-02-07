package com.example.SpringSecurity_005.SecurityConfig;

import com.example.SpringSecurity_005.config.UserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.CachingUserDetailsService;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
     public UserDetailsService getUserDetailService(){
        return new UserDetailService();
    }



    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
          DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
          authenticationProvider.setUserDetailsService(getUserDetailService());
          authenticationProvider.setPasswordEncoder(passwordEncoder());
          return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf->csrf.disable())
                .authorizeRequests(authorize -> authorize
                        .requestMatchers("/").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin->formLogin.loginPage("/login").loginProcessingUrl("/userLogin").defaultSuccessUrl("/profile").permitAll());
        return http.build();

    }
}

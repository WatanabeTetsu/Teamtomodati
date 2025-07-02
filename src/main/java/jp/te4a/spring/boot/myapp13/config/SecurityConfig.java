package jp.te4a.spring.boot.myapp13.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jp.te4a.spring.boot.myapp13.service.LoginUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private LoginUserDetailsService loginUserDetailsService;

    public void configureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(login -> login
            .loginProcessingUrl("/login")
            .loginPage("/loginForm")
            .defaultSuccessUrl("/facilities", true) // 書籍 → 設備
            .failureUrl("/loginForm?error")
            .usernameParameter("username").passwordParameter("password")
            .permitAll()
        ).logout(logout -> logout
            .logoutSuccessUrl("/loginForm")
        ).authorizeHttpRequests(authz -> authz
            .requestMatchers("/webjars/**", "/css/**").permitAll()
            .requestMatchers("/loginForm").permitAll()
            .requestMatchers("/users").permitAll()
            .requestMatchers("/users/create").permitAll()
            .anyRequest().authenticated()
        );
        return http.build();
    }
}

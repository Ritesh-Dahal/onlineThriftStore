package com.example.online.thrift.store.config;



import com.example.online.thrift.store.filter.JwtAuthFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

     private JwtAuthFilter jwtAuthFilter;

@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{

        return http.
                authorizeHttpRequests(auth->
                        auth.requestMatchers("/api/auth/**").permitAll()
              //                  .requestMatchers("/api/auth/products").permitAll()
                         .anyRequest().authenticated())
                            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                         .csrf(csrf -> csrf.disable())
                         .build();

    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService,PasswordEncoder passwordEncoder){

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);

            return  new ProviderManager(daoAuthenticationProvider);


    }
}

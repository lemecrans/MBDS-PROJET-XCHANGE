package com.mbds.xchange.configuration;

import com.mbds.xchange.filter.JwtFilter;
import com.mbds.xchange.service.UtilisateurDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

   private final UtilisateurDetailService utilisateurDetailService;

   private final JwtUtils jwtUtils;

   @Bean
   public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }
   @Bean
   public AuthenticationManager authenticationManager(HttpSecurity http,PasswordEncoder passwordEncoder) throws Exception {
       AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
       authenticationManagerBuilder.userDetailsService(utilisateurDetailService).passwordEncoder(passwordEncoder);
       return authenticationManagerBuilder.build();
   }
   @Bean
   public SecurityFilterChain  securityFilterChain(HttpSecurity http) throws Exception {
       return http
               .csrf(AbstractHttpConfigurer::disable)
               .authorizeHttpRequests(auth ->
                       auth.requestMatchers("/api/auth/*").permitAll()
                               .requestMatchers(HttpMethod.GET, "/api/objet").permitAll()
                               .requestMatchers(HttpMethod.GET, "/api/objet/{idObjet:[0-9]+}").permitAll()
                               .anyRequest().authenticated())
               .addFilterBefore(new JwtFilter(utilisateurDetailService,jwtUtils), UsernamePasswordAuthenticationFilter.class)
               .build();
   }
}

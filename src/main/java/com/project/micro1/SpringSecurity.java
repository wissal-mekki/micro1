package com.project.micro1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {
@Autowired
private UserDetailsService  userDetailsService ;

@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoder  ;

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws  Exception{

        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder) ;

    }

   @Override
    protected void  configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable();
       httpSecurity.cors().disable() ;
       httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

       httpSecurity.authorizeRequests().antMatchers("/login","/api/signUp").permitAll();
       httpSecurity.exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint());
       httpSecurity.authorizeRequests().antMatchers(HttpMethod.GET,"/api/**").hasAuthority("USER");
       httpSecurity.authorizeRequests().antMatchers(HttpMethod.POST,"/api/**").hasAuthority("USER");
       httpSecurity.authorizeRequests().antMatchers(HttpMethod.PUT,"/api/**").hasAuthority("USER");
       httpSecurity.authorizeRequests().antMatchers(HttpMethod.DELETE,"/api/**").hasAuthority("ADMIN");
       httpSecurity.authorizeRequests().anyRequest().authenticated() ;
       httpSecurity.addFilter(new JWTAuthenticationFilter(authenticationManager()));
       httpSecurity.addFilterBefore(new JWTAuthorizationFilter(),
               UsernamePasswordAuthenticationFilter.class);
   }
}

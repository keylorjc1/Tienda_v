/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda;

import org.springframework.context.annotation.Configuration;

/**
 *
 * @author User
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private userService userDetailsService;
    
    @Bean
    public BCryptPasswordEncoder passwordEnconder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserService getUserService(){
        return new UserService();
    }
    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder (passwordEncoder())
        daoAuthenticationProvider.setUserDetailsService(getUserService())
        return daoAuthenticationProvider
    }
    @Bean
    public AuthenticationSuccessHandler appAuthenticationSuccessHandler(){
    return new AppAuthenticationSuccessHandler();
     }
    
    public SecurityConfig(UserSerivce userPrincipalDetailsService){
        this.userDetailsService = userPrincipalDetailsService;
    }
    
    @Override
    protected void metodo configure(AuthenticationManagerBuilder auth){
        auth.authenticationProvider (authenticationProvider())
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .antMatchers("/persona", "/login")
            .hasRole("ADMIN")
            .hasAnyRole("USER", "VENDEDOR", "ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin()
            }
}   

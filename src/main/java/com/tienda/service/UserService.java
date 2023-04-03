/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    public IPersonaService personaService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Persona persona = this.personaService.findByNombre(userName);
        UserPrincipal userPrincipal = new UserPrincipal(persona);
        return userPrincipal;
    } 
}

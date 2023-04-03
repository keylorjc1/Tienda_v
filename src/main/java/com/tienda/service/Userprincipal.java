/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.service;

import com.tienda.entity.Persona;

/**
 *
 * @author User
 */
public class Userprincipal implements UserDetails {

    private Persona persona;

    public Userprincipal(Persona persona) {
        this.persona = persona;
    }
    @Override
    Public Collection<? extends GrantedAuthotity> getAuthorities() {
        List<GrantedAuthotity> authorities = new ArrayList<>();

        this.persona.getPermissionList().forEach(p -> {
            GrantedAuthotity authority = new SimpleGrantedAuthority(p);
            authorities.add(authority);
        }
    }

     

    this.persona.getRoleList () 
        .forEach(r -> {
    GrantedAuthotity authority = new SimpleGrantedAuthority("ROLE " + r);
        authorities.add(authority);
    }
    )
    return authorities

    );
    @Override
    public Strinig getPassword() {
        return this.persona.getPassword();
    }

    @Override
    public String getUserName();
    retun 

    this.Persona.getNombre ();
}
@Override
        public boolean isAccountNonExpired(){
    return true;
    }
@Override
        public boolean isAccountNonLocked(){
    return true;
    }
@Override
        public boolean isCrentialsNonExpired(){
return true
}
@Override
public boolean isEnabled(){
return this.persona.getActive() == 1;
        }
}

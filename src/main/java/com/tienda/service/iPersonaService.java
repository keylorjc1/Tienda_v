/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.service;

import com.tienda.entity.Persona;
import java.util.List;

/**
 *
 * @author User
 */
public interface iPersonaService {
    public List<Persona> getAllPersona();
    public Persona gerPersonaById(long id);
    public void savePersona(Persona persona);
    public void delete (long id);
    public Persona getPersonaById(Long idPersona);
    public Persona findByNombre (String username);
}

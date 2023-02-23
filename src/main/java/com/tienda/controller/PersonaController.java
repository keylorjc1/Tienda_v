/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.controller;


import com.tienda.entity.Pais;
import com.tienda.entity.Persona;
import com.tienda.service.iPaisService;
import com.tienda.service.iPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author User
 */

@Controller
public class PersonaController {
    @Autowired
    private iPersonaService personaService;
    
    @Autowired
    private iPaisService paisService;
    
    @GetMapping("/persona")
    public String index(Model model) {
        List<Persona> listaPersona = personaService.getAllPersona();
        model.addAttribute("titulo", "Tabla Persona");
        model.addAttribute("personas", listaPersona);
        return "personas";
}
    
    @GetMapping("/personaN")
    public String crearPersona(Model model) {
        List<Pais> listaPaises = paisService.listCountry();
        model.addAttribute("persona", new Persona());
        model.addAttribute("paises", listaPaises);
        return "crear";
    }
}
    


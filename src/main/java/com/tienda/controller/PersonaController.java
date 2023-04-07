package com.tienda.controller;

import com.tienda.entity.Pais;
import com.tienda.entity.Persona;
import com.tienda.repository.PersonaRepository;
import com.tienda.service.IPaisService;
import com.tienda.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //La clase se va a comportar como controlador
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IPaisService paisService;

    @GetMapping("/persona")  //localhost/persona
    public String index(Model model) {  //El model funciona para pasar por medio del metodo Attribute la informacion que queremos enviar al html
        List<Persona> listaPersona = personaService.getAllPersona();
        model.addAttribute("titulo", "Tabla Personas");
        model.addAttribute("personas", listaPersona);
        return "personas";
    }

    @GetMapping("/personaN")
    public String crearPersona(Model model) { //Model es un objeto Spring que nos permite enviar info al html y viceversa, pero la info no viene de base de datos
        List<Pais> listaPaises = paisService.listCountry();
        model.addAttribute("persona", new Persona());
        model.addAttribute("paises", listaPaises);
        return "crear";
    }

    @GetMapping("/delete/{id}")
    public String eliminarPersona(@PathVariable("id") Long idPersona) {
        personaService.delete(idPersona);
        return "redirect:/persona";
    }

    @PostMapping("/save")
    public String guardarPersona(@ModelAttribute Persona persona) {
        personaService.savePersona(persona);
        return "redirect:/persona";
    }

    @GetMapping("/editPersona/{id}")
    public String editarPersona(@PathVariable("id") Long idPersona, Model model) {
        Persona persona = personaService.getPersonaById(idPersona);
        List<Pais> listaPaises = paisService.listCountry();
        model.addAttribute("persona", persona);
        model.addAttribute("paises", listaPaises);
        return "crear";
    }

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping("/byApellido")
    public String buscarPorApellido(@RequestParam("apellido") String apellido, Model model) {
        List<Persona> listaPersonas = personaRepository.findByApellido(apellido);
        System.out.println("Número de resultados encontrados: " + listaPersonas.size());
        model.addAttribute("listaPersonas", listaPersonas);
        return "ByApellido";
    }
}
package com.daily.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daily.models.Usuario;

@Controller
public class IndexController {
    //http://localhost:8080
    @RequestMapping("/") //anotacion para caputar las rutas
    public String index(Model model) {

        //Instancia de usuario
        Usuario usuario = new Usuario();

        // Pasando el usuario a la vista JSP
        model.addAttribute("usuario", usuario);

        return "index.jsp";
    }

}
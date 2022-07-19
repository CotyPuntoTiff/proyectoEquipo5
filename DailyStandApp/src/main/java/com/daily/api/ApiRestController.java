package com.daily.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daily.models.Usuario;
import com.daily.services.UsuarioService;

@RestController
@RequestMapping("/api")
public class ApiRestController {

    /* Inyección de dependencia */
    @Autowired
    UsuarioService usuarioService;

    @RequestMapping("/obtener/usuarios") // URL, por donde se obtendran los datos
    public List<Usuario> listaUsuarios() {// Crea lista de usuarios
        List<Usuario> listaUsuarios = usuarioService.findAll();// se llena la listaUsuarios con los valores optenidos
                                                               // desde la DB
        return listaUsuarios;// Retorna la lista
    }
}

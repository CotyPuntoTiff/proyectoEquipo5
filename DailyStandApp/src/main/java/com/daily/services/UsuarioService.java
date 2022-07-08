package com.daily.services;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daily.Repositories.UsuarioRepository;
import com.daily.models.Usuario;

@Service
@Transactional
public class UsuarioService {

    // Inyeccion de dependencia usuario
    @Autowired
    UsuarioRepository usuarioRepository;

    public void saveUsuario(@Valid Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll() {// metodo para obtener los usuarios
        return usuarioRepository.findAll();
    }

}

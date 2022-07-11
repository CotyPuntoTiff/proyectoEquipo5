package com.daily.services;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
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




    
    //notas de la clase lunes 11 por la tarde
    public boolean saveUsuarioNoExistente (Usuario usuario) {
        //validaciones de insercion (crear o registrar usuario)
        //1.- validar si email existe en la bd
        Usuario existeUsuario = usuarioRepository.FindByCorreo(usuario.getCorreo());

        //si no existe el usuario lo creamos
        if(existeUsuario ==null){

            //2.- encriptar password
            String passEncriptado = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());

            usuarioRepository.save(usuario);
            return false;
        }
        //si existe, retornamos un boolean true
        else{
            return true;//error en la creacion o ya existe
        }
    }






    public void saveUsuario(@Valid Usuario usuario) {

        usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll() {// metodo para obtener los usuarios
        return usuarioRepository.findAll();
    }

}

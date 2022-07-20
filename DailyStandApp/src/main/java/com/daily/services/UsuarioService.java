package com.daily.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daily.repositories.UsuarioRepository;
import com.daily.models.Usuario;

@Service
@Transactional
public class UsuarioService {

	// Inyeccion de dependencia usuario
	@Autowired
	UsuarioRepository usuarioRepository;

	public boolean saveUsuario(@Valid Usuario usuario) {
		// validaciones de insercion
		/* 1-. Validar si email existe en la base de datos */
		Usuario existeUsuario = usuarioRepository.findByCorreo(usuario.getCorreo());

		// No existe el usuario, lo creamos
		if (existeUsuario == null) {
		/*2-. encriptar el usuario*/
			String passwordEncriptado = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
			usuario.setPassword((passwordEncriptado));
			
			usuarioRepository.save(usuario);
			return false;
		}
		// Si existe, retorneamos un boolean true
		else {
			return true;//error en la creaciÃ³n, el usuario ya existe
		}
	}

	public List<Usuario> findAll() {// metodo para obtener los usuarios
		return usuarioRepository.findAll();
	}

	public boolean validarUsuario(String correo, String password) {
		//verificar email
		boolean error =true;
		Usuario existeUsuario = usuarioRepository.findByCorreo(correo);
		if(existeUsuario == null) {
			//no existe, error de ingreso, o email no registrado
			error = true;
		}else {
			// verificar password contra password base de datos desencriptada
			if(BCrypt.checkpw(password, existeUsuario.getPassword())) {
				//si los password son iguales 
				error = false;//no hay error porque los password son iguales así que el usuario puede iniciar sesión
			}else {
				//password distintos, porque no esta registrado en la base de datos y no puede iniciar sesión
				error = true;
			}
		}
		return error;
	}

}

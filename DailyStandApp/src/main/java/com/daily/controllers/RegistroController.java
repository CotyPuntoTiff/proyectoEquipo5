package com.daily.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daily.models.Usuario;
import com.daily.services.UsuarioService;

@Controller
@RequestMapping("/registro")
public class RegistroController {
	// inyeccion de dependencias
	@Autowired
	UsuarioService usuarioService;

	// Ruta para desplegar el JSP
	// localhost:8080/registro
	@RequestMapping("")
	public String registro(@ModelAttribute("usuario") Usuario usuario) {
		// pasamos el objeto sin atributos

		return "registro.jsp"; // PÃ¡gina a desplegar
	}

	@PostMapping("/usuario")
	public String guardarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult resultado,
			Model model) {

		if (resultado.hasErrors()) { // capturando si existe error en el ingreso de datos
			model.addAttribute("msgError", "Debe ingresar los datos correctamente");
			return "registro.jsp";
		} else {
			// Capturamos el objeto con los atributos llenos
			List<Usuario> listaUsuario = usuarioService.findAll();// creamos el metodo en service
			model.addAttribute("usuarioCapturado", listaUsuario);// mostrar la lista en el jsp

			// Enviar el objeto al service
			boolean usuarioCreado = usuarioService.saveUsuario(usuario);

			// usuario creado
			if (usuarioCreado) {
				model.addAttribute("msgError", "El email ya esta registrado");
				return "registro.jsp";
			} else {
				return "login.jsp";// ingresa el email y password para dejarte entrar, por seguridad
			}
		}
	}
	
	@RequestMapping("/usuario/ingreso")
	public String ingresoUsuario(@RequestParam(value="correo") String correo,
			@RequestParam(value="password") String password,
			Model model, HttpSession session,
			@ModelAttribute("usuario") Usuario usuario) {
		//validaciones
		//que no sea nulo o vacios
		if(correo == null || password == null || correo.isEmpty() || password.isEmpty()) {
			model.addAttribute("msgError", "Todos los campos son obligatorios");
			return "login.jsp";
		}
		//si es true indica que hay un error en la base de datos
		boolean usuarioValidado = usuarioService.validarUsuario(correo, password);
		
		if(usuarioValidado) {
			model.addAttribute("msgError", "Error en el ingreso al sistema");
			return "login.jsp";
		}else {
			//no hay error y puede ingrasar al sistema
			session.setAttribute("correo", correo);
			return "home.jsp";
		}
	}
	
	@RequestMapping("/usuario/login")
	public String login() {
		return "login.jsp";
	}
}

package com.daily.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String home(HttpSession session) {
		
		String correo = (String) session.getAttribute("correo");
		if(correo == null || correo.equals("")) {
			return "redirect:/registro/usuario/login";
		}else {
			return "home.jsp";
		}
		
		
	}

}

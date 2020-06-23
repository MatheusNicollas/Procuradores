package com.controlePREs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.controlePREs.models.Usuario;

@Controller
public class UsuarioController {
	
	@RequestMapping("/")
	public String login() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String logar(Usuario u, RedirectAttributes ra) {
		
		if(u.getLogin().equals("admin") && u.getSenha().equals("1234")){
			return "redirect:/listaDeProcuradores";
		}else{
			ra.addFlashAttribute("mensagem", "Login Inválido");
			return "redirect:/";
		}	
	}
	
}

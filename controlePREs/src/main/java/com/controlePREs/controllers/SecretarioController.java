package com.controlePREs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.controlePREs.DAO.SecretarioDAO;
import com.controlePREs.models.Secretario;

@Controller
public class SecretarioController {
	
	@Autowired
	private SecretarioDAO sDAO;
	
	@GetMapping("/cadastrarSecretario")	
	public String formScretario() {
		
		return "secretario/formSecretario";
	}
	
	@PostMapping("/cadastrarSecretario")
	public String cadastraSecretario(Secretario s) {
		
		sDAO.save(s); 
		
		return "redirect:/listaDeSecretarios";
	}
	
	@GetMapping("/listaDeSecretarios")
	public ModelAndView listaSecretarios() {
		
		ModelAndView mv = new ModelAndView("secretario/listaSecretarios");
		Iterable<Secretario> s = sDAO.findAll();
		mv.addObject("secretarios", s);
		
		return mv;
	}
	
	@GetMapping(value="/buscaSecretario", produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Secretario buscaPorId(int id) {
		
		Secretario s = sDAO.findById(id);
        return s;
    }
	
	@GetMapping(value="/deletarSecretario", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String deletaSecretario(long id) {

		Secretario s = sDAO.findById(id);
		sDAO.delete(s);
		
		return "{\"mensagem\": \"ok\"}";		
	}
}

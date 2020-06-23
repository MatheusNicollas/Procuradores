package com.controlePREs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.controlePREs.DAO.SubstitutoDAO;
import com.controlePREs.models.Procurador;
import com.controlePREs.models.Substituto;

@Controller
public class SubstitutoController {

	@Autowired
	private SubstitutoDAO sDAO;
	
	@GetMapping("/cadastrarSubstituto")	
	public String formSub() {
		
		return "substituto/formSubstituto";
	}
	
	@PostMapping("/cadastrarSubstituto")
	public String cadastraSubstituto(Substituto s) {
		
		sDAO.save(s); 
		
		return "redirect:/listaDeSubstitutos";
	}
	
	@GetMapping("/listaDeSubstitutos")
	public ModelAndView listaSubstitutos() {
		
		ModelAndView mv = new ModelAndView("substituto/listaSubstitutos");
		Iterable<Substituto> s = sDAO.findAll();
		mv.addObject("substitutos", s);
		
		return mv;
	}
	
	@GetMapping(value="/buscaSubstituto", produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Substituto buscaPorId(int id) {
		
		Substituto s = sDAO.findById(id);
        return s;
    }
	
	@GetMapping(value="/deletarSubstituto", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String deletaProcurador(long id) {

		Substituto s = sDAO.findById(id);
		sDAO.delete(s);
		
		return "{\"mensagem\": \"ok\"}";		
	}
	
}

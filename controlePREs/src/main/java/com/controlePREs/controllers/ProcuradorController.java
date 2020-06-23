package com.controlePREs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.controlePREs.DAO.ProcuradorDAO;
import com.controlePREs.DAO.SecretarioDAO;
import com.controlePREs.DAO.SubstitutoDAO;
import com.controlePREs.models.Procurador;
import com.controlePREs.models.Secretario;
import com.controlePREs.models.Substituto;

@Controller
public class ProcuradorController {
	
	@Autowired
	private ProcuradorDAO pDAO;
	
	@Autowired
	private SubstitutoDAO sDAO;
	
	@Autowired
	private SecretarioDAO secDAO;
	
	@GetMapping("/cadastrarProcurador")	
	public ModelAndView form() {
		
		ModelAndView mv = new ModelAndView("procurador/formProcurador");
		
		Iterable<Substituto> s = sDAO.findAll();
		mv.addObject("substitutos", s);
		
		Iterable<Secretario> sec = secDAO.findAll();	
		mv.addObject("secretarios", sec);
		
		return mv;
	}
	
	@PostMapping("/cadastrarProcurador")
	public String cadastraProcurador(@RequestParam int substituto_id, @RequestParam int secretario_id, Procurador p) {
		
		Substituto s = sDAO.findById(substituto_id);
		p.setSubstituto(s);
		
		Secretario sec = secDAO.findById(secretario_id);
		p.setSecretario(sec);
		
		pDAO.save(p);
		return "redirect:/listaDeProcuradores";
	}
	
	@GetMapping("/listaDeProcuradores")
	public ModelAndView listarProcuradores() {
		
		ModelAndView mv = new ModelAndView("procurador/listaProcuradores");
		Iterable<Procurador> p = pDAO.findAll();
		mv.addObject("procuradores", p);
		
		Iterable<Substituto> s = sDAO.findAll();
		mv.addObject("substitutos", s);
		
		Iterable<Secretario> sec = secDAO.findAll();	
		mv.addObject("secretarios", sec);
		
		return mv;
	}
	
	@GetMapping(value="/deletarProcurador", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String deletaProcurador(int id) {

		Procurador p = pDAO.findById(id);
		pDAO.delete(p);
		
		return "{\"mensagem\": \"ok\"}";		
	}
	
	@GetMapping(value="/{id}")
	public ModelAndView detalhaProcurador(@PathVariable("id") long id) {
		
		Procurador p = pDAO.findById(id);
		ModelAndView mv = new ModelAndView("procurador/detalhesProcurador");
		mv.addObject("procurador", p);
		
		Substituto s = sDAO.findById(p.getSubstituto().getId());
		mv.addObject("substituto", s);
		
		Secretario sec = secDAO.findById(p.getSecretario().getId());
		mv.addObject("secretario", sec);
		
		Iterable<Substituto> sList = sDAO.findAll();
		mv.addObject("substitutos", sList);
		
		Iterable<Secretario> secList = secDAO.findAll();	
		mv.addObject("secretarios", secList);
		
		return mv;
	}
	
	@GetMapping(value="/buscaProcurador", produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Procurador buscaPorId(int id) {
		
		Procurador p = pDAO.findById(id);
		
        return p;
    }
	
}

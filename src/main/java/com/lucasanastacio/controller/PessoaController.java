package com.lucasanastacio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lucasanastacio.model.Pessoa;
import com.lucasanastacio.repository.PessoaRepository;

@Controller
@RequestMapping(value = "/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepo;
	
	
	@GetMapping
	public String getPessoas(Model model) {
		
		List<Pessoa> listaPessoas = pessoaRepo.findAll();
		model.addAttribute("listaPessoas", listaPessoas);
		
		return "pessoa/listagem";
	}
	
	@GetMapping(value = "/novo")
	public String novaPessoa(Pessoa pessoa) {
		return "pessoa/cadastro";
	}
	
	@PostMapping(value = "/salvar")
	public String salvarPessoa(Pessoa pessoa) {
		
		pessoaRepo.save(pessoa);
		
		return "redirect:/pessoa";
	}
	

}

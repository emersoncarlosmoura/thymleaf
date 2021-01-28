package com.emerson.curso.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.emerson.curso.boot.domain.Cargo;
import com.emerson.curso.boot.domain.Funcionario;
import com.emerson.curso.boot.domain.UF;
import com.emerson.curso.boot.servico.CargoService;
import com.emerson.curso.boot.servico.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping("/cadastrar")
	public String cadastrar (Funcionario funcionario) {
		return"/funcionario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar () {
		return"/funcionario/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar (Funcionario funcionario, RedirectAttributes redirect) {
		funcionarioService.salvar(funcionario);
		redirect.addFlashAttribute("success", "Funcionario inserido com sucesso");
		return"redirect:/funcionarios/cadastrar";
	}
	
	@ModelAttribute("cargos")
	public List<Cargo> listaDeCargos () {
		return cargoService.buscarTodos();
	}
	
	@ModelAttribute("ufs")
	public UF[] listaDeUf () {
		return UF.values();
	}

}

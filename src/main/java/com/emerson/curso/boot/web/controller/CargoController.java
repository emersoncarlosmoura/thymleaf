package com.emerson.curso.boot.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.emerson.curso.boot.domain.Cargo;
import com.emerson.curso.boot.domain.Departamento;
import com.emerson.curso.boot.servico.CargoService;
import com.emerson.curso.boot.servico.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {
	
	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@GetMapping("/cadastrar")
	public String cadastrar (Cargo cargo) {
		return"/cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar (ModelMap model) {
		model.addAttribute("cargos", cargoService.buscarTodos());
		return"/cargo/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar (@Valid Cargo cargo, BindingResult result, RedirectAttributes redirect) {
		
		if (result.hasErrors()) {
			return "cargo/cadastro";
		}
		
		cargoService.salvar(cargo);
		redirect.addFlashAttribute("success", "Cargo inserido com sucesso");
		return"redirect:/cargos/cadastrar";
	}
	
	@ModelAttribute("departamentos")
	public List<Departamento> listaDeDepartamentos () {
		return departamentoService.buscarTodos();
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar (@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cargo", cargoService.buscarPorId(id));
		return"/cargo/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar (@Valid Cargo cargo, BindingResult result, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return "cargo/cadastro";
		}
		
		cargoService.editar(cargo);
		attributes.addFlashAttribute("success", "Cargo atualizado com sucesso");
		return"redirect:/cargos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir (@PathVariable("id") Long id, RedirectAttributes attributes) {
		if (cargoService.cargoTemFuncionarios(id)) {
			attributes.addFlashAttribute("fail", "Cargo possui funcionario(s) vinculado(s).");
		} else {
			cargoService.excluir(id);
			attributes.addFlashAttribute("success", "Cargo excluído com sucesso");
		}
		return "redirect:/cargos/listar";
	}

}

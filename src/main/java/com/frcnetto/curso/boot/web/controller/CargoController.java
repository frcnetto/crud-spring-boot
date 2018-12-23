package com.frcnetto.curso.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frcnetto.curso.boot.domain.Cargo;
import com.frcnetto.curso.boot.service.CargoService;

@Controller
@RequestMapping("cargos")
public class CargoController {
	
	@Autowired
	private CargoService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {
		return "/cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cargos", service.buscarTodos());
		return "/cargo/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Cargo cargo) {
		service.salvar(cargo);
		return "/cargo/cadastro";
	}

}

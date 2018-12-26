package com.frcnetto.curso.boot.web.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.frcnetto.curso.boot.domain.Cargo;
import com.frcnetto.curso.boot.domain.Funcionario;
import com.frcnetto.curso.boot.domain.UF;
import com.frcnetto.curso.boot.service.CargoService;
import com.frcnetto.curso.boot.service.FuncionarioService;
import com.frcnetto.curso.boot.web.validator.FuncionarioValidator;

@Controller
@RequestMapping( "/funcionarios" )
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private CargoService cargoService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators( new FuncionarioValidator() );
	}

	@GetMapping( "/cadastrar" )
	public String cadastrar( Funcionario funcionario ) {
		return "/funcionario/cadastro";
	}

	@GetMapping( "/listar" )
	public String listar( ModelMap model ) {

		model.addAttribute( "funcionarios", funcionarioService.buscarTodos() );
		return "/funcionario/lista";

	}

	@PostMapping( "/salvar" )
	public String salvar( @Valid Funcionario funcionario, BindingResult result, ModelMap model ) {

		if ( result.hasErrors() )
			return "/funcionario/cadastro";

		try {
			funcionarioService.salvar( funcionario );
			model.addAttribute( "success", "Funcionario salvo com sucesso." );
		}

		catch ( Exception e ) {
			model.addAttribute( "fail", "Não foi possível inserir o funcionario. Erro: " + e.getMessage() );
		}

		return listar( model );
	}

	@GetMapping( "/editar/{id}" )
	public String preEditar( @PathVariable( "id" ) Long id, ModelMap model ) {
		model.addAttribute( "funcionario", funcionarioService.buscarPorId( id ) );
		return "funcionario/cadastro";
	}

	@PostMapping( "/editar" )
	public String editar( @Valid Funcionario funcionario, BindingResult result, ModelMap model ) {

		if ( result.hasErrors() )
			return "/funcionario/cadastro";

		try {
			funcionarioService.editar( funcionario );
			model.addAttribute( "success", "Funcionário editado com sucesso." );
		}

		catch ( Exception e ) {
			model.addAttribute( "fail", "Não foi possível editar o funcionario. Erro: " + e.getMessage() );
		}

		return "redirect:/funcionarios/cadastrar";
	}

	@GetMapping( "/excluir/{id}" )
	public String excluir( @PathVariable( "id" ) Long id, ModelMap model ) {

		try {
			funcionarioService.excluir( id );
			model.addAttribute( "success", "Funcionário removido com sucesso." );
		}

		catch ( Exception e ) {
			model.addAttribute( "fail", "Não foi possível remover o funcionario. Erro: " + e.getMessage() );
		}

		return "redirect:/funcionarios/listar";
	}

	@GetMapping( "/buscar/nome" )
	public String buscaPorNome( @RequestParam( "nome" ) String nome, ModelMap model ) {
		model.addAttribute( "funcionarios", funcionarioService.buscaPorNome( nome ) );
		return listar( model );
	}

	@GetMapping( "/buscar/cargo" )
	public String buscaPorCargo( @RequestParam( "id" ) Long id, ModelMap model ) {
		model.addAttribute( "funcionarios", funcionarioService.buscarPorCargo( id ) );
		return "/funcionario/lista";
	}

	@GetMapping( "/buscar/data" )
	public String buscaPorDatas(
			@RequestParam( "entrada" ) @DateTimeFormat( iso = DateTimeFormat.ISO.DATE ) LocalDate entrada,
			@RequestParam( "saida" ) @DateTimeFormat( iso = DateTimeFormat.ISO.DATE ) LocalDate saida,
			ModelMap model ) {

		model.addAttribute( "funcionarios", funcionarioService.buscarPorDatas( entrada, saida ) );
		return "/funcionario/lista";
	}

	@ModelAttribute( "cargos" )
	public List< Cargo > listaCargos() {
		return cargoService.buscarTodos();
	}

	@ModelAttribute( "ufs" )
	public UF[] listaUFs() {
		return UF.values();
	}

}

package com.frcnetto.curso.boot.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frcnetto.curso.boot.domain.Departamento;
import com.frcnetto.curso.boot.service.DepartamentoService;

@Controller
@RequestMapping( "/departamentos" )
public class DepartamentoController {

	@Autowired
	private DepartamentoService service;

	@GetMapping( "/cadastrar" )
	public String cadastrar( Departamento departamento ) {
		return "/departamento/cadastro";
	}

	@GetMapping( "/listar" )
	public String listar( ModelMap model ) {
		model.addAttribute( "departamentos", service.buscarTodos() );
		return "/departamento/lista";
	}

	@PostMapping( "/salvar" )
	public String salvar( @Valid Departamento departamento, BindingResult result, ModelMap model ) {
		
		if (result.hasErrors())
			return "/departamento/cadastro";
		
		try {
			
			service.salvar( departamento );
			model.addAttribute( "success", "Departamento inserido com sucesso." );
			
		}
		
		catch (Exception e) {
			model.addAttribute( "fail", "Falha na inserção do departamento. " + e.getMessage() );
		}
		
		
		return listar( model );
	}

	@GetMapping( "/editar/{id}" )
	public String preparaEdicao( @PathVariable( "id" ) Long primaryKey, ModelMap model ) {
		model.addAttribute( "departamento", service.buscarPorId( primaryKey ) );
		return "/departamento/cadastro";
	}

	@PostMapping( "/editar" )
	public String editar( @Valid Departamento departamento, BindingResult result, ModelMap model ) {

		if (result.hasErrors())
			return "/departamento/cadastro";
		
		try {

			service.editar( departamento );
			model.addAttribute( "success", "Departamento atualizado com sucesso." );

		}

		catch ( Exception e ) {
			model.addAttribute( "fail", "Falha na edição do departamento. " + e.getMessage() );
		}

		return listar( model );
	}

	@GetMapping( "/excluir/{id}" )
	public String excluir( @PathVariable( "id" ) Long primaryKey, ModelMap model ) {

		if ( !service.temCargos( primaryKey ) ) {
			
			service.excluir( primaryKey );
			model.addAttribute( "success", "Departamento excluído com sucesso." );
		
		} 
		
		else {
			model.addAttribute( "fail", "Falha na exclusão. Foram encontrados cargos vinculados a este departamento." );
		}

		return listar( model );
	}
}

package com.frcnetto.curso.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frcnetto.curso.boot.domain.Cargo;
import com.frcnetto.curso.boot.domain.Departamento;
import com.frcnetto.curso.boot.service.CargoService;
import com.frcnetto.curso.boot.service.DepartamentoService;

@Controller
@RequestMapping( "cargos" )
public class CargoController {

	@Autowired
	private CargoService cargoService;

	@Autowired
	private DepartamentoService departamentoService;

	@GetMapping( "/cadastrar" )
	public String cadastrar( Cargo cargo ) {
		return "/cargo/cadastro";
	}

	@GetMapping( "/listar" )
	public String listar( ModelMap model ) {

		model.addAttribute( "cargos", cargoService.buscarTodos() );
		return "/cargo/lista";

	}

	@PostMapping( "/salvar" )
	public String salvar( Cargo cargo, ModelMap model ) {

		try {
			cargoService.salvar( cargo );
			model.addAttribute( "success", "Cargo salvo com sucesso." );
		}

		catch ( Exception e ) {
			model.addAttribute( "fail", "Não foi possível inserir o cargo. Erro: " + e.getMessage() );
		}

		return listar( model );
	}

	@ModelAttribute( "departamentos" )
	public List< Departamento > listaDepartamentos() {
		return departamentoService.buscarTodos();
	}

	@GetMapping( "/editar/{id}" )
	public String preparaEdicao( @PathVariable( "id" ) Long primaryKey, ModelMap model ) {

		model.addAttribute( "cargo", cargoService.buscarPorId( primaryKey ) );

		return "/cargo/cadastro";
	}

	@PostMapping( "/editar" )
	public String editar( Cargo cargo, ModelMap model ) {

		try {

			cargoService.editar( cargo );
			model.addAttribute( "success", "Cargo atualizado com sucesso." );

		}

		catch ( Exception e ) {
			model.addAttribute( "fail", "Falha na edição do cargo. Erro: " + e.getMessage() );
		}

		return listar( model );
	}

	@GetMapping( "/excluir/{id}" )
	public String excluir( @PathVariable( "id" ) Long primaryKey, ModelMap model ) {

		try {

			if ( !cargoService.temFuncionarios( primaryKey ) ) {

				cargoService.excluir( primaryKey );
				model.addAttribute( "success", "Cargo excluído com sucesso." );

			}
			
			else {
				model.addAttribute( "fail", "Falha na exclusão. Foram encontrados funcion[arios vinculados a este cargo." );
			}

		}

		catch ( Exception e ) {
			model.addAttribute( "fail", "Falha na exclusão. Erro: " + e.getMessage() );
		}

		return listar( model );
	}

}

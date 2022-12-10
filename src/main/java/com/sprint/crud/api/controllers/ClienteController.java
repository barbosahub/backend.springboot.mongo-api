package com.sprint.crud.api.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sprint.crud.api.documents.Cliente;
import com.sprint.crud.api.services.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(path= "/api/clientes")
@Api(value="API REST Clientes")
@CrossOrigin(origins="*")
public class ClienteController {
   
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	@ApiOperation(value="Buscar Clientes")
	public ResponseEntity<com.sprint.crud.api.responses.Response<List<Cliente>>> listarTodos() {
		return ResponseEntity.ok(new com.sprint.crud.api.responses.Response<List<Cliente>>(this.clienteService.listarTodos()));
	}
	
	@GetMapping(path = "/{id}")
	@ApiOperation(value="Buscar Clientes por Id")
	public ResponseEntity<com.sprint.crud.api.responses.Response<Cliente>> listarporId(@PathVariable(name = "id") String id){
		return ResponseEntity.ok(new com.sprint.crud.api.responses.Response<Cliente>(this.clienteService.listarPorId(id)));
	}
	

	@PostMapping
	@ApiOperation(value="Cadastra Cliente")
	public ResponseEntity<com.sprint.crud.api.responses.Response<Cliente>> cadastrar(@Valid @RequestBody Cliente cliente, BindingResult result){
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new com.sprint.crud.api.responses.Response<Cliente>(erros));
		}		
		return ResponseEntity.ok(new com.sprint.crud.api.responses.Response<Cliente>(this.clienteService.cadastrar(cliente)));		
	}
	
	@PutMapping(path = "/{id}")
	@ApiOperation(value="Atualiza Cliente")
	public ResponseEntity<com.sprint.crud.api.responses.Response<Cliente>> atualizar(@PathVariable (name = "id") String id,@Valid  @RequestBody Cliente cliente, BindingResult result){
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new com.sprint.crud.api.responses.Response<Cliente>(erros));
		}
		
		cliente.setId(id);
		return ResponseEntity.ok(new com.sprint.crud.api.responses.Response<Cliente>(this.clienteService.atualizar(cliente)));
		
	}
	
	@DeleteMapping(path = "/{id}")
	@ApiOperation(value="Deleta Cliente")
	public ResponseEntity<com.sprint.crud.api.responses.Response<Integer>> remover(@PathVariable (name = "id") String id){
		this.clienteService.remover(id);
		return ResponseEntity.ok(new com.sprint.crud.api.responses.Response<Integer>(1));
	}
	
	
}
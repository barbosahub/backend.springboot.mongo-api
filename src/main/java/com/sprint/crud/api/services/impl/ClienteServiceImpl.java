package com.sprint.crud.api.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sprint.crud.api.documents.Cliente;
import com.sprint.crud.api.repositories.ClienteRepository;
import com.sprint.crud.api.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public List<Cliente> listarTodos() {
		// TODO Auto-generated method stub
		return this.clienteRepository.findAll();
	}

	public Cliente listarPorId(String id) {
		// TODO Auto-generated method stub
		return this.clienteRepository.findById(id).orElse(null);
	}

	public Cliente cadastrar(Cliente cliente) {
		// TODO Auto-generated method stub
		return this.clienteRepository.save(cliente);
	}

	public Cliente atualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		return this.clienteRepository.save(cliente);
	}

	public void remover(String id) {
		// TODO Auto-generated method stub
		this.clienteRepository.deleteById(id);
	}

}

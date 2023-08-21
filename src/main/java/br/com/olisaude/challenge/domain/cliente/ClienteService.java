package br.com.olisaude.challenge.domain.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository repository;

	public Long criar(ClienteRecord cliente) {
		var novoCliente = new ClienteEntity(cliente);
		
		repository.save(novoCliente);
		
		return novoCliente.getId();
	}

}

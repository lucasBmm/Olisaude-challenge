package br.com.olisaude.challenge.domain.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("cliente")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;

	@GetMapping
	public ResponseEntity<String> helloCliente() {
		return ResponseEntity.ok("Hello from Cliente!");
	}
	
	@PostMapping
	public ResponseEntity<?> criar(ClienteRecord cliente, UriComponentsBuilder uriBuilder) {
		Long clienteId = clienteService.criar(cliente);
		var uri = uriBuilder.path("/cliente").buildAndExpand(clienteId).toUri();
		return ResponseEntity.created(uri).build();
	}
}

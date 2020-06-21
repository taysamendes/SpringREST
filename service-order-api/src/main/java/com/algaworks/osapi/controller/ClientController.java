package com.algaworks.osapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osapi.domain.model.Client;
import com.algaworks.osapi.domain.repository.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping
	public List<Client> listar() {
		return clientRepository.findAll();
	}

	@GetMapping("/{clientId}")
	public ResponseEntity<Client> buscar(@PathVariable Long clientId) {
		Optional<Client> client = clientRepository.findById(clientId);

		if (client.isPresent()) {
			return ResponseEntity.ok(client.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client adicionar(@Valid @RequestBody Client client) {
		return clientRepository.save(client);
	}

	@PutMapping("/{clientId}")
	public ResponseEntity<Client> atualizar(@Valid @PathVariable Long clientId, @RequestBody Client client) {

		if (!clientRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}

		client.setId(clientId);
		client = clientRepository.save(client);

		return ResponseEntity.ok(client);
	}

	@DeleteMapping("/{clientId}")
	public ResponseEntity<Void> deletar(@PathVariable Long clientId) {

		if (!clientRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}

		clientRepository.deleteById(clientId);

		return ResponseEntity.noContent().build();
	}

}

package com.algaworks.osapi.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.osapi.domain.exception.NegocioException;
import com.algaworks.osapi.domain.model.Client;
import com.algaworks.osapi.domain.repository.ClientRepository;

@Service
public class CadastroClienteService {

	@Autowired
	private ClientRepository clientRepository;
	
	public Client salvar(Client client) {
		Client clientExistent = clientRepository.findByEmail(client.getEmail());
		
		if(clientExistent != null && !clientExistent.equals(client)) {
			throw new NegocioException("E-mail já cadastrado");
		}
		
		
		return clientRepository.save(client);
	}
	
	public void excluir(Long clientId) {
		clientRepository.deleteById(clientId);
	}

}

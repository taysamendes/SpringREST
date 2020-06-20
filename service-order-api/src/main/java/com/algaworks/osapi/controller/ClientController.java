package com.algaworks.osapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osapi.domain.model.Client;

@RestController
public class ClientController {
	
	@GetMapping("/clients")
	public List<Client> listar() {
		var client1 = new Client();
		client1.setIdLong(1L);
		client1.setName("Andreza");
		client1.setEmail("ad@hotmail.com");
		
		var client2 = new Client();
		client2.setIdLong(2L);
		client2.setName("Douglas");
		client2.setEmail("douglas@hotmail.com");
		
		return Arrays.asList(client1, client2);
	}
}

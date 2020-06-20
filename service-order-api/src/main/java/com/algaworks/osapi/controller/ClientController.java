package com.algaworks.osapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
	
	@GetMapping("/clientes")
	public String listar() {
		return "clientes";
	}
}

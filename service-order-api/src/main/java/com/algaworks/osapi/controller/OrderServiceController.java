package com.algaworks.osapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osapi.domain.model.OrderService;
import com.algaworks.osapi.domain.service.SOService;

@RestController
@RequestMapping("/order-service")
public class OrderServiceController {

	@Autowired
	private SOService soService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrderService criar(@RequestBody OrderService orderService) {
		return soService.criar(orderService);
	}

}

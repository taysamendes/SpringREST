package com.algaworks.osapi.domain.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.osapi.domain.exception.NegocioException;
import com.algaworks.osapi.domain.model.Client;
import com.algaworks.osapi.domain.model.OrderService;
import com.algaworks.osapi.domain.model.StatusServiceOrder;
import com.algaworks.osapi.domain.repository.ClientRepository;
import com.algaworks.osapi.domain.repository.OrderServiceRepository;

@Service
public class SOService {

	@Autowired
	private OrderServiceRepository orderServiceRepository;

	@Autowired
	private ClientRepository clientRepository;

	public OrderService criar(OrderService orderService) {
		Client client = clientRepository.findById(orderService.getClient().getId())
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));

		orderService.setClient(client);

		orderService.setStatus(StatusServiceOrder.ABERTA);
		orderService.setDateOpening(LocalDateTime.now());

		return orderServiceRepository.save(orderService);
	}

}

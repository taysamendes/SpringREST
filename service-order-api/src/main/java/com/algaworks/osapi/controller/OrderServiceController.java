package com.algaworks.osapi.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osapi.domain.model.OrderService;
import com.algaworks.osapi.domain.repository.OrderServiceRepository;
import com.algaworks.osapi.domain.service.SOService;
import com.algaworks.osapi.model.OrderServiceModel;

@RestController
@RequestMapping("/order-service")
public class OrderServiceController {

	@Autowired
	private SOService soService;

	@Autowired
	private OrderServiceRepository orderServiceRepository;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrderServiceModel criar(@Valid @RequestBody OrderService orderService) {
		return toModel(soService.criar(orderService));
	}

	@GetMapping
	public List<OrderServiceModel> listar() {
		return toCollectionModel(orderServiceRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrderServiceModel> buscar(@PathVariable Long id) {
		Optional<OrderService> orderService = orderServiceRepository.findById(id);

		if (orderService.isPresent()) {
			OrderServiceModel orderServiceModel = toModel(orderService.get());
			return ResponseEntity.ok(orderServiceModel);
		}

		return ResponseEntity.notFound().build();
	}

	private OrderServiceModel toModel(OrderService orderService) {
		return modelMapper.map(orderService, OrderServiceModel.class);
	}

	private List<OrderServiceModel> toCollectionModel(List<OrderService> ordersService) {
		return ordersService.stream()
				.map(orderService -> toModel(orderService))
				.collect(Collectors.toList());
	}

}

package com.algaworks.osapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.osapi.domain.model.OrderService;

@Repository
public interface OrderServiceRepository extends JpaRepository<OrderService, Long> {

}

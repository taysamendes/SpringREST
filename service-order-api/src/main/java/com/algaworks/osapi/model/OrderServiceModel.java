package com.algaworks.osapi.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.algaworks.osapi.domain.model.StatusServiceOrder;

//Classe para representação do modelo -- Utilizando padrão DTO
public class OrderServiceModel {

	private Long id;
	private ClientModel client;
	private String descrString;
	private BigDecimal price;
	private StatusServiceOrder status;
	private OffsetDateTime dateOpening;
	private OffsetDateTime dateClosing;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrString() {
		return descrString;
	}

	public void setDescrString(String descrString) {
		this.descrString = descrString;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public StatusServiceOrder getStatus() {
		return status;
	}

	public void setStatus(StatusServiceOrder status) {
		this.status = status;
	}

	public OffsetDateTime getDateOpening() {
		return dateOpening;
	}

	public void setDateOpening(OffsetDateTime dateOpening) {
		this.dateOpening = dateOpening;
	}

	public OffsetDateTime getDateClosing() {
		return dateClosing;
	}

	public void setDateClosing(OffsetDateTime dateClosing) {
		this.dateClosing = dateClosing;
	}

	public ClientModel getClient() {
		return client;
	}

	public void setClient(ClientModel client) {
		this.client = client;
	}
	
	

}

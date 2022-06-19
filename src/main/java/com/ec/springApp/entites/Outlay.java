package com.ec.springApp.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Outlay {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOutlay;

	private String status;

	private String type;

	private float price;

	private String description;

	@ManyToOne
	private Consumer consumer;

	public Long getIdOutlay() {
		return idOutlay;
	}

	public void setIdOutlay(Long idOutlay) {
		this.idOutlay = idOutlay;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}

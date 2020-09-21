package com.ServiceOrder.ServiceOrder.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Table(name="serviceOrderProducts")

public class ServiceOrderProducts implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@OneToOne
	private ServiceOrders serviceOrder;
	
	@OneToOne
	private Products product;
	
	private String defect;
	private String type;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ServiceOrders getServiceOrder() {
		return serviceOrder;
	}
	public void setServiceOrder(ServiceOrders serviceOrder) {
		this.serviceOrder = serviceOrder;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
	public String getDefect() {
		return defect;
	}
	public void setDefect(String defect) {
		this.defect = defect;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}

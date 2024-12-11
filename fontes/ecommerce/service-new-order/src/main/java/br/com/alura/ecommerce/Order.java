package br.com.alura.ecommerce;

import java.math.BigDecimal;

public class Order {

	@SuppressWarnings("unused")
	private String userId, orderId;
	@SuppressWarnings("unused")
	private BigDecimal amount;
	
	public Order(String userId, String orderId, BigDecimal amount) {
		this.userId = userId;
		this.orderId = orderId;
		this.amount = amount;
	}
	
	
}

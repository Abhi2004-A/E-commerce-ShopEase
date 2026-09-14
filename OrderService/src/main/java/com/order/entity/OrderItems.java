package com.order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderItemId;
	
	private Integer productId;
	
	private Integer productVariantId;
	
	private Integer quantity;
	
	private Double unitPrice;
	
	private Double totalAmount;
	
	private String productName;
	
	private String productCode;
	
	@ManyToOne
	@JoinColumn(name="orderId")
	private Orders orders;
	

}

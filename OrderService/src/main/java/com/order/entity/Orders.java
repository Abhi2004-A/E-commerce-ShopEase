package com.order.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.order.enumaration.PaymentType;
import com.order.enumaration.StatusType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	private Integer userId;
	
	private String orderNumber;
	
	private Double subTotal;
	
	private Double gstAmount;
	
	private Double totalPrice;
	
	@Enumerated(EnumType.STRING)
	private StatusType status;
	
	@Enumerated(EnumType.STRING)
	private PaymentType paymentStatus;
	
	private String currency;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime orderedAt;
	
	private LocalDateTime updatedAt;
	
	@PreUpdate
	public void setupdatedAt() {
		this.updatedAt=LocalDateTime.now();
	}
	
	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderItems> orderitems;
	
	@OneToOne(mappedBy = "orders")
	private OrderAddress orderaddress;
	
	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderHistory> orderhistory;
}

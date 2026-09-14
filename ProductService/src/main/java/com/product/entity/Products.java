package com.product.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product")
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	
	private String productName;
	
	private String description;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime addedAt;
	
	private LocalDateTime updatedAt;
	
	@ManyToOne
	@JoinColumn(name="brandId")
	private Brand brand;
	
	@ManyToOne
	@JoinColumn(name="subCategoryId")
	private SubCategory subCategory;
	
	@OneToMany(mappedBy = "products",
			  cascade = CascadeType.ALL,
			  orphanRemoval = true)
	private List<ProductImage> productimage;
	
	@OneToMany(mappedBy = "products")
	private List<ProductVariant> productvariant;
	
	@PreUpdate
	public void setupdatedAt() {
		this.updatedAt=LocalDateTime.now();
	}

}

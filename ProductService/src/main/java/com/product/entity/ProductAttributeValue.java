package com.product.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name="attribute_value")
public class ProductAttributeValue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer attributeValueId;
	
	private String valueName;
	
	@ManyToOne
	@JoinColumn(name="attributeId")
	private ProductAttribute productattribute;
	
	@OneToMany(mappedBy = "productattributevalue")
	private List<VariantValue> variantvalue;

	
}

package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entity.ProductVariant;
import com.product.entity.VariantValue;
import java.util.List;


public interface VariantValueRepo extends JpaRepository<VariantValue, Integer> {
	
	 List<VariantValue> findByProductVariant_ProductVariantId(Integer productVariantId);

}
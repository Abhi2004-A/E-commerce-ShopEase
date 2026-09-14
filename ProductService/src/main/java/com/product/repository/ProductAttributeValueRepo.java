package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.entity.ProductAttributeValue;
import java.util.Optional;


@Repository
public interface ProductAttributeValueRepo extends JpaRepository<ProductAttributeValue,Integer>{

	Optional<ProductAttributeValue> findByValueName(String valueName);
	
}
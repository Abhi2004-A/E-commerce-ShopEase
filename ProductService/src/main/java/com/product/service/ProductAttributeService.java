package com.product.service;

import java.util.List;

import com.product.dto.ProductAttributeDto;
import com.product.request.AddProductAttributeRequest;

public interface ProductAttributeService {
	
	ProductAttributeDto addattribute(AddProductAttributeRequest request);
	
	ProductAttributeDto updateAttribute(Integer attributeId,AddProductAttributeRequest request);
	
	List<ProductAttributeDto> getAllAttribute();
	
	ProductAttributeDto getByAttributeId(Integer attributeId);
	
	void deleteAttribute(Integer attributeId);

}

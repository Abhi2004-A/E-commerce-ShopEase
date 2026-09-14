package com.product.service;

import java.util.List;

import com.product.dto.ProductAttributeValueDto;
import com.product.request.AddValueNameRequest;

public interface ProductAttributeValueService {
	
	ProductAttributeValueDto addattributeVAlue(AddValueNameRequest request);
	
	ProductAttributeValueDto updateattributeVAlue(Integer attributeValueId,AddValueNameRequest request);
	
	List<ProductAttributeValueDto> getAllValue();
	
	ProductAttributeValueDto getValueById(Integer attributeValueId);
	
	void deletevalueById(Integer attributeValueId);
	

}

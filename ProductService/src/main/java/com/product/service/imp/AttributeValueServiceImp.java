package com.product.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.product.dto.ProductAttributeValueDto;
import com.product.entity.ProductAttribute;
import com.product.entity.ProductAttributeValue;
import com.product.exception.ProductException;
import com.product.repository.ProductAttributeRepo;
import com.product.repository.ProductAttributeValueRepo;
import com.product.request.AddValueNameRequest;
import com.product.service.ProductAttributeValueService;

@Service
public class AttributeValueServiceImp implements ProductAttributeValueService{
	
	@Autowired
	private ProductAttributeValueRepo pavrepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ProductAttributeRepo parepo;

	@Override
	public ProductAttributeValueDto addattributeVAlue(AddValueNameRequest request) {
		
		ProductAttribute attribute=parepo.findByAttributeName(request.getAttributeName()).orElseThrow(()->new ProductException("Product Attribut Not Found!", HttpStatus.NOT_FOUND));
		
		ProductAttributeValue alreadyexists=pavrepo.findByValueName(request.getValueName()).orElse(null);
		if(alreadyexists!=null) {
			throw new ProductException("Product Attribute Value Already Exists!", HttpStatus.CONFLICT);
			
		}
		ProductAttributeValue value=new ProductAttributeValue();
		value.setValueName(request.getValueName());
		value.setProductattribute(attribute);
		value=pavrepo.save(value);
		return mapper.map(value, ProductAttributeValueDto.class);
	}

	@Override
	public ProductAttributeValueDto updateattributeVAlue(Integer attributeValueId, AddValueNameRequest request) {
		ProductAttributeValue ifExists=pavrepo.findById(attributeValueId).orElseThrow(()->new ProductException("Product Attribute Value is Not Found!", HttpStatus.NOT_FOUND));
		
		ProductAttribute pa=parepo.findByAttributeName(request.getAttributeName()).orElseThrow(()->new ProductException("Attribute is Not Found!", HttpStatus.NOT_FOUND));
		
		ifExists.setValueName(request.getValueName());
		ifExists.setProductattribute(pa);
		ifExists=pavrepo.save(ifExists);
		return mapper.map(ifExists, ProductAttributeValueDto.class);
	}

	@Override
	public List<ProductAttributeValueDto> getAllValue() {
		return pavrepo.findAll().stream().map((pav)->mapper.map(pav, ProductAttributeValueDto.class)).collect(Collectors.toList());
	}

	@Override
	public ProductAttributeValueDto getValueById(Integer attributeValueId) {
		ProductAttributeValue ifExists=pavrepo.findById(attributeValueId).orElseThrow(()->new ProductException("Product Attribute Value is Not Found!", HttpStatus.NOT_FOUND));
		return mapper.map(ifExists, ProductAttributeValueDto.class);
	}

	@Override
	public void deletevalueById(Integer attributeValueId) {
		ProductAttributeValue ifExists=pavrepo.findById(attributeValueId).orElseThrow(()->new ProductException("Product Attribute Value is Not Found!", HttpStatus.NOT_FOUND));
		pavrepo.deleteById(attributeValueId);
	}

}

package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.ProductAttributeDto;
import com.product.request.AddProductAttributeRequest;
import com.product.response.ApiResponse;
import com.product.service.ProductAttributeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/productattribute")
public class ProductAttributeController {
	
	@Autowired
	private ProductAttributeService paservice;
	
	@PostMapping("/addattribute")
	public ResponseEntity<?> addProductAttribute(@Valid @RequestBody AddProductAttributeRequest request){
		ProductAttributeDto padto=paservice.addattribute(request);
		return ResponseEntity.ok(new ApiResponse<>("Product Attribute Added Successfully!",padto,HttpStatus.OK));
	}
	
	@PutMapping("/updateattribute/{attributeId}")
	public ResponseEntity<?> updateProductAttribute(@PathVariable Integer attributeId,@Valid @RequestBody AddProductAttributeRequest request){
		ProductAttributeDto padto=paservice.updateAttribute(attributeId, request);
		return ResponseEntity.ok(new ApiResponse<>("Product Attribute Updated Successfully!",padto,HttpStatus.OK));
	}
	
	@GetMapping("/getallAttribute")
	public ResponseEntity<?> getAllattribute(){
		List<ProductAttributeDto> padto=paservice.getAllAttribute();
		return ResponseEntity.ok(new ApiResponse<>("Product Attributes!",padto,HttpStatus.OK));
	}
	
	@DeleteMapping("/delete/{attributeId}")
	public ResponseEntity<?> deleteAttributes(@PathVariable Integer attributeId){
		paservice.deleteAttribute(attributeId);
		return ResponseEntity.ok(new ApiResponse<>("Product Attribute deleted Successfully!",null,HttpStatus.OK));
	}

}

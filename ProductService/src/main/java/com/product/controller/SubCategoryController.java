package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.SubCategoryDto;
import com.product.request.AddSubCategoryRequest;
import com.product.response.ApiResponse;
import com.product.service.SubCategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/subCate")
@Validated
public class SubCategoryController {
	
	@Autowired
	private SubCategoryService scservice;
	
	@PostMapping("/addsubcate")
	public ResponseEntity<?> addSubCategory(@Valid @RequestBody AddSubCategoryRequest request){
		SubCategoryDto scdto=scservice.addSubCategory(request);
		return ResponseEntity.ok(new ApiResponse<>("Sub Category Add To Database!",scdto,HttpStatus.OK));
	}

}

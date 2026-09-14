package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.VariantValueDto;
import com.product.request.AddVariantValueRequest;
import com.product.response.ApiResponse;
import com.product.service.VariantValueService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/variantValue")
public class VariantValueController {

    @Autowired
    private VariantValueService vvservice;

    @PostMapping("/add")
    public ResponseEntity<?> addVariantValue(@Valid @RequestBody AddVariantValueRequest request) {
        VariantValueDto dto =vvservice.addVariantValue(request);
        return ResponseEntity.ok(new ApiResponse<>("Variant Value Added Successfully!",dto,HttpStatus.OK));
    }

//    @GetMapping("/{variantValueId}")
//    public ResponseEntity<?> getVariantValueById(@PathVariable Integer variantValueId) {
//        VariantValueDto dto =variantValueService.getVariantValueById(variantValueId);
//        return ResponseEntity.ok(new ApiResponse<>("Your Selected Variant Value!",dto,HttpStatus.OK));
//    }
    
    @GetMapping("/get/{productVariantId}")
    public ResponseEntity<List<VariantValueDto>> getVAriants(@PathVariable Integer productVariantId){
    	List<VariantValueDto> lvdto=vvservice.getVariantValueById(productVariantId);
    	return new ResponseEntity(lvdto, HttpStatus.OK);
    }
}
package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.ProductVariantDto;
import com.product.request.AddProductVariantRequest;
import com.product.request.UpdateProductVariantRequest;
import com.product.request.UpdateStocksRequest;
import com.product.response.ApiResponse;
import com.product.service.ProductVariantService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/productVariant")
public class ProductVariantController {

	@Autowired
	private ProductVariantService productVariantService;

	@PostMapping("/add")
	public ResponseEntity<?> addProductVariant(@Valid @RequestBody AddProductVariantRequest request) {
		ProductVariantDto dto = productVariantService.addProductVariant(request);
		return ResponseEntity.ok(new ApiResponse<>("Product Variant Added Successfully!", dto, HttpStatus.OK));
	}

	@GetMapping("/getproduct/{productCode}")
	public ResponseEntity<?> getProductVariantById(@PathVariable String productCode) {
		ProductVariantDto dto = productVariantService.getProductVariantById(productCode);
		return ResponseEntity.ok(new ApiResponse<>("Your Selected Product Variant!", dto, HttpStatus.OK));
	}

	@PutMapping("/update/{productVariantId}")
	public ResponseEntity<?> updateProductVariant(@PathVariable Integer productVariantId,@Valid @RequestBody UpdateProductVariantRequest request) {
		ProductVariantDto dto = productVariantService.updateProductVariant(productVariantId, request);
		return ResponseEntity.ok(new ApiResponse<>("Product Variant Updated Successfully!", dto, HttpStatus.OK));
	}

	@PutMapping("/addStock/{productCode}")
	public ResponseEntity<?> addStocks(@PathVariable String productCode,@Valid @RequestBody UpdateStocksRequest request) {
		ProductVariantDto dto = productVariantService.addStocks(productCode, request);
		return ResponseEntity.ok(new ApiResponse<>("Stocks Added Successfully!", dto, HttpStatus.OK));
	}
}
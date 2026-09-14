package com.product.service;

import com.product.dto.ProductVariantDto;
import com.product.request.AddProductVariantRequest;
import com.product.request.UpdateProductVariantRequest;
import com.product.request.UpdateStocksRequest;

public interface ProductVariantService {

	ProductVariantDto addProductVariant(AddProductVariantRequest request);

	ProductVariantDto getProductVariantById(String productCode);

	ProductVariantDto updateProductVariant(Integer productVariantId, UpdateProductVariantRequest request);

	ProductVariantDto addStocks(String productCode, UpdateStocksRequest request);
}
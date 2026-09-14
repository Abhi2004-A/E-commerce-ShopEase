package com.product.service.imp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.product.dto.ProductVariantDto;
import com.product.entity.ProductVariant;
import com.product.entity.Products;
import com.product.exception.ProductException;
import com.product.repository.ProductRepo;
import com.product.repository.ProductVariantRepo;
import com.product.request.AddProductVariantRequest;
import com.product.request.UpdateProductVariantRequest;
import com.product.request.UpdateStocksRequest;
import com.product.service.ProductVariantService;

@Service
public class ProductVariantServiceImp implements ProductVariantService {

	@Autowired
	private ProductVariantRepo pvrepo;

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public ProductVariantDto addProductVariant(AddProductVariantRequest request) {

		Products product = productRepo.findById(request.getProductId()).orElseThrow(() -> new ProductException("Product Not Found!", HttpStatus.NOT_FOUND));

		ProductVariant alreadyExists = pvrepo.findByProductCode(request.getProductCode()).orElse(null);

		if (alreadyExists != null) {
			throw new ProductException("Product Code Already Exists!", HttpStatus.CONFLICT);
		}

		ProductVariant variant = new ProductVariant();
		variant.setPrice(request.getPrice());
	    variant.setProductCode(request.getProductCode());
	    variant.setStocks(request.getStocks());
	    variant.setProducts(product);

	    System.out.println("Variant ID = " + variant.getProductVariantId());

		variant = pvrepo.save(variant);
		return mapper.map(variant, ProductVariantDto.class);
	}

	@Override
	public ProductVariantDto getProductVariantById(String productCode) {
		ProductVariant variant = pvrepo.findByProductCode(productCode).orElseThrow(() -> new ProductException("Product Variant Not Found!", HttpStatus.NOT_FOUND));
		return mapper.map(variant, ProductVariantDto.class);
	}

	@Override
	public ProductVariantDto updateProductVariant(Integer productVariantId, UpdateProductVariantRequest request) {

		ProductVariant variant = pvrepo.findById(productVariantId).orElseThrow(() -> new ProductException("Product Variant Not Found!", HttpStatus.NOT_FOUND));

		if (request.getProductCode() != null && !request.getProductCode().equals(variant.getProductCode())) {
			ProductVariant alreadyExists = pvrepo.findByProductCode(request.getProductCode()).orElse(null);

			if (alreadyExists != null) {
				throw new ProductException("Product Code Already Exists!", HttpStatus.CONFLICT);
			}
		}
		mapper.map(request, variant);
		variant = pvrepo.save(variant);
		return mapper.map(variant, ProductVariantDto.class);
	}

	@Override
	public ProductVariantDto addStocks(String productCode, UpdateStocksRequest request) {

		ProductVariant variant = pvrepo.findByProductCode(productCode).orElseThrow(() -> new ProductException("Product Variant Not Found!", HttpStatus.NOT_FOUND));
		
		if (request.getStocks() == null || request.getStocks() <= 0) {
			throw new ProductException("Stocks Must Be Greater Than Zero!", HttpStatus.BAD_REQUEST);
		}

		Integer currentStocks = variant.getStocks() + request.getStocks();
		variant.setStocks(currentStocks);
		variant = pvrepo.save(variant);
		return mapper.map(variant, ProductVariantDto.class);
	}
}
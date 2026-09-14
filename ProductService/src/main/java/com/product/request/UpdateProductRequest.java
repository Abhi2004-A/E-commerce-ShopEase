package com.product.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateProductRequest {
	
	@NotBlank(message = "Product Name is Required")
	private String productName;
	
	
	private String description;
	
	@NotBlank(message = "Barnd Name is Required")
	private String brandName; 
	
	@NotBlank(message = "Category Name is Required")
	private String categoryName;
	
	@NotBlank(message = "Sub Category Name is Required")
	private String subCategoryName;

}

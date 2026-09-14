package com.product.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

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

package com.product.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddSubCategoryRequest {
	
	@NotBlank(message = "Sub Category Name is Required")
	private String subCategoryName;
	
	@NotBlank(message = "Category Name is Required")
	private String categoryName;

}

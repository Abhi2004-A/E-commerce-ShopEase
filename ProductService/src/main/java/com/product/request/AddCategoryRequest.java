package com.product.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCategoryRequest {
	
	@NotBlank(message = "Category Name is Required")
	private String categoryName;
	
    private String cateDescription;
	

}

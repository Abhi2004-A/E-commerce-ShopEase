package com.product.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryRequest {
	
	@NotBlank(message = "Please Add The New Category Name")
	private String categoryName;
	
    private String cateDescription;

}

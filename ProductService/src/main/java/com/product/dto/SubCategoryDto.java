package com.product.dto;

import java.time.LocalDateTime;

import com.product.entity.Category;

import lombok.Data;

@Data
public class SubCategoryDto {
	
	private Integer subCategoryId;
	
	private String subCategoryName;
	
	private LocalDateTime createdAt;
	
	private CategoryDto categorydto;

}

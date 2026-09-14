package com.product.service;

import java.util.List;

import com.product.dto.SubCategoryDto;
import com.product.request.AddSubCategoryRequest;

public interface SubCategoryService {
	
	SubCategoryDto addSubCategory(AddSubCategoryRequest request);
	
	void deleteSubCategory(Integer subCategoryId);
	
	List<SubCategoryDto> getAllSubCategory();
	
	SubCategoryDto getSubCategoryById(Integer subCategoryId);
	
	SubCategoryDto updateSubCategory(Integer subCategoryId, AddSubCategoryRequest request);

}

package com.product.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.product.dto.SubCategoryDto;
import com.product.entity.Category;
import com.product.entity.SubCategory;
import com.product.exception.ProductException;
import com.product.repository.CategoryRepo;
import com.product.repository.SubCategoryRepo;
import com.product.request.AddSubCategoryRequest;
import com.product.service.SubCategoryService;

@Service
public class SubCategoryServiceImp implements SubCategoryService{

	@Autowired
	private SubCategoryRepo screpo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CategoryRepo crepo;
	
	@Override
	public SubCategoryDto addSubCategory(AddSubCategoryRequest request) {
		
		Category cat=crepo.findByCategoryName(request.getCategoryName()).orElseThrow(()->new ProductException("Category Not Found!", HttpStatus.NOT_FOUND));
		
		if(screpo.findBySubCategoryNameAndCategory(request.getSubCategoryName(), cat).isPresent()) {
			throw new ProductException("SubCategory Already Exists in This Category!", HttpStatus.CONFLICT);
		}
		
		SubCategory sc=mapper.map(request, SubCategory.class);
		sc.setCategory(cat);
		sc=screpo.save(sc);
		return mapper.map(sc, SubCategoryDto.class);
	}

	@Override
	public void deleteSubCategory(Integer subCategoryId) {
		SubCategory sub=screpo.findById(subCategoryId).orElseThrow(()->new ProductException("Category is Not Found!", HttpStatus.NOT_FOUND));
		screpo.deleteById(subCategoryId);
	}

	@Override
	public List<SubCategoryDto> getAllSubCategory() {
		return screpo.findAll().stream().map(sc->mapper.map(sc, SubCategoryDto.class)).collect(Collectors.toList());
	}

	@Override
	public SubCategoryDto getSubCategoryById(Integer subCategoryId) {
		SubCategory sub=screpo.findById(subCategoryId).orElse(null);
		if(sub==null) {
			throw new ProductException("Category is Not Found!", HttpStatus.NOT_FOUND);
		}
		return mapper.map(sub, SubCategoryDto.class);
	}

	@Override
	public SubCategoryDto updateSubCategory(Integer subCategoryId, AddSubCategoryRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}

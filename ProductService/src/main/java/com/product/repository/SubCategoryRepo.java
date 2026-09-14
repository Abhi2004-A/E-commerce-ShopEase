package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.entity.Category;
import com.product.entity.SubCategory;
import java.util.List;
import java.util.Optional;


@Repository
public interface SubCategoryRepo extends JpaRepository<SubCategory, Integer>{
	
	Optional<SubCategory> findBySubCategoryNameAndCategory(String subCategoryName, Category category);

}

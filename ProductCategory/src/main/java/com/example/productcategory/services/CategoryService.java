package com.example.productcategory.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.productcategory.model.Category;
import com.example.productcategory.repository.CategoryRepository;

@Service
public class CategoryService {
	 @Autowired
	    private CategoryRepository categoryRepository;

	    public Page<Category> getAllCategories(int page, int size) {
	        return categoryRepository.findAll(PageRequest.of(page, size));
	    }

	    public Category createCategory(Category category) {
	        return categoryRepository.save(category);
	    }

	    public Optional<Category> getCategoryById(Long id) {
	        return categoryRepository.findById(id);
	    }

	    public Category updateCategory(Long id, Category categoryDetails) {
	        Category category = categoryRepository.findById(id).orElseThrow();
	        category.setName(categoryDetails.getName());
	        return categoryRepository.save(category);
	    }

	    public void deleteCategory(Long id) {
	        categoryRepository.deleteById(id);
	    }


}

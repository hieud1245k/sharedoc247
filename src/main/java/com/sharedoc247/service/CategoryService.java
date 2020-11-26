package com.sharedoc247.service;

import java.util.List;

import com.sharedoc247.model.CategoryModel;

public interface CategoryService {
	List<CategoryModel> findAll();
	CategoryModel findOne(Integer id);
}

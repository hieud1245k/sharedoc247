package com.sharedoc247.dao;

import java.util.List;

import com.sharedoc247.model.CategoryModel;

public interface CategoryDao extends GenericDao<CategoryModel> {
	List<CategoryModel> findAll();
	CategoryModel findById(Integer id);
}

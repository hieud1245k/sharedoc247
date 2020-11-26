package com.sharedoc247.service.Impl;

import java.util.List;

import javax.inject.Inject;

import com.sharedoc247.dao.CategoryDao;
import com.sharedoc247.model.CategoryModel;
import com.sharedoc247.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	
	private final CategoryDao categoryDao;
	
	@Inject
	public CategoryServiceImpl(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public CategoryModel findOne(Integer id) {
		return categoryDao.findById(id);
	}
}

package com.sharedoc247.dao.Impl;

import java.util.List;

import com.sharedoc247.dao.CategoryDao;
import com.sharedoc247.mapper.CategoryMapper;
import com.sharedoc247.model.CategoryModel;

public class CategoryDaoImpl extends AbstractDAOImpl<CategoryModel> implements CategoryDao {

	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM category WHERE deleted_at is null";
		List<CategoryModel> list = query(sql, new CategoryMapper());
		return list;
	}

	@Override
	public CategoryModel findById(Integer id) {
		String sql = "SELECT * FROM category WHERE id = ? and deleted_at is null";
		List<CategoryModel> list = query(sql, new CategoryMapper(), id);
		return list.isEmpty()? null: list.get(0); 
	}
}

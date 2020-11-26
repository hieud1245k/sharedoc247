package com.sharedoc247.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sharedoc247.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel> {

	@Override
	public CategoryModel mapRow(ResultSet resultSet) {
		try {
			CategoryModel model = new CategoryModel();
			model.setId(resultSet.getLong("id"));
			model.setCategoryName(resultSet.getString("category_name"));
			model.setCategoryCode(resultSet.getString("category_code"));
			return model;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}

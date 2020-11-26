package com.sharedoc247.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sharedoc247.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		UserModel model = new UserModel();
		try {
			model.setId(resultSet.getLong("id"));
			model.setCreatedAt(resultSet.getTimestamp("created_at"));
			model.setUpdatedAt(resultSet.getTimestamp("updated_at"));
			model.setDeletedAt(resultSet.getTimestamp("deleted_at"));
			model.setUpdatedBy(resultSet.getLong("updated_by"));
			
			model.setUsername(resultSet.getString("username"));
			model.setPassword(resultSet.getString("password"));
			model.setBalance(resultSet.getInt("balance"));
			model.setFullName(resultSet.getString("full_name"));
			model.setPhoneNumber(resultSet.getString("phone_number"));
			model.setGmail(resultSet.getString("gmail"));
			model.setRoleId(resultSet.getInt("role_id"));
			model.setStatus(resultSet.getInt("status"));
			return model;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}

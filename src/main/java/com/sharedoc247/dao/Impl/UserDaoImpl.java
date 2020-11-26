package com.sharedoc247.dao.Impl;

import java.sql.Timestamp;
import java.util.List;

import com.sharedoc247.dao.UserDao;
import com.sharedoc247.mapper.UserMapper;
import com.sharedoc247.model.UserModel;

public class UserDaoImpl extends AbstractDAOImpl<UserModel> implements UserDao {

	@Override
	public void update(UserModel model) {
		StringBuilder sql = new StringBuilder("UPDATE user SET username = ?, password = ?, full_name = ?, gmail = ?,");
		sql.append(
				" phone_number = ?, balance = ?, status = ?, role_id = ?, updated_at = ?, updated_by = ?  WHERE id = ?");
		update(sql.toString(), model.getUsername(), model.getPassword(), model.getFullName(), model.getGmail(),
				model.getPhoneNumber(), model.getBalance(), 1, model.getRoleId(), model.getUpdatedAt(),
				model.getUpdatedBy(), model.getId());
	}

	@Override
	public void deleteById(Long id) {
		Timestamp deleteTime = new Timestamp(System.currentTimeMillis());
		String sql = "UPDATE user SET deleted_at = ?, updated_at = ? WHERE id = ? and deleted_at is null";
		update(sql, deleteTime, deleteTime, id);
	}

	@Override
	public UserModel findByIdAndDeletedAtNull(Long id) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user where id = ? and deleted_at is null");
		List<UserModel> list = query(sql.toString(), new UserMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public Long save(UserModel model) {
		StringBuilder sql = new StringBuilder(
				"INSERT INTO user(username,password,full_name,gmail,phone_number,balance,status,role_id,created_at,updated_at) ");
		sql.append(" VALUES(?,?,?,?,?,?,?,?,?,?)");
		return insert(sql.toString(), model.getUsername(), model.getPassword(), model.getFullName(),
				model.getGmail(), model.getPhoneNumber(), model.getBalance(),1, model.getRoleId(),
				model.getCreatedAt(),model.getUpdatedAt());
	}

	@Override
	public UserModel findByUsernameAndPasswordAndDeletedAtNull(String username, String password) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user where username = ? and password = ? and deleted_at is null");
		List<UserModel> list = query(sql.toString(), new UserMapper(), username, password);
		return list.isEmpty() ? null : list.get(0);
	}
}

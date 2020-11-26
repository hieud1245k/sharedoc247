package com.sharedoc247.service.Impl;

import java.sql.Timestamp;

import javax.inject.Inject;

import com.sharedoc247.dao.UserDao;
import com.sharedoc247.model.UserModel;
import com.sharedoc247.service.UserService;

public class UserServiceImpl implements UserService {

	private final UserDao userDao;
	
	@Inject
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public UserModel update(UserModel model) {
		UserModel oldModel = userDao.findByIdAndDeletedAtNull(model.getId());
		if(oldModel == null) 
			return null;
		model.setCreatedAt(oldModel.getCreatedAt());
		model.setStatus(oldModel.getStatus());
		model.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		model.setUpdatedBy(oldModel.getUpdatedBy());
		userDao.update(model);
		return model;
	}

	@Override
	public void delete(long[] ids) {
		for(long id: ids) {
			userDao.deleteById(id);
		}
	}

	@Override
	public UserModel registerUser(UserModel model) {
		model.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		model.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		model.setRoleId(2);
		model.setBalance(0);
		Long id = userDao.save(model);
		model.setPassword(null);
		model.setConfirmPassword(null);
		model.setId(id);
		return model;
	}

	@Override
	public UserModel findByUsernameAndPassword(UserModel model) {
		return userDao.findByUsernameAndPasswordAndDeletedAtNull(model.getUsername(), model.getPassword());
	}
	
	
}

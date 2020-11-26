package com.sharedoc247.dao;

import com.sharedoc247.model.UserModel;

public interface UserDao extends GenericDao<UserModel> {
	
	void update(UserModel model);
	void deleteById(Long id);
	UserModel findByIdAndDeletedAtNull(Long id);
	Long save(UserModel model);
	UserModel findByUsernameAndPasswordAndDeletedAtNull(String username, String password);
}

package com.sharedoc247.service;

import com.sharedoc247.model.UserModel;

public interface UserService {
	
	UserModel update(UserModel model);
	void delete(long[] ids);
	UserModel registerUser(UserModel model);
	UserModel findByUsernameAndPassword(UserModel model);
}
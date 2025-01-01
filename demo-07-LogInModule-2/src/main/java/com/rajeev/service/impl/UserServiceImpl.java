package com.rajeev.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajeev.model.User;
import com.rajeev.repo.UserRepo;
import com.rajeev.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo repo;
	@Override
	public User login(String userName, String password) {
	   User user = repo.findByuserName(userName);
	   if(user!=null&&user.getUserPassword().equals(password)) {
		   return user;
	   }
		return null;
	}

}

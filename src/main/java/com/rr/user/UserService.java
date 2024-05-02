package com.rr.user;

import org.springframework.stereotype.Service;

import com.rr.base.BaseService;


@Service
public class UserService extends BaseService<User, UserRepository> {

	public UserService(UserRepository repository) {
		super(repository);
	}

}

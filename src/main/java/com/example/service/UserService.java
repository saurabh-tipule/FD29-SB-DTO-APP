package com.example.service;

import com.example.entity.User;

public interface UserService {

	User saveUser(User user);

	User getUserById(Integer id);

}

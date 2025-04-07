package com.example.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {

		User savedUser = userRepository.save(user);

		return savedUser;
	}

	@Override
	public User getUserById(Integer id) {

		return userRepository.findById(id).get();
	}
}

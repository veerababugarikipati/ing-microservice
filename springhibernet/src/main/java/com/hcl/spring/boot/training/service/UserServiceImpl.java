package com.hcl.spring.boot.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.spring.boot.training.repositories.UserRepository;
import com.hcl.spring.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository<User> baseRepository;
	
	public User createUser(User user) {
		return  baseRepository.save(user);
	}

	@Override
	public void delete(User user) {
		
		  baseRepository.delete(user);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return baseRepository.findByEmail(email);
	}

	@Override
	public User findOne(long id) {
		// TODO Auto-generated method stub
		return baseRepository.findById(id);
	}

	@Override
	public void save(User user) {
		baseRepository.save(user);
		
	}

}

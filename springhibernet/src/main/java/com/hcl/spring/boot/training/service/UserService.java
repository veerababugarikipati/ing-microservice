package com.hcl.spring.boot.training.service;

import org.springframework.stereotype.Service;

import com.hcl.spring.model.User;
@Service
public interface UserService {
		public User createUser(User user);

		public void delete(User user);

		public User findByEmail(String email);

		public User findOne(long id);

		public void save(User user);
	
}

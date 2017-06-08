package com.hcl.spring.boot.training.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.hcl.spring.model.User;

@Transactional
public interface UserRepository<T> extends
CrudRepository<User, Long> {
T findById(long id);
T findByEmail(String email);
}

package org.jsp.api.dao;

import org.jsp.api.dto.User;
import org.jsp.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private UserRepository repository;

	public User saveUser(User user) {
		return repository.save(user);
	}

	public User updateUser(User user) {
		return repository.save(user);
	}

	public User verifyUser(String token) {
		return repository.findUserByToken(token);
	}

	public User findMerchantByEmail(String email) {
		return repository.findUserByEmail(email);
	}
}

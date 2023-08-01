package org.jsp.api.repository;

import java.util.Optional;

import org.jsp.api.dto.Merchant;
import org.jsp.api.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.token=?1")
	public User findUserByToken(String token);
	
	@Query("select u from User u where u.email=?1")
	public User findUserByEmail(String token);

	@Query("select u from User u where u.email=?1 and u.password=?2")
	public Optional<User> loginverifyByUser(String email,String password);

}

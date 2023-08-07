package org.jsp.api.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Optional;

import org.jsp.api.configuration.EmailConfiguration;
import org.jsp.api.dao.UserDao;
import org.jsp.api.dto.Merchant;
import org.jsp.api.dto.ResponseStructure;
import org.jsp.api.dto.User;
import org.jsp.api.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class UserService {
	@Autowired
	private UserDao udao;
	@Autowired
	private ShoppingCartMailService mailService;
	@Autowired
	private EmailConfiguration configuration;
	@Autowired
	private GenerateLinkService service;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user, HttpServletRequest request) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setData(udao.saveUser(user));
		structure.setMessage("Registration successful");
		structure.setStatusCode(HttpStatus.CREATED.value());
		configuration.setSubject("Registration successful");
		HashMap<String, String> map = new LinkedHashMap<>();
		map.put("email", user.getEmail());
		map.put("name", user.getName());
		configuration.setText("Hello Mr." + user.getName()
				+ " You have successfully initiated the registration for Our E-Commerce application "
				+ "please click on the link to activate your account " + service.getVerificationLink(request, user));
		configuration.setUser(map);
		mailService.sendWelcomeMail(configuration);
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setData(udao.updateUser(user));
		structure.setMessage("Update successful");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<String>> verifyUser(String token) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		User user = udao.verifyUser(token);
		if (user != null) {
			user.setToken(null);
			user.setStatus("Active");
			udao.updateUser(user);
			structure.setData("Your Account is Activated");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("User is verified");
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		structure.setData("Your Account is not activated");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("User is Not verified");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<String>> sendResetPasswordLink(String email, HttpServletRequest request) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		User user = udao.findUserByEmail(email);
		if (user != null) {
			HashMap<String, String> map = new LinkedHashMap<>();
			map.put("email", user.getEmail());
			map.put("name", user.getName());
			configuration.setSubject("Reset password");
			configuration.setUser(map);
			configuration.setText("Hello Mr." + user.getName()
					+ " You have requested for password change please click on the following link "
					+ service.getResetPasswordLink(request, user));

			mailService.sendWelcomeMail(configuration);
			structure.setData("Password reset mail Sent");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			structure.setMessage("Password Reset mail sent succesful");
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.ACCEPTED);
		}
		structure.setData("Please register");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Register to Portal");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<User>> loginverifyByUser(String email, String password) {
		Optional<User> recUser = udao.loginverifyByUser(email, password);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (recUser.isPresent()) {
			structure.setData(recUser.get());
			structure.setMessage("User login successfully");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
}

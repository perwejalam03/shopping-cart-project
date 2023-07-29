package org.jsp.api.service;

import java.util.HashMap;

import org.jsp.api.configuration.EmailConfiguration;
import org.jsp.api.dao.UserDao;
import org.jsp.api.dto.ResponseStructure;
import org.jsp.api.dto.User;
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
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setData(udao.saveUser(user));
		structure.setMessage("Registration successful");
		structure.setStatusCode(HttpStatus.CREATED.value());
		configuration.setSubject("Registration successful");
		HashMap<String, String> map = new HashMap<>();
		map.put("email", user.getEmail());
		map.put("name", user.getName());
		configuration.setText("Hello Mr." + user.getName()
				+ " You have successfully initiated the registration for Our E-Commerce application "
				+ "please click on the link to activate your account "
				+ service.getVerificationLink(request, user));
		configuration.setUser(map);
		mailService.sendWelcomeMail(configuration);
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<String>> verifyUser(String token) {
		ResponseStructure<String> structure=new ResponseStructure<>();
		User user = udao.verifyUser(token);
		if (user != null) {
			user.setToken(null);
			user.setStatus("Active");
			udao.updateUser(user);
			structure.setData("Your Account is Activated");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("User is verified");
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
		}
		structure.setData("Account is not activated");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Invalid Token");
		return new ResponseEntity<>(structure,HttpStatus.NOT_FOUND);
	}
	
	public String sendResetPasswordLink(String email,HttpServletRequest request) {
		User user=udao.verifyUser(email);
		if(user!=null) {
			HashMap<String, String> map = new HashMap<>();
			map.put("email", user.getEmail());
			map.put("name", user.getName());
			configuration.setSubject("Reset password");
			configuration.setText("Hello Mr." + user.getName()
					+ " You have requested for password change please click on the following link "
					+ service.getResetPasswordLink(request, user));
			configuration.setUser(map);
			mailService.sendWelcomeMail(configuration);
			return "Reset password link sent to email";
		}
		return "please register";
	}
}

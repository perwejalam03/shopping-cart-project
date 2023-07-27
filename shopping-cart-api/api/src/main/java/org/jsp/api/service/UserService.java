package org.jsp.api.service;

import java.util.HashMap;

import org.jsp.api.configuration.EmailConfiguration;
import org.jsp.api.dao.UserDao;
import org.jsp.api.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
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

	public User saveUser(User user, HttpServletRequest request) {
		configuration.setSubject("Registration successfull");
		udao.saveUser(user);
		HashMap<String, String> map = new HashMap<>();
		map.put("email", user.getEmail());
		map.put("name", user.getName());
		configuration.setText("Hello Mr." + user.getName()
				+ " You have successfully initiated the registration for Our E-Commerce application "
				+ "please click on the link to activate your account "
				+ service.getVerificationLink(request, user));
		configuration.setUser(map);
		mailService.sendWelcomeMail(configuration);
		return user;
	}

	public String verifyUser(String token) {
		User user = udao.verifyUser(token);
		if (user != null) {
			user.setToken(null);
			user.setStatus("Active");
			udao.updateUser(user);
			return "Your Account is Activated";
		}
		return "Invalid token";
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

package org.jsp.api.service;

import java.util.HashMap;

import org.jsp.api.configuration.EmailConfiguration;
import org.jsp.api.dao.MerchantDao;
import org.jsp.api.dto.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class MerchantService {
	@Autowired
	private MerchantDao dao;
	@Autowired
	private ShoppingCartMailService mailService;
	@Autowired
	private EmailConfiguration configuration;
	@Autowired
	private GenerateLinkService service;

	public Merchant savMerchant(Merchant merchant, HttpServletRequest request) {
		configuration.setSubject("Registration successfull");
		dao.saveMerchant(merchant);
		HashMap<String, String> map = new HashMap<>();
		map.put("email", merchant.getEmail());
		map.put("name", merchant.getName());
		configuration.setText("Hello Mr." + merchant.getName()
				+ " You have successfully initiated the registration for Our E-Commerce application "
				+ "please click on the link to activate your account "
				+ service.getVerificationLink(request, merchant));
		configuration.setUser(map);
		mailService.sendWelcomeMail(configuration);
		return merchant;
	}

	public String verifyMerchant(String token) {
		Merchant merchant = dao.verifyMerchant(token);
		if (merchant != null) {
			merchant.setToken(null);
			merchant.setStatus("Active");
			dao.updateMerchant(merchant);
			return "Your Account is Activated";
		}
		return "Invalid token";
	}
	
	public String sendResetPasswordLink(String email,HttpServletRequest request) {
		Merchant merchant=dao.findMerchantByEmail(email);
		if(merchant!=null) {
			HashMap<String, String> map = new HashMap<>();
			map.put("email", merchant.getEmail());
			map.put("name", merchant.getName());
			configuration.setSubject("Reset password");
			configuration.setText("Hello Mr." + merchant.getName()
					+ " You have requested for password change please click on the following link "
					+ service.getResetPasswordLink(request, merchant));
			configuration.setUser(map);
			mailService.sendWelcomeMail(configuration);
			return "Reset password link sent to email";
		}
		return "please register";
	}
}

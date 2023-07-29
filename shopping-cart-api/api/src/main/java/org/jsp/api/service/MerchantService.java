package org.jsp.api.service;

import java.util.HashMap;

import org.jsp.api.configuration.EmailConfiguration;
import org.jsp.api.dao.MerchantDao;
import org.jsp.api.dto.Merchant;
import org.jsp.api.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	public ResponseEntity<ResponseStructure<Merchant>> savMerchant(Merchant merchant, HttpServletRequest request) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		structure.setData(dao.saveMerchant(merchant));
		structure.setMessage("Registration successfull");
		structure.setStatusCode(HttpStatus.CREATED.value());
		configuration.setSubject("Registration successfull");
		HashMap<String, String> map = new HashMap<>();
		map.put("email", merchant.getEmail());
		map.put("name", merchant.getName());
		configuration.setText("Hello Mr." + merchant.getName()
				+ " You have successfully initiated the registration for Our E-Commerce application "
				+ "please click on the link to activate your account "
				+ service.getVerificationLink(request, merchant));
		configuration.setUser(map);
		mailService.sendWelcomeMail(configuration);
		return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<String>> verifyMerchant(String token) {
		ResponseStructure<String> structure=new ResponseStructure<>();
		Merchant merchant = dao.verifyMerchant(token);
		if (merchant != null) {
			merchant.setToken(null);
			merchant.setStatus("Active");
			dao.updateMerchant(merchant);
			structure.setData("Your Account is Activated");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Merchant is verified");
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
		}
		structure.setData("Account is not activated");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Invalid Token");
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}

	public String sendResetPasswordLink(String email, HttpServletRequest request) {
		Merchant merchant = dao.findMerchantByEmail(email);
		if (merchant != null) {
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

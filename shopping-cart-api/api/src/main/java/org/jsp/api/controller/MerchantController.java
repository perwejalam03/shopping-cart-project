package org.jsp.api.controller;

import org.jsp.api.dto.Merchant;
import org.jsp.api.dto.ResponseStructure;
import org.jsp.api.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin("http://localhost:3000/")
public class MerchantController {
	@Autowired
	private MerchantService service;

	@PostMapping("/merchants")
	public ResponseEntity<ResponseStructure<Merchant>> savMerchant(@RequestBody Merchant merchant, HttpServletRequest request) {
		return service.savMerchant(merchant, request);
	}

	@GetMapping("/merchants/verify")
	public ResponseEntity<ResponseStructure<String>> verifyMerchant(@RequestParam String token) {
		return service.verifyMerchant(token);
	}
	
	@GetMapping("/merchants/forgot-password")
	public String forgotPassword(@RequestParam String email,HttpServletRequest request) {
		return service.sendResetPasswordLink(email, request);
	}
}

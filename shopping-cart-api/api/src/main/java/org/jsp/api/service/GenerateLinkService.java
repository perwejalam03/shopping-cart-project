package org.jsp.api.service;

import org.jsp.api.dao.MerchantDao;
import org.jsp.api.dto.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import net.bytebuddy.utility.RandomString;

@Service
public class GenerateLinkService {
	@Autowired
	private MerchantDao dao;
	
	public String getVerificationLink(HttpServletRequest request,Merchant merchant) {
		String token=RandomString.make(45);
		merchant.setToken(token);
		merchant.setStatus("InActive");
		dao.updateMerchant(merchant);
		String siteurl=request.getRequestURL().toString();
		String url=siteurl.replace(request.getServletPath(), "");
		String verify_link=url+ "/merchants/verify?token=" +token;
		return verify_link;
	}
}

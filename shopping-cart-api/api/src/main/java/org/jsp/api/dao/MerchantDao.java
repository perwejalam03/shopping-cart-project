package org.jsp.api.dao;

import org.jsp.api.dto.Merchant;
import org.jsp.api.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDao {
	@Autowired
	private MerchantRepository repository;
	public Merchant saveMerchant(Merchant merchant) {
		return repository.save(merchant);
	}
	public Merchant updateMerchant(Merchant merchant) {
		return repository.save(merchant);
	}
	public Merchant verifyMerchant(String token) {
		return repository.findMerchantByToken(token);
	}
}

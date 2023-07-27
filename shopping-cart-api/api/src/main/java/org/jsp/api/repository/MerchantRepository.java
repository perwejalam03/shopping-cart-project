package org.jsp.api.repository;

import org.jsp.api.dto.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MerchantRepository extends JpaRepository<Merchant, Integer>{
	@Query("select m from Merchant m where m.token=?1")
	Merchant findMerchantByToken(String token);
	
	@Query("select m from Merchant m where m.email=?1")
	Merchant findMerchantByEmail(String email);
	
	
}

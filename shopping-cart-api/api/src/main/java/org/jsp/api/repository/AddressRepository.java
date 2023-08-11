package org.jsp.api.repository;

import java.util.List;

import org.jsp.api.dto.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	@Query("select a from Address a where a.user.id=?1")
	public List<Address> findAddressByUserId(int id);

}

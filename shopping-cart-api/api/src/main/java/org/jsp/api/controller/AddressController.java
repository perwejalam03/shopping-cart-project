package org.jsp.api.controller;

import java.util.List;

import org.jsp.api.dto.Address;
import org.jsp.api.dto.ResponseStructure;
import org.jsp.api.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AddressController {
	@Autowired
	private AddressService service;

	@PostMapping("/address/{user_id}")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address,
			@PathVariable int user_id) {
		return service.saveAddress(address, user_id);
	}

	@PutMapping("/address/{user_id}")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestBody Address address,
			@PathVariable int user_id) {
		return service.updateAddress(address, user_id);
	}

	@GetMapping("/address/{id}")
	public ResponseEntity<ResponseStructure<Address>> findById(@PathVariable int id) {
		return service.findAddressById(id);
	}

	@DeleteMapping("/address/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteAddress(@PathVariable int id) {
		return service.deleteAddress(id);
	}

	@GetMapping("/address/all/{uid}")
	public ResponseEntity<ResponseStructure<List<Address>>> findAddressByUserId(@PathVariable int id) {
		return service.findAddressByUserId(id);
	}
}

package org.jsp.api.service;

import java.util.List;
import java.util.Optional;

import org.jsp.api.dao.AddressDao;
import org.jsp.api.dao.UserDao;
import org.jsp.api.dto.Address;
import org.jsp.api.dto.ResponseStructure;
import org.jsp.api.dto.User;
import org.jsp.api.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
	@Autowired
	private AddressDao adao;
	@Autowired
	private UserDao udao;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address, int user_id) {
		Optional<User> recUser = udao.findById(user_id);
		if (recUser.isPresent()) {
			recUser.get().getAddresses().add(address);
			address.setUser(recUser.get());
			ResponseStructure<Address> structure = new ResponseStructure<>();
			structure.setData(adao.saveAddress(address));
			structure.setMessage("Address saved Successfully");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(Address address, int user_id) {
		Optional<User> recUser = udao.findById(user_id);
		if (recUser.isPresent()) {
			recUser.get().getAddresses().add(address);
			address.setUser(recUser.get());
			ResponseStructure<Address> structure = new ResponseStructure<>();
			structure.setData(adao.updateAddress(address));
			structure.setMessage("Address updated Successfully");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.ACCEPTED);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Address>> findAddressById(int id) {
		ResponseStructure<Address> structure = new ResponseStructure<>();
		Optional<Address> recAddress = adao.findById(id);
		if (recAddress.isEmpty()) {
			structure.setData(null);
			structure.setMessage("Address Not Found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.NOT_FOUND);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<String>> deleteAddress(int id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<Address> recAddress = adao.findById(id);
		if (recAddress.isEmpty()) {
			structure.setData("Address not found");
			structure.setMessage("Address Not deleted");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<Address>>> findAddressByUserId(int id) {
		ResponseStructure<List<Address>> structure = new ResponseStructure<>();
		structure.setData(adao.findAddressByUserId(id));
		structure.setMessage("The List of addresses for the user");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Address>>>(structure, HttpStatus.OK);
	}
}

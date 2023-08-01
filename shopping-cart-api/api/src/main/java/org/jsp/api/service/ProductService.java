package org.jsp.api.service;

import java.util.List;
import java.util.Optional;

import org.jsp.api.dao.MerchantDao;
import org.jsp.api.dao.ProductDao;
import org.jsp.api.dto.Merchant;
import org.jsp.api.dto.Product;
import org.jsp.api.dto.ResponseStructure;
import org.jsp.api.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class ProductService {
	@Autowired
	private ProductDao dao;
	@Autowired
	private MerchantDao merchantDao;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product, int mid) {
		ResponseStructure<Product> structure = new ResponseStructure<>();
		Optional<Merchant> recMerchant = merchantDao.findById(mid);
		if (recMerchant.isPresent()) {
			recMerchant.get().getProducts().add(product);
			product.setMerchant(recMerchant.get());
			dao.saveProduct(product);
			merchantDao.updateMerchant(recMerchant.get());
			structure.setData(product);
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("Product added");
			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product, int mid) {
		ResponseStructure<Product> structure = new ResponseStructure<>();
		Optional<Merchant> recMerchant = merchantDao.findById(mid);
		if (recMerchant.isPresent()) {
			recMerchant.get().getProducts().add(product);
			product.setMerchant(recMerchant.get());
			merchantDao.updateMerchant(recMerchant.get());
			structure.setData(product);
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			structure.setMessage("Product updated");
			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.ACCEPTED);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Product>> findById(int id) {
		ResponseStructure<Product> structure = new ResponseStructure<>();
		Optional<Product> recProduct = dao.findById(id);
		if (recProduct.isPresent()) {
			structure.setData(recProduct.get());
			structure.setMessage("Product Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<String>> deleteProduct(int id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<Product> recProduct = dao.findById(id);
		if (recProduct.isPresent()) {
			dao.deleteProduct(id);
			structure.setMessage("Product Deleted");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<Product>>> findProductByMerchantId(int merchant_id) {
		ResponseStructure<List<Product>> structure = new ResponseStructure<>();
		structure.setData(dao.findProductByMerchantId(merchant_id));
		structure.setMessage("Product Found");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure, HttpStatus.OK);
	}
}

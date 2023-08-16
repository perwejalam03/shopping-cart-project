package org.jsp.api.service;

import java.util.List;
import java.util.Optional;

import org.jsp.api.dao.MerchantDao;
import org.jsp.api.dao.ProductDao;
import org.jsp.api.dao.UserDao;
import org.jsp.api.dto.Merchant;
import org.jsp.api.dto.Product;
import org.jsp.api.dto.ResponseStructure;
import org.jsp.api.dto.User;
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
	@Autowired
	private UserDao udao;

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

	public ResponseEntity<ResponseStructure<List<Product>>> findProductsInCart(int id) {
		ResponseStructure<List<Product>> structure = new ResponseStructure<>();
		structure.setData(dao.findProductsInCart(id));
		structure.setMessage("Following are the list of products in cart");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Product>>> findProductsInWishList(int id) {
		ResponseStructure<List<Product>> structure = new ResponseStructure<>();
		structure.setData(dao.findProductsInWishList(id));
		structure.setMessage("Following are the list of products in wishList");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Product>>> findAllProducts() {
		ResponseStructure<List<Product>> structure = new ResponseStructure<>();
		structure.setData(dao.findAllProducts());
		structure.setMessage("Product Found");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> addToCart(int product_id, int user_id) {
		Optional<User> recUser = udao.findById(user_id);
		Optional<Product> recProduct = dao.findById(product_id);
		ResponseStructure<String> structure = new ResponseStructure<>();
		if (recUser.isPresent() && recProduct.isPresent()) {
			recUser.get().getCart().add(recProduct.get());
			udao.updateUser(recUser.get());
			structure.setData("Product added to the cart");
			structure.setMessage("User and Product found");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.ACCEPTED);
		}
		structure.setData("Cannot add Product to the cart");
		structure.setMessage("Invalid UserId or Product Id");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<String>> addToWishList(int product_id, int user_id) {
		Optional<User> recUser = udao.findById(user_id);
		Optional<Product> recProduct = dao.findById(product_id);
		ResponseStructure<String> structure = new ResponseStructure<>();
		if (recUser.isPresent() && recProduct.isPresent()) {
			recUser.get().getWishList().add(recProduct.get());
			udao.updateUser(recUser.get());
			structure.setData("Product added to the wishList");
			structure.setMessage("User and Product found");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.ACCEPTED);
		}
		structure.setData("Cannot add Product to the wishList");
		structure.setMessage("Invalid UserId or Product Id");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<Product>> rateProduct(int product_id, int user_id, double ratings) {
		Optional<User> recUser = udao.findById(user_id);
		Optional<Product> recProduct = dao.findById(product_id);
		ResponseStructure<Product> structure = new ResponseStructure<>();
		if (recUser.isPresent() && recProduct.isPresent()) {
			Product p = recProduct.get();
			int n = p.getNum_of_users();
			double r = p.getRatings() * n++;
			ratings = (r + ratings) / n;
			p.setNum_of_users(n);
			p.setRatings(ratings);
			dao.updateProduct(p);
			structure.setData(p);
			structure.setMessage("Product rated");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.ACCEPTED);
		}
		throw new IdNotFoundException();
	}

}

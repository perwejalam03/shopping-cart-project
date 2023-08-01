package org.jsp.api.dto;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Merchant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, unique = true)
	private long phone;
	@Column(nullable = false, unique = true)
	private String email;
	private String token;
	private String status;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false, unique = true)
	private String gst;
	@Column(nullable = false)
	private String gender;
	@OneToMany(mappedBy = "merchant")
	private List<Product> products;
}

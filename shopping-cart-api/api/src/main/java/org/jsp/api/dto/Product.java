package org.jsp.api.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String brand;
	@Column(nullable = false)
	private String category;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private double price;
	@Column(nullable = false, unique = true)
	private String image;// Change later
	@Column(nullable = false)
	private double ratings;
	@Column(nullable = false)
	private int numOfPplRated;
}

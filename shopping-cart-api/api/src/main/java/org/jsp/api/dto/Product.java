package org.jsp.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	private int num_of_users;
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Merchant merchant;
}

package com.example.TrimbleCars.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String model;
	private String status;
	private String ownerId;
	private String variant;

	@OneToMany(mappedBy = "car")
	private List<Lease> leases;

	@ManyToOne
	@JoinColumn(name = "car_owner_id")
	private CarOwner carOwner;
}

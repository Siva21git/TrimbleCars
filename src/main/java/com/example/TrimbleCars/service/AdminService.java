package com.example.TrimbleCars.service;

import java.util.List;

import com.example.TrimbleCars.entities.Car;
import com.example.TrimbleCars.entities.CarOwner;
import com.example.TrimbleCars.entities.Customer;
import com.example.TrimbleCars.entities.Lease;

public interface AdminService {

	CarOwner registerOwner(CarOwner owner);

	List<CarOwner> getAllOwners();

	Customer registerCustomer(Customer customer);

	List<Car> getAllAvailableCars();

	Lease startLeaseAsAdmin(Long customerId, Long carId);

	Lease endLeaseAsAdmin(Long leaseId);

	List<Lease> getAllLeases();

}

package com.example.TrimbleCars.service;

import java.util.List;

import com.example.TrimbleCars.entities.Car;
import com.example.TrimbleCars.entities.Customer;
import com.example.TrimbleCars.entities.Lease;

public interface CustomerService {

	Customer getCustomerDetails(Long customerId);

	Customer registerCustomer(Customer customer);

	List<Car> viewAvailableCars();

	Lease startLease(Long customerId, Long carId);

	Lease endLease(Long leaseId);

}

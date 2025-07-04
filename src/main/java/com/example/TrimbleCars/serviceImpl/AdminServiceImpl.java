package com.example.TrimbleCars.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TrimbleCars.entities.Car;
import com.example.TrimbleCars.entities.CarOwner;
import com.example.TrimbleCars.entities.Customer;
import com.example.TrimbleCars.entities.Lease;
import com.example.TrimbleCars.service.AdminService;
import com.example.TrimbleCars.service.CarOwnerService;
import com.example.TrimbleCars.service.CarService;
import com.example.TrimbleCars.service.CustomerService;
import com.example.TrimbleCars.service.LeaseService;

@Service
public class AdminServiceImpl implements AdminService {

	
	@Autowired
    private CarOwnerService carOwnerService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CarService carService;

    @Autowired
    private LeaseService leaseService;

    // Car Owner operations
    @Override
    public CarOwner registerOwner(CarOwner owner) {
        return carOwnerService.registerOwner(owner);
    }

    @Override
    public List<CarOwner> getAllOwners() {
        return carOwnerService.getAllOwners();
    }

    // Customer operations
    @Override
    public Customer registerCustomer(Customer customer) {
        return customerService.registerCustomer(customer);
    }

    @Override
    public List<Car> getAllAvailableCars() {
        return customerService.viewAvailableCars();
    }

    @Override
    public Lease startLeaseAsAdmin(Long customerId, Long carId) {
        return customerService.startLease(customerId, carId);
    }

    @Override
    public Lease endLeaseAsAdmin(Long leaseId) {
        return customerService.endLease(leaseId);
    }

    // Admin-specific
    @Override
    public List<Lease> getAllLeases() {
        return leaseService.getAllLeases();
    }
}

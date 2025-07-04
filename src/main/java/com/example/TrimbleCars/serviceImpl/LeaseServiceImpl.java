package com.example.TrimbleCars.serviceImpl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TrimbleCars.Exception.LeaseLimitExceededException;
import com.example.TrimbleCars.Exception.LeaseNotFoundException;
import com.example.TrimbleCars.entities.Car;
import com.example.TrimbleCars.entities.Customer;
import com.example.TrimbleCars.entities.Lease;
import com.example.TrimbleCars.repository.LeaseRepository;
import com.example.TrimbleCars.service.CarService;
import com.example.TrimbleCars.service.CustomerService;
import com.example.TrimbleCars.service.LeaseService;

@Service
public class LeaseServiceImpl implements LeaseService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private LeaseRepository leaseRepository;
	@Autowired
	private CarService carService;
	@Autowired
	private CustomerService customerService;

	@Override
	public Lease startLease(Long carId, Long customerId) {
		try {
			Car car = carService.getCarDetails(carId);
			Customer customer = customerService.getCustomerDetails(customerId);
			logger.info("Registering customer: {}", customer.getName());

			if (customer.getLeases().size() >= 2) {
				throw new LeaseLimitExceededException("Cannot lease more than 2 cars at once");
			}

			Lease lease = new Lease();
			lease.setCar(car);
			lease.setCustomer(customer);
			lease.setLeaseStartDate(new Date());
			leaseRepository.save(lease);

			car.setStatus("On Lease");
			carService.registerCar(car);
			return lease;
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return null;
	}

	@Override
	public void endLease(Long leaseId) {
		try {
			Lease lease = leaseRepository.findById(leaseId)
					.orElseThrow(() -> new LeaseNotFoundException("Lease not found"));
			Car car = lease.getCar();
			car.setStatus("Ideal");
			carService.registerCar(car);
			leaseRepository.delete(lease);
		} catch (LeaseNotFoundException e) {
			logger.info(e.getMessage());
		}
	}

	@Override
	public List<Lease> getAllLeases() {
		try {
			return leaseRepository.findAll();
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return Collections.emptyList();
	}

	@Override
	public List<Lease> getLeasesByCustomerId(Long customerId) {
		try {
			return leaseRepository.findByCustomerId(customerId);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return Collections.emptyList();
	}
}

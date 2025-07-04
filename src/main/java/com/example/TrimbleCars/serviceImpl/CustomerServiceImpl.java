package com.example.TrimbleCars.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TrimbleCars.Exception.CarNotFoundException;
import com.example.TrimbleCars.Exception.CustomerNotFoundException;
import com.example.TrimbleCars.entities.Car;
import com.example.TrimbleCars.entities.Customer;
import com.example.TrimbleCars.entities.Lease;
import com.example.TrimbleCars.repository.CarRepository;
import com.example.TrimbleCars.repository.CustomerRepository;
import com.example.TrimbleCars.repository.LeaseRepository;
import com.example.TrimbleCars.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{
	

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private LeaseRepository leaseRepository;

    @Override
    public Customer registerCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Car> viewAvailableCars() {
        return carRepository.findByStatus("AVAILABLE");
    }

    @Override
    public Lease startLease(Long customerId, Long carId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + customerId));
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new CarNotFoundException("Car not found with ID: " + carId));

        List<Lease> activeLeases = leaseRepository.findByCustomerIdAndLeaseEndDateIsNull(customerId);
        if (activeLeases.size() >= 2) {
            throw new RuntimeException("Customer already has 2 active leases.");
        }

        if (!car.getStatus().equals("AVAILABLE")) {
            throw new RuntimeException("Car is not available for lease.");
        }

        car.setStatus("ON_LEASE");
        carRepository.save(car);

        Lease lease = new Lease();
        lease.setCar(car);
        lease.setCustomer(customer);
        lease.setLeaseStartDate(new Date());

        return leaseRepository.save(lease);
    }

    @Override
    public Lease endLease(Long leaseId) {
        Lease lease = leaseRepository.findById(leaseId)
                .orElseThrow(() -> new RuntimeException("Lease not found with ID: " + leaseId));
        lease.setLeaseEndDate(new Date());

        Car car = lease.getCar();
        car.setStatus("AVAILABLE");
        carRepository.save(car);

        return leaseRepository.save(lease);
    }

    public List<Lease> getCustomerLeaseHistory(Long customerId) {
        return leaseRepository.findByCustomerId(customerId);
    }

	@Override
	public Customer getCustomerDetails(Long customerId) {
		    return customerRepository.findById(customerId)
		            .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + customerId));
		}

}

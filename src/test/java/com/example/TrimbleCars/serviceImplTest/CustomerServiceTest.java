package com.example.TrimbleCars.serviceImplTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.TrimbleCars.entities.Customer;
import com.example.TrimbleCars.repository.CarRepository;
import com.example.TrimbleCars.repository.CustomerRepository;
import com.example.TrimbleCars.repository.LeaseRepository;
import com.example.TrimbleCars.service.CustomerService;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
	@InjectMocks
	private CustomerService customerService;

	@Mock
	private CustomerRepository customerRepository;

	@Mock
	private CarRepository carRepository;

	@Mock
	private LeaseRepository leaseRepository;

	@Test
	public void testRegisterCustomer() {
		Customer customer = new Customer();
		customer.setName("John Doe");

		when(customerRepository.save(any())).thenReturn(customer);

		Customer result = customerService.registerCustomer(customer);

		assertEquals("John Doe", result.getName());
		verify(customerRepository, times(1)).save(customer);
	}

	@Test
	public void testViewAvailableCars() {
		when(carRepository.findByStatus("AVAILABLE")).thenReturn(Collections.emptyList());

		assertTrue(customerService.viewAvailableCars().isEmpty());
		verify(carRepository, times(1)).findByStatus("AVAILABLE");
	}
}

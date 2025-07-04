package com.example.TrimbleCars.serviceImplTest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.TrimbleCars.entities.Customer;
import com.example.TrimbleCars.entities.Lease;
import com.example.TrimbleCars.service.AdminService;
import com.example.TrimbleCars.service.CarOwnerService;
import com.example.TrimbleCars.service.CustomerService;
import com.example.TrimbleCars.service.LeaseService;

@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {
	@InjectMocks
    private AdminService adminService;

    @Mock
    private CustomerService customerService;

    @Mock
    private CarOwnerService carOwnerService;

    @Mock
    private LeaseService leaseService;

    @Test
    public void testGetAllLeases() {
        Lease lease = new Lease();
        when(leaseService.getAllLeases()).thenReturn(List.of(lease));

        List<Lease> leases = adminService.getAllLeases();
        assertEquals(1, leases.size());
        verify(leaseService, times(1)).getAllLeases();
    }

    @Test
    public void testRegisterCustomerDelegates() {
        Customer customer = new Customer();
        customer.setName("Alice");

        when(customerService.registerCustomer(customer)).thenReturn(customer);

        Customer result = adminService.registerCustomer(customer);
        assertEquals("Alice", result.getName());
    }
}

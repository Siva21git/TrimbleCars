package com.example.TrimbleCars.serviceImplTest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.TrimbleCars.entities.Lease;
import com.example.TrimbleCars.repository.LeaseRepository;
import com.example.TrimbleCars.service.LeaseService;

public class LeaseServiceTest {
	@InjectMocks
	private LeaseService leaseService;

	@Mock
	private LeaseRepository leaseRepository;

	@Test
	public void testGetAllLeases() {
		Lease lease = new Lease();
		when(leaseRepository.findAll()).thenReturn(List.of(lease));

		List<Lease> leases = leaseService.getAllLeases();
		assertEquals(1, leases.size());
		verify(leaseRepository, times(1)).findAll();
	}

	@Test
	public void testGetLeasesByCustomerId() {
		when(leaseRepository.findByCustomerId(100L)).thenReturn(Collections.emptyList());
		assertTrue(leaseService.getLeasesByCustomerId(100L).isEmpty());
	}
}

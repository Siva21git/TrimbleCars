package com.example.TrimbleCars.service;

import java.util.List;

import com.example.TrimbleCars.entities.Lease;

public interface LeaseService {

	Lease startLease(Long carId, Long customerId);

	void endLease(Long leaseId);

	List<Lease> getAllLeases();

	List<Lease> getLeasesByCustomerId(Long customerId);

}

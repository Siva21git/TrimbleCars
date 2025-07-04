package com.example.TrimbleCars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TrimbleCars.entities.Lease;

public interface LeaseRepository extends JpaRepository<Lease, Long>{

	List<Lease> findByCustomerIdAndLeaseEndDateIsNull(Long customerId);

	List<Lease> findByCustomerId(Long customerId);

}

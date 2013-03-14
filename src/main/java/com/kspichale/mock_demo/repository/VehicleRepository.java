package com.kspichale.mock_demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kspichale.mock_demo.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

	List<Vehicle> findByAvailable(boolean available);
}

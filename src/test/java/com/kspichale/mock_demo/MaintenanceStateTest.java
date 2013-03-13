package com.kspichale.mock_demo;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.kspichale.mock_demo.Maintenance;
import com.kspichale.mock_demo.Vehicle;
import com.kspichale.mock_demo.VehicleFleet;
import com.kspichale.mock_demo.VehicleFleetImpl;

public class MaintenanceStateTest {

	private Vehicle vehicle = new Vehicle("car");
	private VehicleFleet fleet = new VehicleFleetImpl();

	@Before
	public void setUp() {
		fleet.add(vehicle);
	}

	@Test
	public void vehicleIsNotAvailableWhenScheduledForMaintenance() {
		Maintenance maintenance = new Maintenance(vehicle);
		assertThat(maintenance.schedule(fleet)).isTrue();
		assertThat(fleet.getAvailableVehicles()).isEmpty();
	}
}

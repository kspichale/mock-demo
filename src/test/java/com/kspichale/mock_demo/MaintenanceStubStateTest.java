package com.kspichale.mock_demo;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class MaintenanceStubStateTest {

	private Vehicle vehicle = new Vehicle();
	private VehicleFleet fleet = new VehicleFleetStub();

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

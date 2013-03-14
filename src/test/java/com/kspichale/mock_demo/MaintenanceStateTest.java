package com.kspichale.mock_demo;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:repository-context.xml")
@Transactional
public class MaintenanceStateTest {

	private Vehicle vehicle = new Vehicle();
	
	@Autowired
	private VehicleFleet fleet;

	@Test
	public void vehicleIsNotAvailableWhenScheduledForMaintenance() {
		Maintenance maintenance = new Maintenance(vehicle);
		assertThat(maintenance.schedule(fleet)).isTrue();
		assertThat(fleet.getAvailableVehicles()).isEmpty();
	}
}

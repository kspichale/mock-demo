package com.kspichale.mock_demo;

import static org.fest.assertions.Assertions.assertThat;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import com.kspichale.mock_demo.Maintenance;
import com.kspichale.mock_demo.Vehicle;
import com.kspichale.mock_demo.VehicleFleet;

public class MaintenanceBehaviorTest {

	@Rule
	public JUnitRuleMockery context = new JUnitRuleMockery();

	/*-
	 * When calling schedule we expect that:
	 * -> method isAvailable gets called with parameter vehicle, the mock should return true
	 * -> method setAvailability gets called with parameters (vehicle, false) 
	 */
	@Test
	public void vehicleIsNotAvailableWhenScheduledForMaintenance() {

		// setup data
		final Vehicle vehicle = new Vehicle();
		Maintenance maintenance = new Maintenance(vehicle);
		final VehicleFleet fleet = context.mock(VehicleFleet.class);

		// setup expectations
		context.checking(new Expectations() {
			{
				oneOf(fleet).isAvailable(vehicle);
				will(returnValue(true));
				oneOf(fleet).setAvailability(vehicle, false);
			}
		});

		// exercise and verify
		assertThat(maintenance.schedule(fleet)).isTrue();
	}

}

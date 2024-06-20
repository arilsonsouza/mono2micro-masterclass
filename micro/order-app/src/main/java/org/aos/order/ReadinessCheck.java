package org.aos.order;

import org.aos.order.service.FlightService;
import org.aos.order.service.HotelService;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;

@Readiness
public class ReadinessCheck implements HealthCheck {

  @Inject
  @RestClient
  FlightService flightService;

  @Inject
  @RestClient
  HotelService hotelService;

  @Override
  public HealthCheckResponse call() {
    // if ((flightService.findById(1) != null) && (flightService.findById(1) !=
    // null)) {
    return HealthCheckResponse.up("I'm ready!");
    // } else {
    // return HealthCheckResponse.down("I am not ready!");
    // }
  }

}

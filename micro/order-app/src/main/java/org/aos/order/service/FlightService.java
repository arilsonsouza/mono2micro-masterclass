package org.aos.order.service;

import java.time.temporal.ChronoUnit;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "http://flight-app-arilson-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com/flights")
public interface FlightService {

  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Flight findById(@PathParam("id") long id);

  @GET
  @Path("/order/{orderId}")
  @Produces(MediaType.APPLICATION_JSON)
  @Timeout(unit = ChronoUnit.SECONDS, value = 2)
  @Fallback(fallbackMethod = "fallback")
  @CircuitBreaker(requestVolumeThreshold = 4, failureRatio = 0.5, delay = 5000, successThreshold = 2)
  public Flight findByOrderId(@PathParam("orderId") long orderId);

  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @POST
  public Flight newFlight(Flight flight);

  default Flight fallback(long orderId) {
    Flight flight = new Flight();
    flight.setFromAirport("");
    flight.setToAirport("");
    flight.setOrderId(orderId);
    flight.setId(0L);
    return flight;
  }
}

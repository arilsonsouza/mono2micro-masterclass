package org.aos.flight;

import java.util.List;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("flights")
public class FlightResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Flight> flights() {
    return Flight.listAll();
  }

  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Flight findById(@PathParam("id") long id) {
    return Flight.findById(id);
  }

  @GET
  @Path("/order/{orderId}")
  @Produces(MediaType.APPLICATION_JSON)
  public Flight findByOrderId(@PathParam("orderId") long orderId) {
    return Flight.findByOrderId(orderId);
  }

  @Transactional
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @POST
  public Flight newFlight(Flight flight) {
    flight.id = null;
    flight.persist();
    return flight;
  }
}

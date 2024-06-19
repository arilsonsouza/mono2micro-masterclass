package org.aos.order.service;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "http://localhost:8082/hotels")
public interface HotelService {

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Hotel findById(@PathParam("id") long id);

  @GET
  @Path("order/{orderId}")
  @Produces(MediaType.APPLICATION_JSON)
  public Hotel findByOrderId(@PathParam("orderId") long orderId);

  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @POST
  public Hotel newHotel(Hotel hotel);
}

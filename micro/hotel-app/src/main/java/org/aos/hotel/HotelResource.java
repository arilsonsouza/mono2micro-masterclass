package org.aos.hotel;

import java.util.List;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("hotels")
public class HotelResource {
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Hotel> hotels() {
    return Hotel.listAll();
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Hotel findById(@PathParam("id") long id) {
    return Hotel.findById(id);
  }

  @GET
  @Path("order/{orderId}")
  @Produces(MediaType.APPLICATION_JSON)
  public Hotel findByOrderId(@PathParam("orderId") long orderId) {
    return Hotel.findByOrderId(orderId);
  }

  @Transactional
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @POST
  public Hotel newHotel(Hotel hotel) {
    hotel.id = null;
    hotel.persist();

    return hotel;
  }
}

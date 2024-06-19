package org.aos.order;

import java.util.List;
import java.util.stream.Collectors;

import org.aos.order.service.Flight;
import org.aos.order.service.FlightService;
import org.aos.order.service.Hotel;
import org.aos.order.service.HotelService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("orders")
public class OrderResource {

  @Inject
  @RestClient
  FlightService flightService;

  @Inject
  @RestClient
  HotelService hotelService;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<OrderDTO> orders() {
    return Order.<Order>listAll().stream()
        .map(
            order -> OrderDTO.of(
                order,
                flightService.findByOrderId(order.id),
                hotelService.findByOrderId(order.id))

        ).collect(Collectors.toList());
  }

  @Path("/{id}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Order findById(@PathParam("id") long id) {
    return Order.findById(id);
  }

  @Transactional
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Order newOrder(OrderDTO orderDto) {
    Order order = new Order();
    order.id = null;
    order.persistAndFlush();

    Flight flight = new Flight();
    flight.setFromAirport(orderDto.getFromAirport());
    flight.setToAirport(orderDto.getToAirport());
    flight.setOrderId(order.id);
    flightService.newFlight(flight);

    Hotel hotel = new Hotel();
    hotel.setNights(orderDto.getNights());
    hotel.setOrderId(order.id);
    hotelService.newHotel(hotel);

    return order;
  }
}

package org.aos.order;

import java.util.List;
import java.util.stream.Collectors;

import org.aos.flight.Flight;
import org.aos.flight.FlightResource;
import org.aos.hotel.Hotel;
import org.aos.hotel.HotelResource;

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
  FlightResource flightResource;

  @Inject
  HotelResource hotelResource;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<OrderDTO> orders() {
    return Order.<Order>listAll().stream()
        .map(
            order -> OrderDTO.of(
                order,
                flightResource.findByOrderId(order.id),
                hotelResource.findByOrderId(order.id))

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
    flight.fromAirport = orderDto.getFromAirport();
    flight.toAirport = orderDto.getToAirport();
    flight.orderId = order.id;
    flightResource.newFlight(flight);

    Hotel hotel = new Hotel();
    hotel.nights = orderDto.getNights();
    hotel.orderId = order.id;
    hotelResource.newHotel(hotel);

    return order;
  }
}

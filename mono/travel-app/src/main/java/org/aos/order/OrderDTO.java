package org.aos.order;

import org.aos.flight.Flight;
import org.aos.hotel.Hotel;

public class OrderDTO {
  private String fromAirport;
  private String toAirport;
  private Integer nights;

  public OrderDTO() {

  }

  private OrderDTO(String fromAirport, String toAirport, Integer nights) {
    this.fromAirport = fromAirport;
    this.toAirport = toAirport;
    this.nights = nights;
  }

  public static OrderDTO of(Order order, Flight flight, Hotel hotel) {
    return new OrderDTO(flight.fromAirport, flight.toAirport, hotel.nights);
  }

  public static OrderDTO of(String fromAirport, String toAirport, Integer nights) {
    return new OrderDTO(fromAirport, toAirport, nights);
  }

  public String getFromAirport() {
    return fromAirport;
  }

  public void setFromAirport(String fromAirport) {
    this.fromAirport = fromAirport;
  }

  public String getToAirport() {
    return toAirport;
  }

  public void setToAirport(String toAirport) {
    this.toAirport = toAirport;
  }

  public Integer getNights() {
    return nights;
  }

  public void setNights(Integer nights) {
    this.nights = nights;
  }
}

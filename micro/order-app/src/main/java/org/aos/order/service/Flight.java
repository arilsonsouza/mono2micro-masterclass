package org.aos.order.service;

public class Flight {
  private Long id;
  private Long orderId;
  private String fromAirport;
  private String toAirport;

  public Flight() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
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

}

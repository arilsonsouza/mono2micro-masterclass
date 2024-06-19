package org.aos.order.service;

public class Hotel {
  private Long id;
  private Long orderId;
  private Integer nights;

  public Hotel() {
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

  public Integer getNights() {
    return nights;
  }

  public void setNights(Integer nights) {
    this.nights = nights;
  }

}

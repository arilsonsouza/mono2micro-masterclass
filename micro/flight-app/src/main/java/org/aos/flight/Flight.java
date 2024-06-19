package org.aos.flight;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity(name = "flight")
@Table(name = "flights")
public class Flight extends PanacheEntity {

  public Long orderId;
  public String fromAirport;
  public String toAirport;

  public static Flight findByOrderId(Long orderId) {
    return find("orderId", orderId).firstResult();
  }
}

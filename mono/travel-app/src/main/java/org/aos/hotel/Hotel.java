package org.aos.hotel;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity(name = "hotel")
@Table(name = "hotels")
public class Hotel extends PanacheEntity {
  public Long orderId;
  public Integer nights;

  public static Hotel findByOrderId(Long orderId) {
    return find("orderId", orderId).firstResult();
  }
}

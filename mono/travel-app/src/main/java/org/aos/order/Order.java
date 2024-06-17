package org.aos.order;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity(name = "orders")
@Table(name = "orders")
public class Order extends PanacheEntity {

}

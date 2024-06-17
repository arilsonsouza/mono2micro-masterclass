package org.aos.order;

import java.util.List;

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

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Order> orders() {
    return Order.listAll();
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
  public Order newOrder(Order order) {
    order.id = null;
    order.persist();

    return order;
  }
}

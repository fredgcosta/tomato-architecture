package io.tomato.order.application;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/v1/orders")
@Produces(APPLICATION_JSON)
public class OrderResource {
    //
    //    private static final Logger LOGGER = Logger.getLogger(OrderResource.class);
    //
    //    @Inject
    //    OrderService service;
    //
    //    @Operation(summary = "Returns all the orders from the database")
    //    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Order.class, type = SchemaType.ARRAY)))
    //    @APIResponse(responseCode = "204", description = "No orders")
    //    @GET
    //    public Response getAllOrders(@QueryParam("name") String name) {
    //        List<Order> orders = service.pesquisaPorName(name);
    //        LOGGER.debug("Total number of orders " + orders);
    //        return Response.ok(orders).build();
    //    }
    //
    //    @Operation(summary = "Returns a order for a given identifier")
    //    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Order.class)))
    //    @APIResponse(responseCode = "204", description = "The order is not found for a given identifier")
    //    @GET
    //    @Path("/{id}")
    //    public Response getOrder(
    //
    //            @Parameter(description = "Order identifier", required = true)
    //
    //            @PathParam("id") Long id) {
    //        Order order = service.findOrderById(id);
    //        if (order != null) {
    //            LOGGER.debug("Found order " + order);
    //            return Response.ok(order).build();
    //        } else {
    //            LOGGER.debug("No order found with id " + id);
    //            return Response.noContent().build();
    //        }
    //    }
    //
    //    @Operation(summary = "Creates a valid order")
    //    @APIResponse(responseCode = "201", description = "The URI of the created order", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = URI.class)))
    //    @POST
    //    public Response createOrder(
    //
    //            @RequestBody(required = true, content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Order.class)))
    //
    //            @Valid Order order, @Context UriInfo uriInfo) {
    //        order.setId(null);
    //        order = service.persistOrder(order);
    //        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(order.getId()));
    //        LOGGER.debug("New order created with URI " + builder.build().toString());
    //        return Response.created(builder.build()).build();
    //    }
    //
    //    @Operation(summary = "Updates an exiting  order")
    //    @APIResponse(responseCode = "200", description = "The updated order", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Order.class)))
    //    @PUT
    //    @Path("/{id}")
    //    public Response updateOrder(@Parameter(description = "Order identifier", required = true) @PathParam("id") Long id,
    //            @RequestBody(required = true, content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Order.class))) @Valid Order order) {
    //        order.setId(id);
    //        order = service.updateOrder(order);
    //        LOGGER.debug("Order updated with new valued " + order);
    //        return Response.ok(order).build();
    //    }
    //
    //    @Operation(summary = "Deletes an exiting order")
    //    @APIResponse(responseCode = "204")
    //    @DELETE
    //    @Path("/{id}")
    //    public Response deleteOrder(
    //
    //            @Parameter(description = "Order identifier", required = true)
    //
    //            @PathParam("id") Long id) {
    //        service.deleteOrder(id);
    //        LOGGER.debug("Order deleted with " + id);
    //        return Response.noContent().build();
    //    }
    //
    //    @GET
    //    @Produces(TEXT_PLAIN)
    //    @Path("/hello")
    //    public String hello() {
    //        return "hello";
    //    }
}

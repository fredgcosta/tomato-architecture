package io.tomato.customer.application;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/v1/customers")
@Produces(APPLICATION_JSON)
public class CustomerResource {
    //
    //    private static final Logger LOGGER = Logger.getLogger(CustomerResource.class);
    //
    //    @Inject
    //    CustomerService service;
    //
    //    @Operation(summary = "Returns all the customers from the database")
    //    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Customer.class, type = SchemaType.ARRAY)))
    //    @APIResponse(responseCode = "204", description = "No customers")
    //    @GET
    //    public Response getAllCustomers(@QueryParam("name") String name) {
    //        List<Customer> customers = service.findAllCustomers(name);
    //        LOGGER.debug("Total number of customers " + customers);
    //        return Response.ok(customers).build();
    //    }
    //
    //    @Operation(summary = "Returns a customer for a given identifier")
    //    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Customer.class)))
    //    @APIResponse(responseCode = "204", description = "The customer is not found for a given identifier")
    //    @GET
    //    @Path("/{id}")
    //    public Response getCustomer(
    //
    //            @Parameter(description = "Customer identifier", required = true)
    //
    //            @PathParam("id") Long id) {
    //        Customer customer = service.findCustomerById(id);
    //        if (customer != null) {
    //            LOGGER.debug("Found customer " + customer);
    //            return Response.ok(customer).build();
    //        } else {
    //            LOGGER.debug("No customer found with id " + id);
    //            return Response.noContent().build();
    //        }
    //    }
    //
    //    @Operation(summary = "Creates a valid customer")
    //    @APIResponse(responseCode = "201", description = "The URI of the created customer", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = URI.class)))
    //    @POST
    //    public Response createCustomer(
    //
    //            @RequestBody(required = true, content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Customer.class)))
    //
    //            @Valid Customer customer, @Context UriInfo uriInfo) {
    //        customer.setId(null);
    //        customer = service.persistCustomer(customer);
    //        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(customer.getId()));
    //        LOGGER.debug("New customer created with URI " + builder.build().toString());
    //        return Response.created(builder.build()).build();
    //    }
    //
    //    @Operation(summary = "Updates an exiting  customer")
    //    @APIResponse(responseCode = "200", description = "The updated customer", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Customer.class)))
    //    @PUT
    //    @Path("/{id}")
    //    public Response updateCustomer(@Parameter(description = "Customer identifier", required = true) @PathParam("id") Long id,
    //            @RequestBody(required = true, content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Customer.class))) @Valid Customer customer) {
    //        customer.setId(id);
    //        customer = service.updateCustomer(customer);
    //        LOGGER.debug("Customer updated with new valued " + customer);
    //        return Response.ok(customer).build();
    //    }
    //
    //    @Operation(summary = "Deletes an exiting customer")
    //    @APIResponse(responseCode = "204")
    //    @DELETE
    //    @Path("/{id}")
    //    public Response deleteCustomer(
    //
    //            @Parameter(description = "Customer identifier", required = true)
    //
    //            @PathParam("id") Long id) {
    //        service.deleteCustomer(id);
    //        LOGGER.debug("Customer deleted with " + id);
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

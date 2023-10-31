package io.tomato.catalog.application;

import io.tomato.catalog.application.dtos.ProductDTO;
import io.tomato.catalog.application.mappers.ProductMapper;
import io.tomato.catalog.domain.Product;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.logging.Logger;

import java.net.URI;
import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/v1/products")
@Produces(APPLICATION_JSON)
public class ProductResource {

    private static final Logger LOGGER = Logger.getLogger(ProductResource.class);

    @Inject
    ProductService service;
    @Inject
    ProductMapper mapper;

    @Operation(summary = "Returns all the products from the database")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = ProductDTO.class, type = SchemaType.ARRAY)))
    @APIResponse(responseCode = "204", description = "No products")
    @GET
    public Response getAllProducts(@QueryParam("name") String name) {
        List<ProductDTO> products = mapper.domainListToDtoList(service.findAllProducts(name));
        LOGGER.debug("Total number of products " + products);
        return Response.ok(products).build();
    }

    @Operation(summary = "Returns a product for a given identifier")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = ProductDTO.class)))
    @APIResponse(responseCode = "204", description = "The product is not found for a given identifier")
    @GET
    @Path("/{id}")
    public Response getProduct(
            @Parameter(description = "Product identifier", required = true)
            @PathParam("id") Long id) throws Exception {
        Product product = service.findProductById(id);
        if (product != null) {
            LOGGER.debug("Found product " + product);
            return Response.ok(mapper.domainToDTO(product)).build();
        } else {
            LOGGER.debug("No product found with id " + id);
            return Response.noContent().build();
        }
    }

    @Operation(summary = "Creates a valid product")
    @APIResponse(responseCode = "201", description = "The URI of the created product", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = URI.class)))
    @POST
    public Response createProduct(
            @RequestBody(required = true, content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = ProductDTO.class)))
            @Valid ProductDTO dto, @Context UriInfo uriInfo) {
        dto.setId(null);
        Product product = mapper.dtoToDomain(dto);
        product = service.persistProduct(product);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(product.getId()));
        LOGGER.debug("New product created with URI " + builder.build().toString());
        return Response.created(builder.build()).build();
    }

    @Operation(summary = "Updates an exiting  product")
    @APIResponse(responseCode = "200", description = "The updated product", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = ProductDTO.class)))
    @PUT
    @Path("/{id}")
    public Response updateProduct(@Parameter(description = "Product identifier", required = true) @PathParam("id") Long id,
            @RequestBody(required = true, content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = ProductDTO.class))) @Valid ProductDTO dto)
            throws Exception {
        dto.setId(id);
        Product product = mapper.dtoToDomain(dto);
        product = service.updateProduct(product);
        LOGGER.debug("Product updated with new valued " + product);
        return Response.ok(mapper.domainToDTO(product)).build();
    }

    @Operation(summary = "Deletes an exiting product")
    @APIResponse(responseCode = "204")
    @DELETE
    @Path("/{id}")
    public Response deleteProduct(
            @Parameter(description = "Product identifier", required = true)
            @PathParam("id") Long id) throws Exception {
        service.deleteProduct(id);
        LOGGER.debug("Product deleted with " + id);
        return Response.noContent().build();
    }
}

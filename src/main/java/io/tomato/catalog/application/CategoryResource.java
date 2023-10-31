package io.tomato.catalog.application;

import io.tomato.catalog.application.dtos.CategoryDTO;
import io.tomato.catalog.application.mappers.CategoryMapper;
import io.tomato.catalog.domain.Category;
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

@Path("/v1/categories")
@Produces(APPLICATION_JSON)
public class CategoryResource {
    private static final Logger LOGGER = Logger.getLogger(CategoryResource.class);
    @Inject
    CategoryService service;

    @Inject
    CategoryMapper categoryMapper;

    @Operation(summary = "Returns all the categories from the database")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = CategoryDTO.class, type = SchemaType.ARRAY)))
    @APIResponse(responseCode = "204", description = "No categories")
    @GET
    public Response getAllCategories(@QueryParam("name") String name) {
        List<Category> categories = service.findAllCategories(name);
        List<CategoryDTO> dtos = categoryMapper.domainListToDtoList(categories);
        LOGGER.debug("Total number of categories " + dtos);
        return Response.ok(dtos).build();
    }

    @Operation(summary = "Returns a category for a given identifier")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = CategoryDTO.class)))
    @APIResponse(responseCode = "204", description = "The category is not found for a given identifier")
    @GET
    @Path("/{id}")
    public Response getCategory(
            @Parameter(description = "Category identifier", required = true)
            @PathParam("id") Long id) throws Exception {

        Category category = service.findCategoryById(id);

        CategoryDTO dto = categoryMapper.domainToDto(category);
        if (dto != null) {
            LOGGER.debug("Found category " + dto);
            return Response.ok(dto).build();
        } else {
            LOGGER.debug("No category found with id " + id);
            return Response.noContent().build();
        }
    }

    @Operation(summary = "Creates a valid category")
    @APIResponse(responseCode = "201", description = "The URI of the created category", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = URI.class)))
    @POST
    public Response createCategory(
            @RequestBody(required = true, content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = CategoryDTO.class)))
            @Valid CategoryDTO dto, @Context UriInfo uriInfo) {
        dto.setId(null);
        Category category = service.persistCategory(categoryMapper.dtoToDomain(dto));
        dto = categoryMapper.domainToDto(category);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(dto.getId()));
        LOGGER.debug("New category created with URI " + builder.build().toString());
        return Response.created(builder.build()).build();
    }

    @Operation(summary = "Updates an exiting  category")
    @APIResponse(responseCode = "200", description = "The updated category", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = CategoryDTO.class)))
    @PUT
    @Path("/{id}")
    public Response updateCategory(@Parameter(description = "Category identifier", required = true) @PathParam("id") Long id,
            @RequestBody(required = true, content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = CategoryDTO.class))) @Valid CategoryDTO dto)
            throws Exception {
        dto.setId(id);
        Category category = service.updateCategory(categoryMapper.dtoToDomain(dto));
        dto = categoryMapper.domainToDto(category);
        LOGGER.debug("Category updated with new valued " + dto);
        return Response.ok(dto).build();
    }

    @Operation(summary = "Deletes an exiting category")
    @APIResponse(responseCode = "204")
    @DELETE
    @Path("/{id}")
    public Response deleteCategory(
            @Parameter(description = "Category identifier", required = true)
            @PathParam("id") Long id) throws Exception {
        service.deleteCategory(id);
        LOGGER.debug("Category deleted with " + id);
        return Response.noContent().build();
    }
}

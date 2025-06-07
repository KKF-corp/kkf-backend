package pl.corp.kkf.services.dictionaries.api.servicetypes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.services.dictionaries.api.servicetypes.dto.ServiceType;

import java.util.List;

@Path("/dictionaries/service-types")
@Tag(name = "ServiceTypeApiService", description = "Usługa obsługi danych słownikowych typu serwisu")
public interface ServiceTypeApiService {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Pobranie typu serwisu")
    ServiceType getServiceType(@Parameter(description = "Identyfikator typu serwisu")
                                 @PathParam("id") long id);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Utworzenie typu serwisu")
    ServiceType createServiceType(@Parameter(description = "Obiekt typu serwisu")
                                    ServiceType serviceType);

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Modyfikacja typu serwisu")
    ServiceType updateServiceType(@Parameter(description = "Obiekt typu serwisu")
                                    ServiceType serviceType);

     @POST
    @Path("/archive/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Archiwizacja typu serwisu")
    GeneralResponse archiveServiceType(@Parameter(description = "Identyfikator typu serwisu")
                                 @PathParam("id") long id);

    @POST
    @Path("/un-archive/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Odarchiwizowanie typu serwisu")
    GeneralResponse unarchiveServiceType(@Parameter(description = "Identyfikator typu serwisu")
                                   @PathParam("id") long id);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<ServiceType> getAllServiceTypes();
}
package pl.corp.kkf.services.dictionaries.api.services;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.services.dictionaries.api.services.dto.Service;

import java.util.List;

@Path("/dictionaries/services")
@Tag(name = "ServiceApiService", description = "Usługa obsługi danych słownikowych serwisu")
public interface ServiceApiService {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Pobranie serwisu")
    Service getService(@Parameter(description = "Identyfikator serwisu")
                         @PathParam("id") long id);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Utworzenie serwisu")
    Service createService(@Parameter(description = "Obiekt serwisu")
                            Service service);

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Modyfikacja serwisu")
    Service updateService(@Parameter(description = "Obiekt serwisu")
                            Service service);

    @POST
    @Path("/archive/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Archiwizacja serwisu")
    GeneralResponse archiveService(@Parameter(description = "Identyfikator serwisu")
                                 @PathParam("id") long id);

    @POST
    @Path("/un-archive/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Odarchiwizowanie serwisu")
    GeneralResponse unarchiveService(@Parameter(description = "Identyfikator serwisu")
                                   @PathParam("id") long id);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Service> getAllServices();
}
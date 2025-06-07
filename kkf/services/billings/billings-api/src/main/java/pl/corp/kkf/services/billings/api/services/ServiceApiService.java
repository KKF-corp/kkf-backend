package pl.corp.kkf.services.billings.api.services;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.services.billings.api.services.dto.Service;

import java.util.List;

@Path("/billings/services")
@Tag(name = "ServiceApiService", description = "Usługa obsługi danych usługi")
public interface ServiceApiService {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Pobranie usługi")
    Service getService(@Parameter(description = "Identyfikator usługi")
                         @PathParam("id") long id);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Utworzenie usługi")
    Service createService(@Parameter(description = "Obiekt usługi")
                            Service service);

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Modyfikacja usługi")
    Service updateService(@Parameter(description = "Obiekt usługi")
                            Service service);

    @POST
    @Path("/archive/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Archiwizacja usługi")
    GeneralResponse archiveService(@Parameter(description = "Identyfikator usługi")
                                 @PathParam("id") long id);

    @POST
    @Path("/un-archive/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Odarchiwizowanie usługi")
    GeneralResponse unarchiveService(@Parameter(description = "Identyfikator usługi")
                                   @PathParam("id") long id);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Service> getAllServices();
}
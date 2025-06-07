package pl.corp.kkf.kkf.services.api.revenues;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.revenues.dto.Revenue;

import java.util.List;

@Path("/billings/revenues")
@Tag(name = "RevenueApiService", description = "Usługa obsługi danych przychodów")
public interface RevenueApiService {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Pobranie przychodu")
    Revenue getRevenue(@Parameter(description = "Identyfikator przychodu")
                       @PathParam("id") long id);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Utworzenie przychodu")
    Revenue createRevenue(@Parameter(description = "Obiekt przychodu")
                          Revenue revenue);

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Modyfikacja przychodu")
    Revenue updateRevenue(@Parameter(description = "Obiekt przychodu")
                          Revenue revenue);

    @POST
    @Path("/archive/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Archiwizacja przychodu")
    GeneralResponse archiveRevenue(@Parameter(description = "Identyfikator przychodu")
                                   @PathParam("id") long id);

    @POST
    @Path("/un-archive/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Odarchiwizowanie przychodu")
    GeneralResponse unarchiveRevenue(@Parameter(description = "Identyfikator przychodu")
                                     @PathParam("id") long id);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Revenue> getAllRevenues();

    @POST
    @Path("/pages")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    RevenueSearchResponse findByCriteria(@Parameter(description = "Zapytanie wyszukiwania przychodów") RevenueSearchRequest request);
}
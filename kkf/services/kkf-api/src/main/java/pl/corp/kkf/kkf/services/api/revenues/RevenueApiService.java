package pl.corp.kkf.kkf.services.api.revenues;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.revenues.dto.Revenue;
import pl.corp.kkf.kkf.services.api.revenues.dto.RevenueSearchRequest;
import pl.corp.kkf.kkf.services.api.revenues.dto.RevenueSearchResponse;

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
                          @Valid Revenue revenue);

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Modyfikacja przychodu")
    Revenue updateRevenue(@Parameter(description = "Obiekt przychodu")
                          @Valid Revenue revenue);

    @POST
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Usunięcie przychodu")
    GeneralResponse deleteRevenue(@Parameter(description = "Identyfikator przychodu")
                                  @PathParam("id") long id);

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    List<Revenue> getAllRevenues();

    @POST
    @Path("/pages")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    RevenueSearchResponse findByCriteria(@Parameter(description = "Zapytanie wyszukiwania przychodów")
                                         @Valid RevenueSearchRequest request);
}
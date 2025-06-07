package pl.corp.kkf.services.dictionaries.api.contractors;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.services.dictionaries.api.contractors.dto.*;

import java.util.List;

@Path("/dictionaries/contractors")
@Tag(name = "ContractorApiService", description = "Usługa obsługi danych słownikowych kontrahenta")
public interface ContractorApiService {


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Pobranie kontrahenta")
    ContractorResponse getContractor(@Parameter(description = "Identyfikator kontrahenta")
                             @PathParam("id") long id);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Utworzenie kontrahenta")
    ContractorResponse createContractor(@Parameter(description = "Obiekt kontrahenta")
                                Contractor contractor);

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Modyfikacja kontrahenta")
    ContractorResponse updateContractor(@Parameter(description = "Obiekt kontrahenta")
                                Contractor contractor);

    @POST
    @Path("/archive/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Archiwizacja kontrahenta")
    GeneralResponse archiveContractor(@Parameter(description = "Identyfikator kontrahenta")
                                 @PathParam("id") long id);

    @POST
    @Path("/un-archive/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Odarchiwizowanie kontrahenta")
    GeneralResponse unarchiveContractor(@Parameter(description = "Identyfikator kontrahenta")
                                   @PathParam("id") long id);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    ContractorListResponse getAllContractors();

    @POST
    @Path("/pages")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Wyszukiwanie kontrahentów według kryteriów")
    ContractorSearchResponse findByCriteria(@Parameter(description = "Zapytanie wyszukiwania kontrahentów")
                                            ContractorSearchRequest request);
}

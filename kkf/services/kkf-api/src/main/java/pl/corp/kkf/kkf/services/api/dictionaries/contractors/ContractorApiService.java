package pl.corp.kkf.kkf.services.api.dictionaries.contractors;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.Contractor;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.ContractorSearchRequest;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.ContractorSearchResponse;

import java.util.List;

@Path("/dictionaries/contractors")
@Tag(name = "ContractorApiService", description = "Usługa obsługi danych słownikowych kontrahenta")
public interface ContractorApiService {


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Pobranie kontrahenta")
    Contractor getContractor(@Parameter(description = "Identyfikator kontrahenta")
                             @PathParam("id") long id);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Utworzenie kontrahenta")
    Contractor createContractor(@Parameter(description = "Obiekt kontrahenta")
                                @Valid Contractor contractor);

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Modyfikacja kontrahenta")
    Contractor updateContractor(@Parameter(description = "Obiekt kontrahenta")
                                @Valid Contractor contractor);

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
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    List<Contractor> getAllContractors();

    @POST
    @Path("/pages")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Wyszukiwanie kontrahentów według kryteriów")
    ContractorSearchResponse findByCriteria(@Parameter(description = "Zapytanie wyszukiwania kontrahentów")
                                            @Valid ContractorSearchRequest request);
}

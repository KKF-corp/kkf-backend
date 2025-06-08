package pl.corp.kkf.kkf.services.api.dictionaries.transactionservicetypes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservicetypes.dto.TransactionServiceType;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservicetypes.dto.TransactionServiceTypeSearchRequest;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservicetypes.dto.TransactionServiceTypeSearchResponse;

import java.util.List;

@Path("/dictionaries/transaction-service-types")
@Tag(name = "TransactionServiceTypeApiService", description = "Usługa obsługi danych słownikowych typu usługa")
public interface TransactionServiceTypeApiService {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Pobranie typu usługa")
    TransactionServiceType getTransactionServiceType(@Parameter(description = "Identyfikator typu usługa")
                                                     @PathParam("id") long id);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Utworzenie typu usługa")
    TransactionServiceType createTransactionServiceType(@Parameter(description = "Obiekt typu usługa")
                                                        @Valid TransactionServiceType transactionServiceType);

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Modyfikacja typu usługa")
    TransactionServiceType updateTransactionServiceType(@Parameter(description = "Obiekt typu usługa")
                                                        @Valid TransactionServiceType transactionServiceType);

    @POST
    @Path("/archive/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Archiwizacja typu usługa")
    GeneralResponse archiveTransactionServiceType(@Parameter(description = "Identyfikator typu usługa")
                                                  @PathParam("id") long id);

    @POST
    @Path("/un-archive/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Odarchiwizowanie typu usługa")
    GeneralResponse unarchiveTransactionServiceType(@Parameter(description = "Identyfikator typu usługa")
                                                    @PathParam("id") long id);

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    List<TransactionServiceType> getAllTransactionServiceTypes();

    @POST
    @Path("/pages")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    TransactionServiceTypeSearchResponse findByCriteria(@Parameter(description = "Zapytanie wyszukiwania typu usługa")
                                                        @Valid TransactionServiceTypeSearchRequest request);
}
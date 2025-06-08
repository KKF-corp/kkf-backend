package pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.dto.TransactionType;
import pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.dto.TransactionTypeSearchRequest;
import pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.dto.TransactionTypeSearchResponse;

import java.util.List;

@Path("/dictionaries/transaction-types")
@Tag(name = "TransactionTypeApiService", description = "Usługa obsługi danych słownikowych typu transakcji")
public interface TransactionTypeApiService {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Pobranie typu transakcji")
    TransactionType getTransactionType(@Parameter(description = "Identyfikator typu transakcji")
                                       @PathParam("id") long id);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Utworzenie typu transakcji")
    TransactionType createTransactionType(@Parameter(description = "Obiekt typu transakcji")
                                          @Valid TransactionType transactionType);

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Modyfikacja typu transakcji")
    TransactionType updateTransactionType(@Parameter(description = "Obiekt typu transakcji")
                                          @Valid TransactionType transactionType);

    @POST
    @Path("/archive/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Archiwizacja typu transakcji")
    GeneralResponse archiveTransactionType(@Parameter(description = "Identyfikator typu transakcji")
                                           @PathParam("id") long id);

    @POST
    @Path("/un-archive/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Odarchiwizowanie typu transakcji")
    GeneralResponse unarchiveTransactionType(@Parameter(description = "Identyfikator typu transakcji")
                                             @PathParam("id") long id);

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Wyszukiwanie wszystkich typów transakcji")
    List<TransactionType> getAllTransactionTypes();

    @POST
    @Path("/pages")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    TransactionTypeSearchResponse findByCriteria(@Parameter(description = "Zapytanie wyszukiwania typu transakcji")
                                                 @Valid TransactionTypeSearchRequest request);
}
package pl.corp.kkf.kkf.services.api.dictionaries.transactionservices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservices.dto.TransactionServiceDto;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservices.dto.TransactionServiceSearchRequest;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;

import java.util.List;

@Path("/dictionaries/transaction-services")
@Tag(name = "TransactionServiceApiService", description = "Usługa obsługi danych słownikowych usługi")
public interface TransactionServiceApiService {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Pobranie usługi")
    TransactionServiceDto getTransactionService(@Parameter(description = "Identyfikator usługi")
                                                @PathParam("id") long id);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Utworzenie usługi")
    TransactionServiceDto createTransactionService(@Parameter(description = "Obiekt usługi")
                                                   TransactionServiceDto transactionService);

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Modyfikacja usługi")
    TransactionServiceDto updateTransactionService(@Parameter(description = "Obiekt usługi")
                                                   TransactionServiceDto transactionService);

    @POST
    @Path("/archive/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Archiwizacja usługi")
    GeneralResponse archiveTransactionService(@Parameter(description = "Identyfikator usługi")
                                              @PathParam("id") long id);

    @POST
    @Path("/un-archive/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Odarchiwizowanie usługi")
    GeneralResponse unarchiveTransactionService(@Parameter(description = "Identyfikator usługi")
                                                @PathParam("id") long id);

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    List<TransactionServiceDto> getAllTransactionServices();

    @POST
    @Path("/pages")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    TransactionServiceSearchResponse findByCriteria(@Parameter(description = "Zapytanie wyszukiwania usługi") TransactionServiceSearchRequest request);

}
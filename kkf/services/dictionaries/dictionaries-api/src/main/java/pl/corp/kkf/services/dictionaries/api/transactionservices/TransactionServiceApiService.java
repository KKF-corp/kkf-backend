package pl.corp.kkf.services.dictionaries.api.transactionservices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.services.dictionaries.api.transactionservices.dto.TransactionServiceDto;

import java.util.List;

@Path("/dictionaries/transaction-services")
@Tag(name = "TransactionServiceApiService", description = "Usługa obsługi danych słownikowych serwisu")
public interface TransactionServiceApiService {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Pobranie serwisu")
    TransactionServiceDto getTransactionService(@Parameter(description = "Identyfikator serwisu")
                                                @PathParam("id") long id);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Utworzenie serwisu")
    TransactionServiceDto createTransactionService(@Parameter(description = "Obiekt serwisu")
                                                   TransactionServiceDto transactionService);

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Modyfikacja serwisu")
    TransactionServiceDto updateTransactionService(@Parameter(description = "Obiekt serwisu")
                                                   TransactionServiceDto transactionService);

    @POST
    @Path("/archive/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Archiwizacja serwisu")
    GeneralResponse archiveTransactionService(@Parameter(description = "Identyfikator serwisu")
                                              @PathParam("id") long id);

    @POST
    @Path("/un-archive/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Odarchiwizowanie serwisu")
    GeneralResponse unarchiveTransactionService(@Parameter(description = "Identyfikator serwisu")
                                                @PathParam("id") long id);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<TransactionServiceDto> getAllTransactionServices();
}
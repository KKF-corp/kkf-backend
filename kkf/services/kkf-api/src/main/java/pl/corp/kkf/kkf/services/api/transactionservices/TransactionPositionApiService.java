package pl.corp.kkf.kkf.services.api.transactionservices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.transactionservices.dto.TransactionPosition;

import java.util.List;

@Path("/billings/transaction-services")
@Tag(name = "TransactionServiceApiService", description = "Usługa obsługi danych usługi")
public interface TransactionPositionApiService {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Pobranie usługi")
    TransactionPosition getTransactionService(@Parameter(description = "Identyfikator usługi")
                                                @PathParam("id") long id);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Utworzenie usługi")
    TransactionPosition createTransactionService(@Parameter(description = "Obiekt usługi")
                                                   @Valid TransactionPosition transactionPosition);

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Modyfikacja usługi")
    TransactionPosition updateTransactionService(@Parameter(description = "Obiekt usługi")
                                                   @Valid TransactionPosition transactionPosition);

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
    List<TransactionPosition> getAllTransactionServices();
}
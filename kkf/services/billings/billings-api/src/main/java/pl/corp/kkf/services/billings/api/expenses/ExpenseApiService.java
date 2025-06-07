package pl.corp.kkf.services.billings.api.expenses;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.services.billings.api.expenses.dto.Expense;

import java.util.List;

@Path("/billings/expenses")
@Tag(name = "ExpenseApiService", description = "Usługa obsługi danych wydatków")
public interface ExpenseApiService {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Pobranie wydatku")
    Expense getExpense(@Parameter(description = "Identyfikator wydatku")
                         @PathParam("id") long id);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Utworzenie wydatku")
    Expense createExpense(@Parameter(description = "Obiekt wydatku")
                            Expense expense);

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Modyfikacja wydatku")
    Expense updateExpense(@Parameter(description = "Obiekt wydatku")
                            Expense expense);

    @POST
    @Path("/archive/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Archiwizacja wydatku")
    GeneralResponse archiveExpense(@Parameter(description = "Identyfikator wydatku")
                                 @PathParam("id") long id);

    @POST
    @Path("/un-archive/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Odarchiwizowanie wydatku")
    GeneralResponse unarchiveExpense(@Parameter(description = "Identyfikator wydatku")
                                   @PathParam("id") long id);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Expense> getAllExpenses();
}
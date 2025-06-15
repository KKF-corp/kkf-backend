package pl.corp.kkf.kkf.services.api.expenses;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.expenses.dto.Expense;
import pl.corp.kkf.kkf.services.api.expenses.dto.ExpenseSearchRequest;
import pl.corp.kkf.kkf.services.api.expenses.dto.ExpenseSearchResponse;

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
                          @Valid Expense expense);

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "Modyfikacja wydatku")
    Expense updateExpense(@Parameter(description = "Obiekt wydatku")
                          @Valid Expense expense);

    @POST
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Usunięcie wydatku")
    GeneralResponse archiveExpense(@Parameter(description = "Identyfikator wydatku")
                                   @PathParam("id") long id);

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    List<Expense> getAllExpenses();

    @POST
    @Path("/pages")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    ExpenseSearchResponse findByCriteria(@Parameter(description = "Zapytanie wyszukiwania wydatków")
                                         @Valid ExpenseSearchRequest request);
}
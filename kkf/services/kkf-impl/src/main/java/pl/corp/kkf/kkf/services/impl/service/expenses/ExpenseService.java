package pl.corp.kkf.kkf.services.impl.service.expenses;

import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.kkf.services.api.expenses.dto.Expense;
import pl.corp.kkf.kkf.services.api.expenses.dto.ExpenseSearchRequest;

import java.util.List;

public interface ExpenseService {

    Expense getExpense(long id);

    Expense createExpense(Expense expense);

    Expense updateExpense(Expense expense);

    void deleteExpense(long id);

    List<Expense> getAllExpenses();

    PageDTO<Expense> findByCriteria(ExpenseSearchRequest searchRequest);
}
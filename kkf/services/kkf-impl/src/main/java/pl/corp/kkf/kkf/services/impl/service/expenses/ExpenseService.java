package pl.corp.kkf.kkf.services.impl.service.expenses;

import pl.corp.kkf.kkf.services.api.expenses.dto.Expense;

import java.util.List;

public interface ExpenseService {

    Expense getExpense(long id);

    Expense createExpense(Expense expense);

    Expense updateExpense(Expense expense);

    void archiveExpense(long id);

    void unarchiveExpense(long id);

    List<Expense> getAllExpenses();
}
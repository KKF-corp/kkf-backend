package pl.corp.kkf.services.billings.impl.service.expenses;

import pl.corp.kkf.services.billings.api.expenses.dto.Expense;

import java.util.List;

public interface ExpenseService {

    Expense getExpense(Long id);

    Expense createExpense(Expense expense);

    Expense updateExpense(Expense expense);

    void archiveExpense(Long id);

    void unarchiveExpense(Long id);

    List<Expense> getAllExpenses();
}
package pl.corp.kkf.kkf.services.impl.service.expenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.expenses.ExpenseApiService;
import pl.corp.kkf.kkf.services.api.expenses.dto.Expense;

import java.util.List;

@Service
public class ExpenseApiServiceImpl implements ExpenseApiService {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseApiServiceImpl(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @Override
    public Expense getExpense(long id) {
        return expenseService.getExpense(id);
    }

    @Override
    public Expense createExpense(Expense expense) {
        return expenseService.createExpense(expense);
    }

    @Override
    public Expense updateExpense(Expense expense) {
        return expenseService.updateExpense(expense);
    }

    @Override
    public GeneralResponse archiveExpense(long id) {
        expenseService.archiveExpense(id);
        return new GeneralResponse();
    }

    @Override
    public GeneralResponse unarchiveExpense(long id) {
        expenseService.unarchiveExpense(id);
        return new GeneralResponse();
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }
}
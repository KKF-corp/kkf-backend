package pl.corp.kkf.services.billings.impl.service.expenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.services.billings.api.expenses.ExpenseApiService;
import pl.corp.kkf.services.billings.api.expenses.dto.Expense;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;

import java.util.List;

@Service
public class ExpenseApiServiceImpl implements ExpenseApiService {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseApiServiceImpl(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @Override
    public Expense getExpense(Long id) {
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
    public GeneralResponse archiveExpense(Long id) {
        expenseService.archiveExpense(id);
        return new GeneralResponse();
    }

    @Override
    public GeneralResponse unarchiveExpense(Long id) {
        expenseService.unarchiveExpense(id);
        return new GeneralResponse();
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }
}
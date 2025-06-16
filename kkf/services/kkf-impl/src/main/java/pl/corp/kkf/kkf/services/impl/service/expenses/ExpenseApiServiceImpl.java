package pl.corp.kkf.kkf.services.impl.service.expenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.expenses.ExpenseApiService;
import pl.corp.kkf.kkf.services.api.expenses.dto.Expense;
import pl.corp.kkf.kkf.services.api.expenses.dto.ExpenseSearchRequest;
import pl.corp.kkf.kkf.services.api.expenses.dto.ExpenseSearchResponse;
import pl.corp.kkf.kkf.services.impl.KKFModuleConstants;
import pl.corp.kkf.kkf.services.impl.dao.converters.ExpenseConverter;
import pl.corp.kkf.kkf.services.impl.dao.exceptions.dictionaries.ContractorException;

import java.util.List;

@Service
public class ExpenseApiServiceImpl implements ExpenseApiService {

    @Autowired
    private ExpenseService expenseService;

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER, readOnly = true)
    public Expense getExpense(long id) {
        return expenseService.getExpense(id);
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER)
    public Expense createExpense(Expense expense) {
        return expenseService.createExpense(expense);
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER)
    public Expense updateExpense(Expense expense) {
        return expenseService.updateExpense(expense);
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER)
    public GeneralResponse archiveExpense(long id) {
        expenseService.deleteExpense(id);
        return new GeneralResponse(true);
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER, readOnly = true)
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER, readOnly = true)
    public ExpenseSearchResponse findByCriteria(ExpenseSearchRequest request) {
        try {
            PageDTO<Expense> byCriteria = expenseService.findByCriteria(request);
            return ExpenseConverter.convertToSearchResponse(byCriteria);
        } catch (ContractorException e) {
            throw new ContractorException("");
        }
    }
}
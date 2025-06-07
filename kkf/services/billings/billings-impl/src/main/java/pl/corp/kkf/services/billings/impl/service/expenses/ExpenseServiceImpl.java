package pl.corp.kkf.services.billings.impl.service.expenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.services.billings.api.expenses.dto.Expense;
import pl.corp.kkf.services.billings.impl.dao.converters.ExpenseConverter;
import pl.corp.kkf.services.billings.impl.dao.repositories.ExpenseRepository;
import pl.corp.kkf.services.billings.model.expenses.ExpenseEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Expense getExpense(Long id) {
        ExpenseEntity expenseEntity = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));
        return ExpenseConverter.toDto(expenseEntity);
    }

    @Override
    public Expense createExpense(Expense expense) {
        ExpenseEntity expenseEntity = ExpenseConverter.toEntity(expense);
        ExpenseEntity savedExpenseEntity = expenseRepository.save(expenseEntity);
        return ExpenseConverter.toDto(savedExpenseEntity);
    }

    @Override
    public Expense updateExpense(Expense expense) {
        ExpenseEntity expenseEntity = ExpenseConverter.toEntity(expense);
        ExpenseEntity updatedExpenseEntity = expenseRepository.save(expenseEntity);
        return ExpenseConverter.toDto(updatedExpenseEntity);
    }

    @Override
    public void archiveExpense(Long id) {
        ExpenseEntity expenseEntity = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));
        expenseEntity.setDeleted(true);
        expenseRepository.save(expenseEntity);
    }

    @Override
    public void unarchiveExpense(Long id) {
        ExpenseEntity expenseEntity = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));
        expenseEntity.setDeleted(false);
        expenseRepository.save(expenseEntity);
    }

    @Override
    public List<Expense> getAllExpenses() {
        List<ExpenseEntity> expenseEntities = expenseRepository.findAll();
        return expenseEntities.stream()
                .map(ExpenseConverter::toDto)
                .collect(Collectors.toList());
    }
}
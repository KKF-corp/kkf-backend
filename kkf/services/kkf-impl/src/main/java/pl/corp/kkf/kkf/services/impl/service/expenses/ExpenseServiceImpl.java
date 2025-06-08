package pl.corp.kkf.kkf.services.impl.service.expenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.expenses.dto.Expense;
import pl.corp.kkf.kkf.services.api.expenses.dto.ExpenseSearchRequest;
import pl.corp.kkf.kkf.services.impl.dao.repositories.ExpenseRepository;
import pl.corp.kkf.kkf.services.impl.dao.converters.ExpenseConverter;
import pl.corp.kkf.commons.base.service.PageUtils;
import pl.corp.kkf.kkf.services.model.ExpenseEntity;
import org.springframework.data.jpa.domain.Specification;
import pl.corp.kkf.kkf.services.api.expenses.dto.ExpenseCriteria;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Expense getExpense(long id) {
        ExpenseEntity expenseEntity = expenseRepository.findById(id)
                .orElseThrow(EXPENSE_NOT_FOUND_EXCEPTION_SUPPLIER);
        return toDto(expenseEntity);
    }

    @Override
    public Expense createExpense(Expense expense) {
        // TODO: walidacja
        ExpenseEntity expenseEntity = ExpenseConverter.toEntity(new ExpenseEntity(), expense);
        return toDto(expenseRepository.save(expenseEntity));
    }

    @Override
    public Expense updateExpense(Expense expense) {
        // TODO: walidacja
        ExpenseEntity entity = expenseRepository.findById(expense.getId())
                .orElseThrow(EXPENSE_NOT_FOUND_EXCEPTION_SUPPLIER);
        return toDto(expenseRepository.save(ExpenseConverter.toEntity(entity, expense)));
    }

    @Override
    public void archiveExpense(long id) {
        // TODO: walidacja
        ExpenseEntity entity = expenseRepository.findById(id)
                .orElseThrow(EXPENSE_NOT_FOUND_EXCEPTION_SUPPLIER);
        entity.setDeleted(true);
        expenseRepository.save(entity);
    }

    @Override
    public void unarchiveExpense(long id) {
        // TODO: walidacja
        ExpenseEntity entity = expenseRepository.findById(id)
                .orElseThrow(EXPENSE_NOT_FOUND_EXCEPTION_SUPPLIER);
        entity.setDeleted(false);
        expenseRepository.save(entity);
    }

    @Override
    public List<Expense> getAllExpenses() {
        List<ExpenseEntity> expenseEntities = expenseRepository.findAll();
        return expenseEntities.stream()
                .map(ExpenseConverter::toDto)
                .collect(Collectors.toList());
    }

     @Override
    public PageDTO<Expense> findByCriteria(ExpenseSearchRequest request) {
        Pageable pageable = PageUtils.convertTo(request.getPageRequestDTO());
        Specification<ExpenseEntity> specification = expenseRepository.getSpecification(request.getCriteria());
        Page<ExpenseEntity> expenseEntities = expenseRepository.findAll(specification, pageable);
        PageDTO<Expense> pageDTO = PageUtils.convertTo(expenseEntities.map(ExpenseConverter::toDto));
        return pageDTO;
    }
}
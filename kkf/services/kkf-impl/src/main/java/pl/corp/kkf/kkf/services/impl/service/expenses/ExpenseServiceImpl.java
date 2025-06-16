package pl.corp.kkf.kkf.services.impl.service.expenses;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.corp.kkf.commons.base.service.rest.PageUtils;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.kkf.services.api.expenses.dto.Expense;
import pl.corp.kkf.kkf.services.api.expenses.dto.ExpenseSearchRequest;
import pl.corp.kkf.kkf.services.impl.dao.converters.ExpenseConverter;
import pl.corp.kkf.kkf.services.impl.dao.exceptions.ExpenseException;
import pl.corp.kkf.kkf.services.impl.dao.repositories.ExpenseRepository;
import pl.corp.kkf.kkf.services.impl.dao.validators.ExpenseValidator;
import pl.corp.kkf.kkf.services.impl.service.dictionaries.contractors.ContractorService;
import pl.corp.kkf.kkf.services.impl.service.dictionaries.transactiontypes.TransactionTypeService;
import pl.corp.kkf.kkf.services.model.ExpenseEntity;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static pl.corp.kkf.kkf.services.impl.dao.converters.ExpenseConverter.toDto;
import static pl.corp.kkf.kkf.services.impl.dao.converters.ExpenseConverter.toEntity;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    public static final Supplier<@NotNull ExpenseException> EXPENSE_NOT_FOUND_EXCEPTION_SUPPLIER = () -> new ExpenseException("Nie znaleziono rozchodu o podanym identyfikatorze");

    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private ContractorService contractorService;
    @Autowired
    private TransactionTypeService transactionTypeService;

    @Override
    public Expense getExpense(long id) {
        ExpenseEntity expenseEntity = expenseRepository.findById(id)
                .orElseThrow(EXPENSE_NOT_FOUND_EXCEPTION_SUPPLIER);
        return toDto(expenseEntity);
    }

    @Override
    public Expense createExpense(Expense expense) {
        validateForCreation(expense);
        return toDto(expenseRepository.save(toEntity(new ExpenseEntity(), expense)));
    }

    @Override
    public Expense updateExpense(Expense expense) {
        validateForUpdate(expense);
        ExpenseEntity entity = expenseRepository.findById(expense.getId())
                .orElseThrow(EXPENSE_NOT_FOUND_EXCEPTION_SUPPLIER);
        return toDto(expenseRepository.save(toEntity(entity, expense)));
    }

    @Override
    public void deleteExpense(long id) {
        ExpenseEntity entity = expenseRepository.findById(id)
                .orElseThrow(EXPENSE_NOT_FOUND_EXCEPTION_SUPPLIER);
        ExpenseValidator.validateForDelete(entity.getDeleted());
        entity.setDeleted(true);
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
        return PageUtils.convertTo(expenseEntities.map(ExpenseConverter::toDto));
    }

    private void validateForCreation(Expense expense) {
        ExpenseValidator.validateForCreation(expense, contractorService, transactionTypeService);
    }

    private void validateForUpdate(Expense expense) {
        ExpenseValidator.validateForUpdate(expense, contractorService, transactionTypeService);
    }
}
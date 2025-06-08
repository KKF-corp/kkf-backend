package pl.corp.kkf.kkf.services.impl.dao.validators;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.util.CollectionUtils;
import pl.corp.kkf.commons.base.service.validate.BaseValidator;
import pl.corp.kkf.kkf.services.api.expenses.dto.Expense;
import pl.corp.kkf.kkf.services.impl.dao.exceptions.ExpenseException;
import pl.corp.kkf.kkf.services.impl.service.dictionaries.contractors.ContractorService;
import pl.corp.kkf.kkf.services.impl.service.dictionaries.transactiontypes.TransactionTypeService;

import java.util.Objects;

public class ExpenseValidator implements BaseValidator {

    @Override
    public RuntimeException createException(String message) {
        return new ExpenseException(message);
    }

    public void validateForCreation(@Valid @NotNull Expense dto,
                                    final TransactionServiceValidator transactionServiceValidator,
                                    final ContractorService contractorService,
                                    final TransactionTypeService transactionTypeService) {
        check(Objects.nonNull(dto.getId()), "Znaleziono identyfikator podczas tworzenia!");
        check(ObjectUtils.allNotNull(dto.getContractor(), dto.getContractor().getId())
                && !contractorService.existsById(dto.getContractor().getId()), "Nie znaleziono kontrahenta o podanym identyfikatorze!");
        check(Objects.isNull(dto.getTransactionType().getId()), "Nie znaleziono identyfikatora rodzaju transakcji");
        check(Objects.isNull(dto.getTransactionType().getId())
                && !transactionTypeService.existsById(dto.getTransactionType().getId()), "Nie znaleziono rodzaju rozchodu o podanym identyfikatorze!");
        check(CollectionUtils.isEmpty(dto.getExpenseServiceDtos()), "Brak pozycji rozchodu!");

        dto.getExpenseServiceDtos().forEach(transactionServiceValidator::validateForCreation);
    }

    public void validateForUpdate(@NotNull Expense dto,
                                  final TransactionServiceValidator transactionServiceValidator,
                                  final ContractorService contractorService,
                                  final TransactionTypeService transactionTypeService) {
        check(Objects.isNull(dto.getId()), "Nie znaleziono identyfikatora podczas modyfikacji!");
        check(ObjectUtils.allNotNull(dto.getContractor(), dto.getContractor().getId())
                && !contractorService.existsById(dto.getContractor().getId()), "Nie znaleziono kontrahenta o podanym identyfikatorze!");
        check(Objects.isNull(dto.getTransactionType().getId()), "Nie znaleziono identyfikatora rodzaju transakcji");
        check(Objects.isNull(dto.getTransactionType().getId())
                && !transactionTypeService.existsById(dto.getTransactionType().getId()), "Nie znaleziono rodzaju rozchodu o podanym identyfikatorze!");
        check(CollectionUtils.isEmpty(dto.getExpenseServiceDtos()), "Brak pozycji rozchodu!");

        dto.getExpenseServiceDtos().forEach(transactionServiceValidator::validateForCreation);
    }

    public void validateForDelete(boolean isDeleted) {
        check(isDeleted, "Rozchód został już usunięty!");
    }
}

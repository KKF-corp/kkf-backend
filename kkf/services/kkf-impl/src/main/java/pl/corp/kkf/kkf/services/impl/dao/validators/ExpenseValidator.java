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
import java.util.function.Supplier;

import static pl.corp.kkf.commons.base.service.validate.BaseValidator.check;

public class ExpenseValidator implements BaseValidator {

    public static void validateForCreation(@Valid @NotNull Expense dto,
                                           final ContractorService contractorService,
                                           final TransactionTypeService transactionTypeService) {
        check(Objects.nonNull(dto.getId()), ex("Znaleziono identyfikator podczas tworzenia!"));
        check(ObjectUtils.allNotNull(dto.getContractor(), dto.getContractor().getId())
                && !contractorService.existsById(dto.getContractor().getId()), ex("Nie znaleziono kontrahenta o podanym identyfikatorze!"));
        check(Objects.isNull(dto.getTransactionType().getId()), ex("Nie znaleziono identyfikatora rodzaju transakcji"));
        check(Objects.isNull(dto.getTransactionType().getId())
                && !transactionTypeService.existsById(dto.getTransactionType().getId()), ex("Nie znaleziono rodzaju rozchodu o podanym identyfikatorze!"));
        check(CollectionUtils.isEmpty(dto.getExpenseServiceDtos()), ex("Brak pozycji rozchodu!"));

        dto.getExpenseServiceDtos().forEach(TransactionPositionValidator::validateForCreation);
    }

    public static void validateForUpdate(@NotNull Expense dto,
                                         final ContractorService contractorService,
                                         final TransactionTypeService transactionTypeService) {
        check(Objects.isNull(dto.getId()), ex("Nie znaleziono identyfikatora podczas modyfikacji!"));
        check(ObjectUtils.allNotNull(dto.getContractor(), dto.getContractor().getId())
                && !contractorService.existsById(dto.getContractor().getId()), ex("Nie znaleziono kontrahenta o podanym identyfikatorze!"));
        check(Objects.isNull(dto.getTransactionType().getId()), ex("Nie znaleziono identyfikatora rodzaju transakcji"));
        check(Objects.isNull(dto.getTransactionType().getId())
                && !transactionTypeService.existsById(dto.getTransactionType().getId()), ex("Nie znaleziono rodzaju rozchodu o podanym identyfikatorze!"));
        check(CollectionUtils.isEmpty(dto.getExpenseServiceDtos()), ex("Brak pozycji rozchodu!"));

        dto.getExpenseServiceDtos().forEach(TransactionPositionValidator::validateForCreation);
    }

    public static void validateForDelete(boolean isDeleted) {
        check(isDeleted, ex("Rozchód został już usunięty!"));
    }

    private static Supplier<ExpenseException> ex(String message) {
        return () -> new ExpenseException(message);
    }
}

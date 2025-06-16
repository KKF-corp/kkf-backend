package pl.corp.kkf.kkf.services.impl.dao.validators;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.util.CollectionUtils;
import pl.corp.kkf.commons.base.service.validate.BaseValidator;
import pl.corp.kkf.kkf.services.api.revenues.dto.Revenue;
import pl.corp.kkf.kkf.services.impl.dao.exceptions.RevenueException;
import pl.corp.kkf.kkf.services.impl.service.dictionaries.contractors.ContractorService;
import pl.corp.kkf.kkf.services.impl.service.dictionaries.transactiontypes.TransactionTypeService;

import java.util.Objects;
import java.util.function.Supplier;

import static pl.corp.kkf.commons.base.service.validate.BaseValidator.check;

public class RevenueValidator implements BaseValidator {


    public static void validateForCreation(@Valid @NotNull Revenue revenue,
                                           final ContractorService contractorService,
                                           final TransactionTypeService transactionTypeService) {
        check(Objects.nonNull(revenue.getId()), ex("Znaleziono identyfikator podczas tworzenia!"));
        check(ObjectUtils.allNotNull(revenue.getContractor(), revenue.getContractor().getId())
                && !contractorService.existsById(revenue.getContractor().getId()), ex("Nie znaleziono kontrahenta o podanym identyfikatorze!"));
        check(Objects.isNull(revenue.getTransactionType().getId()), ex("Nie znaleziono identyfikatora rodzaju transakcji"));
        check(Objects.isNull(revenue.getTransactionType().getId())
                && !transactionTypeService.existsById(revenue.getTransactionType().getId()), ex("Nie znaleziono rodzaju przychodu o podanym identyfikatorze!"));
        check(CollectionUtils.isEmpty(revenue.getRevenueServiceDtos()), ex("Brak pozycji przychodu!"));

        revenue.getRevenueServiceDtos().forEach(TransactionPositionValidator::validateForCreation);
    }

    public static void validateForUpdate(@NotNull Revenue revenue,
                                         final ContractorService contractorService,
                                         final TransactionTypeService transactionTypeService) {
        check(Objects.isNull(revenue.getId()), ex("Nie znaleziono identyfikatora podczas modyfikacji!"));
        check(ObjectUtils.allNotNull(revenue.getContractor(), revenue.getContractor().getId())
                && !contractorService.existsById(revenue.getContractor().getId()), ex("Nie znaleziono kontrahenta o podanym identyfikatorze!"));
        check(Objects.isNull(revenue.getTransactionType().getId()), ex("Nie znaleziono identyfikatora rodzaju transakcji"));
        check(Objects.isNull(revenue.getTransactionType().getId())
                && !transactionTypeService.existsById(revenue.getTransactionType().getId()), ex("Nie znaleziono rodzaju przychodu o podanym identyfikatorze!"));
        check(CollectionUtils.isEmpty(revenue.getRevenueServiceDtos()), ex("Brak pozycji przychodu!"));

        revenue.getRevenueServiceDtos().forEach(TransactionPositionValidator::validateForCreation);
    }

    public static void validateForDelete(boolean isDeleted) {
        check(isDeleted, ex("Przychód został już usunięty!"));
    }

    private static Supplier<RevenueException> ex(String message) {
        return () -> new RevenueException(message);
    }
}

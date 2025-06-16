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

public class RevenueValidator implements BaseValidator {

    @Override
    public RuntimeException createException(String message) {
        return new RevenueException(message);
    }

    public void validateForCreation(@Valid @NotNull Revenue revenue,
                                    final TransactionPositionValidator transactionPositionValidator,
                                    final ContractorService contractorService,
                                    final TransactionTypeService transactionTypeService) {
        check(Objects.nonNull(revenue.getId()), "Znaleziono identyfikator podczas tworzenia!");
        check(ObjectUtils.allNotNull(revenue.getContractor(), revenue.getContractor().getId())
                && !contractorService.existsById(revenue.getContractor().getId()), "Nie znaleziono kontrahenta o podanym identyfikatorze!");
        check(Objects.isNull(revenue.getTransactionType().getId()), "Nie znaleziono identyfikatora rodzaju transakcji");
        check(Objects.isNull(revenue.getTransactionType().getId())
                && !transactionTypeService.existsById(revenue.getTransactionType().getId()), "Nie znaleziono rodzaju przychodu o podanym identyfikatorze!");
        check(CollectionUtils.isEmpty(revenue.getRevenueServiceDtos()), "Brak pozycji przychodu!");

        revenue.getRevenueServiceDtos().forEach(transactionPositionValidator::validateForCreation);
    }

    public void validateForUpdate(@NotNull Revenue revenue,
                                  final TransactionPositionValidator transactionPositionValidator,
                                  final ContractorService contractorService,
                                  final TransactionTypeService transactionTypeService) {
        check(Objects.isNull(revenue.getId()), "Nie znaleziono identyfikatora podczas modyfikacji!");
        check(ObjectUtils.allNotNull(revenue.getContractor(), revenue.getContractor().getId())
                && !contractorService.existsById(revenue.getContractor().getId()), "Nie znaleziono kontrahenta o podanym identyfikatorze!");
        check(Objects.isNull(revenue.getTransactionType().getId()), "Nie znaleziono identyfikatora rodzaju transakcji");
        check(Objects.isNull(revenue.getTransactionType().getId())
                && !transactionTypeService.existsById(revenue.getTransactionType().getId()), "Nie znaleziono rodzaju przychodu o podanym identyfikatorze!");
        check(CollectionUtils.isEmpty(revenue.getRevenueServiceDtos()), "Brak pozycji przychodu!");

        revenue.getRevenueServiceDtos().forEach(transactionPositionValidator::validateForCreation);
    }

    public void validateForDelete(boolean isDeleted) {
        check(isDeleted, "Przychód został już usunięty!");
    }
}

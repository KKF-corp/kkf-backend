package pl.corp.kkf.kkf.services.impl.dao.validators;


import jakarta.validation.constraints.NotNull;
import pl.corp.kkf.commons.base.service.validate.BaseValidator;
import pl.corp.kkf.kkf.services.api.transactionservices.dto.TransactionPosition;
import pl.corp.kkf.kkf.services.impl.dao.exceptions.TransactionPositionException;

import java.math.BigDecimal;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class TransactionPositionValidator implements BaseValidator {

    @Override
    public RuntimeException createException(String message) {
        return new TransactionPositionException(message);
    }

    public void validateForCreation(@NotNull TransactionPosition dto) {
        check(nonNull(dto.getId()), "Identyfikator już istnieje podczas tworzenia!");
        validateForCreateOrUpdate(dto);
    }

    public void validateForUpdate(@NotNull TransactionPosition dto) {
        check(isNull(dto.getId()), "Identyfikator nie istnieje podczas modyfikacji!");
        validateForCreateOrUpdate(dto);
    }

    private void validateForCreateOrUpdate(@NotNull TransactionPosition dto) {
        check(isNull(dto.getDiscount()) || isNegative(dto.getDiscount()), "Rabat nie może być ujemny!");
        check(isNull(dto.getNetPrice()) || isNegative(dto.getNetPrice()), "Cena netto nie może być ujemna!");
        check(isNull(dto.getGrossPrice()) || isNegative(dto.getGrossPrice()), "Cena brutto nie może być ujemna!");
        check(isNull(dto.getVat()) || isNegative(dto.getVat()), "VAT nie może być ujemne!");
        check(isNull(dto.getName()) || dto.getName().length() > 255, "Zbyt długa nazwa pozycji przychodu!");
        check(isNull(dto.getUnit()) || dto.getUnit().length() > 10, "Nieprawidłowa jednostka!");
    }

    public void validateForArchivization(boolean isArchival, boolean archivization) {
        check(isArchival && archivization, "Nie można zarchiwizować już archiwalnego obiektu!");
        check(!isArchival && !archivization, "Nie można odarchiwizować aktywnego obiektu!");
    }

    private boolean isNegative(BigDecimal discount) {
        return discount.compareTo(BigDecimal.ZERO) < 0;
    }
}

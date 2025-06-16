package pl.corp.kkf.kkf.services.impl.dao.validators;


import jakarta.validation.constraints.NotNull;
import pl.corp.kkf.commons.base.service.validate.BaseValidator;
import pl.corp.kkf.kkf.services.api.transactionservices.dto.TransactionPosition;
import pl.corp.kkf.kkf.services.impl.dao.exceptions.RevenueException;

import java.math.BigDecimal;
import java.util.function.Supplier;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static pl.corp.kkf.commons.base.service.validate.BaseValidator.check;

public class TransactionPositionValidator implements BaseValidator {


    public static void validateForCreation(@NotNull TransactionPosition dto) {
        check(nonNull(dto.getId()), ex("Identyfikator już istnieje podczas tworzenia!"));
        validateForCreateOrUpdate(dto);
    }

    public static void validateForUpdate(@NotNull TransactionPosition dto) {
        check(isNull(dto.getId()), ex("Identyfikator nie istnieje podczas modyfikacji!"));
        validateForCreateOrUpdate(dto);
    }

    private static void validateForCreateOrUpdate(@NotNull TransactionPosition dto) {
        check(isNull(dto.getDiscount()) || isNegative(dto.getDiscount()), ex("Rabat nie może być ujemny!"));
        check(isNull(dto.getNetPrice()) || isNegative(dto.getNetPrice()), ex("Cena netto nie może być ujemna!"));
        check(isNull(dto.getGrossPrice()) || isNegative(dto.getGrossPrice()), ex("Cena brutto nie może być ujemna!"));
        check(isNull(dto.getVat()) || isNegative(dto.getVat()), ex("VAT nie może być ujemne!"));
        check(isNull(dto.getName()) || dto.getName().length() > 255, ex("Zbyt długa nazwa pozycji przychodu!"));
        check(isNull(dto.getUnit()) || dto.getUnit().length() > 10, ex("Nieprawidłowa jednostka!"));
    }

    public static void validateForArchivization(boolean isArchival, boolean archivization) {
        check(isArchival && archivization, ex("Nie można zarchiwizować już archiwalnego obiektu!"));
        check(!isArchival && !archivization, ex("Nie można odarchiwizować aktywnego obiektu!"));
    }

    private static boolean isNegative(BigDecimal discount) {
        return discount.compareTo(BigDecimal.ZERO) < 0;
    }

    private static Supplier<RevenueException> ex(String message) {
        return () -> new RevenueException(message);
    }
}

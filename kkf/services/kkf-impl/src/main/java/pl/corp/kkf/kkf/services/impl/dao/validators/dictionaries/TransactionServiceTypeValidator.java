package pl.corp.kkf.kkf.services.impl.dao.validators.dictionaries;

import jakarta.validation.constraints.NotNull;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservicetypes.dto.TransactionServiceType;
import pl.corp.kkf.kkf.services.impl.dao.exceptions.dictionaries.TransactionServiceTypeException;

public class TransactionServiceTypeValidator {

    public static void validateForCreation(@NotNull TransactionServiceType transactionServiceType) {
        if (transactionServiceType.getId() != null) {
            throw new TransactionServiceTypeException("Identyfikator już istnieje podczas tworzenia!");
        }
    }

    public static void validateForUpdate(@NotNull TransactionServiceType transactionServiceType) {
        if (transactionServiceType.getId() == null) {
            throw new TransactionServiceTypeException("Identyfikator nie istnieje podczas modyfikacji!");
        }
    }

    public static void validateForArchivization(boolean isArchival, boolean archivization) {
        if (isArchival && archivization) {
            throw new TransactionServiceTypeException("Nie można zarchiwizować już archiwalnego obiektu!");
        } else if (!isArchival && !archivization) {
            throw new TransactionServiceTypeException("Nie można odarchiwizować aktywnego obiektu!");
        }
    }


}

package pl.corp.kkf.kkf.services.impl.dao.validators.dictionaries;

import jakarta.validation.constraints.NotNull;
import pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.dto.TransactionType;
import pl.corp.kkf.kkf.services.impl.dao.exceptions.dictionaries.TransactionTypeException;

public class TransactionTypeValidator {

    public static void validateForCreation(@NotNull TransactionType transactionType) {
        if (transactionType.getId() != null) {
            throw new TransactionTypeException("Identyfikator już istnieje podczas tworzenia!");
        }
    }

    public static void validateForUpdate(@NotNull TransactionType transactionType) {
        if (transactionType.getId() == null) {
            throw new TransactionTypeException("Identyfikator nie istnieje podczas modyfikacji!");
        }
    }

    public static void validateForArchivization(boolean isArchival, boolean archivization) {
        if (isArchival && archivization) {
            throw new TransactionTypeException("Nie można zarchiwizować już archiwalnego obiektu!");
        } else if (!isArchival && !archivization) {
            throw new TransactionTypeException("Nie można odarchiwizować aktywnego obiektu!");
        }
    }


}

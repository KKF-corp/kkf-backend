package pl.corp.kkf.kkf.services.impl.dao.validators.dictionaries;

import jakarta.validation.constraints.NotNull;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservices.dto.TransactionServiceDto;
import pl.corp.kkf.kkf.services.impl.dao.exceptions.dictionaries.TransactionServiceException;

public class TransactionServiceValidator {

    public static void validateForCreation(@NotNull TransactionServiceDto transactionServiceDto) {
        if (transactionServiceDto.getId() != null) {
            throw new TransactionServiceException("Identyfikator już istnieje podczas tworzenia!");
        }
    }

    public static void validateForUpdate(@NotNull TransactionServiceDto transactionServiceDto) {
        if (transactionServiceDto.getId() == null) {
            throw new TransactionServiceException("Identyfikator nie istnieje podczas modyfikacji!");
        }
    }

    public static void validateForArchivization(boolean isArchival, boolean archivization) {
        if (isArchival && archivization) {
            throw new TransactionServiceException("Nie można zarchiwizować już archiwalnego obiektu!");
        } else if (!isArchival && !archivization) {
            throw new TransactionServiceException("Nie można odarchiwizować aktywnego obiektu!");
        }
    }


}

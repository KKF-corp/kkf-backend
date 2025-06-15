package pl.corp.kkf.kkf.services.impl.dao.validators.dictionaries;

import jakarta.validation.constraints.NotNull;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.Contractor;
import pl.corp.kkf.kkf.services.impl.dao.exceptions.dictionaries.ContractorException;

public class ContractorValidator {

    public static void validateForCreation(@NotNull Contractor contractor) {
        if (contractor.getId() != null) {
            throw new ContractorException("Identyfikator już istnieje podczas tworzenia!");
        }
    }

    public static void validateForUpdate(@NotNull Contractor contractor) {
        if (contractor.getId() == null) {
            throw new ContractorException("Identyfikator nie istnieje podczas modyfikacji!");
        }
    }

    public static void validateForArchivization(boolean isArchival, boolean archivization) {
        if (isArchival && archivization) {
            throw new ContractorException("Nie można zarchiwizować już archiwalnego obiektu!");
        } else if (!isArchival && !archivization) {
            throw new ContractorException("Nie można odarchiwizować aktywnego obiektu!");
        }
    }


}

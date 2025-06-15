package pl.corp.kkf.kkf.services.impl.dao.validators.dictionaries;

import jakarta.validation.constraints.NotNull;
import pl.corp.kkf.kkf.services.api.dictionaries.addresses.dto.Address;
import pl.corp.kkf.kkf.services.impl.dao.exceptions.dictionaries.AddressException;

public class AddressValidator {

    public static void validateForCreation(@NotNull Address address) {
        if (address.getId() != null) {
            throw new AddressException("Identyfikator już istnieje podczas tworzenia!");
        }
    }

    public static void validateForUpdate(@NotNull Address address) {
        if (address.getId() == null) {
            throw new AddressException("Identyfikator nie istnieje podczas modyfikacji!");
        }
    }

    public static void validateForArchivization(boolean isArchival, boolean archivization) {
        if (isArchival && archivization) {
            throw new AddressException("Nie można zarchiwizować już archiwalnego obiektu!");
        } else if (!isArchival && !archivization) {
            throw new AddressException("Nie można odarchiwizować aktywnego obiektu!");
        }
    }


}

package pl.corp.kkf.services.dictionaries.impl.service.transactiontypes;

import pl.corp.kkf.services.dictionaries.api.transactiontypes.dto.TransactionType;

import java.util.List;

public interface TransactionTypeService {

    TransactionType getTransactionType(Long id);

    TransactionType createTransactionType(TransactionType transactionType);

    TransactionType updateTransactionType(TransactionType transactionType);

    void archiveTransactionType(Long id);

    void unarchiveTransactionType(Long id);

    List<TransactionType> getAllTransactionTypes();
}
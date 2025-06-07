package pl.corp.kkf.kkf.services.impl.service.dictionaries.transactiontypes;

import pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.dto.TransactionType;

import java.util.List;

public interface TransactionTypeService {

    TransactionType getTransactionType(long id);

    TransactionType createTransactionType(TransactionType transactionType);

    TransactionType updateTransactionType(TransactionType transactionType);

    void archiveTransactionType(long id);

    void unarchiveTransactionType(long id);

    List<TransactionType> getAllTransactionTypes();
}
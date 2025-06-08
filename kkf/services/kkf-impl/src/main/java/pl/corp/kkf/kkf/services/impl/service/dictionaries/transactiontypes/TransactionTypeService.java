package pl.corp.kkf.kkf.services.impl.service.dictionaries.transactiontypes;

import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.dto.TransactionType;
import pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.dto.TransactionTypeSearchRequest;

import java.util.List;

public interface TransactionTypeService {

    TransactionType getTransactionType(long id);

    TransactionType createTransactionType(TransactionType transactionType);

    TransactionType updateTransactionType(TransactionType transactionType);

    void archiveTransactionType(long id);

    void unarchiveTransactionType(long id);

    List<TransactionType> getAllTransactionTypes();

    PageDTO<TransactionType> findByCriteria(TransactionTypeSearchRequest request);

    boolean existsById(long id);
}
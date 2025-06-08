package pl.corp.kkf.kkf.services.impl.service.dictionaries.transactionservicetypes;

import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservicetypes.dto.TransactionServiceType;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservicetypes.dto.TransactionServiceTypeSearchRequest;

import java.util.List;

public interface TransactionServiceTypeService {

    TransactionServiceType getTransactionServiceType(long id);

    TransactionServiceType createTransactionServiceType(TransactionServiceType transactionServiceType);

    TransactionServiceType updateTransactionServiceType(TransactionServiceType transactionServiceType);

    void archiveTransactionServiceType(long id);

    void unarchiveTransactionServiceType(long id);

    List<TransactionServiceType> getAllTransactionServiceTypes();

    PageDTO<TransactionServiceType> findByCriteria(TransactionServiceTypeSearchRequest request);
}
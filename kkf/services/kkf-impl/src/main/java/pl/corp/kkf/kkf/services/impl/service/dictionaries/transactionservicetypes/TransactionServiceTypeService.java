package pl.corp.kkf.kkf.services.impl.service.dictionaries.transactionservicetypes;

import pl.corp.kkf.kkf.services.api.dictionaries.servicetypes.dto.TransactionServiceType;

import java.util.List;

public interface TransactionServiceTypeService {

    TransactionServiceType getTransactionServiceType(long id);

    TransactionServiceType createTransactionServiceType(TransactionServiceType transactionServiceType);

    TransactionServiceType updateTransactionServiceType(TransactionServiceType transactionServiceType);

    void archiveTransactionServiceType(long id);

    void unarchiveTransactionServiceType(long id);

    List<TransactionServiceType> getAllTransactionServiceTypes();
}
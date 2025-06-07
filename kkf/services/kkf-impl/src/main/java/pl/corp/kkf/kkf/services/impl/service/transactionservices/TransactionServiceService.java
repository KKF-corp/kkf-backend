package pl.corp.kkf.kkf.services.impl.service.transactionservices;

import pl.corp.kkf.kkf.services.api.transactionservices.dto.TransactionServiceDto;

import java.util.List;

public interface TransactionServiceService {

    TransactionServiceDto getTransactionService(long id);

    TransactionServiceDto createTransactionService(TransactionServiceDto service);

    TransactionServiceDto updateTransactionService(TransactionServiceDto service);

    void archiveTransactionService(long id);

    void unarchiveTransactionService(long id);

    List<TransactionServiceDto> getAllTransactionServices();
}
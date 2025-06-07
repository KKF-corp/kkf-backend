package pl.corp.kkf.kkf.services.impl.service.dictionaries.transactionservices;

import pl.corp.kkf.kkf.services.api.dictionaries.transactionservices.dto.TransactionServiceDto;

import java.util.List;

public interface TransactionServiceService {

    TransactionServiceDto getTransactionService(long id);

    TransactionServiceDto createTransactionService(TransactionServiceDto transactionService);

    TransactionServiceDto updateTransactionService(TransactionServiceDto transactionService);

    void archiveTransactionService(long id);

    void unarchiveTransactionService(long id);

    List<TransactionServiceDto> getAllTransactionServices();
}
package pl.corp.kkf.services.dictionaries.impl.service.transactionservices;

import pl.corp.kkf.services.dictionaries.api.transactionservices.dto.TransactionServiceDto;

import java.util.List;

public interface TransactionServiceService {

    TransactionServiceDto getTransactionService(Long id);

    TransactionServiceDto createTransactionService(TransactionServiceDto transactionService);

    TransactionServiceDto updateTransactionService(TransactionServiceDto transactionService);

    void archiveTransactionService(Long id);

    void unarchiveTransactionService(Long id);

    List<TransactionServiceDto> getAllTransactionServices();
}
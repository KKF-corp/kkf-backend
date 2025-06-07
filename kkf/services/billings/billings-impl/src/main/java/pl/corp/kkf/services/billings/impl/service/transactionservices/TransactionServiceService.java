package pl.corp.kkf.services.billings.impl.service.transactionservices;

import pl.corp.kkf.services.billings.api.transactionservices.dto.TransactionServiceDto;

import java.util.List;

public interface TransactionServiceService {

    TransactionServiceDto getTransactionService(Long id);

    TransactionServiceDto createTransactionService(TransactionServiceDto service);

    TransactionServiceDto updateTransactionService(TransactionServiceDto service);

    void archiveTransactionService(Long id);

    void unarchiveTransactionService(Long id);

    List<TransactionServiceDto> getAllTransactionServices();
}
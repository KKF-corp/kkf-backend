package pl.corp.kkf.kkf.services.impl.service.dictionaries.transactionservices;

import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservices.dto.TransactionServiceDto;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservices.dto.TransactionServiceSearchRequest;

import java.util.List;

public interface TransactionServiceService {

    TransactionServiceDto getTransactionService(long id);

    TransactionServiceDto createTransactionService(TransactionServiceDto transactionService);

    TransactionServiceDto updateTransactionService(TransactionServiceDto transactionService);

    void archiveTransactionService(long id);

    void unarchiveTransactionService(long id);

    List<TransactionServiceDto> getAllTransactionServices();

    PageDTO<TransactionServiceDto> findByCriteria(TransactionServiceSearchRequest request);
}
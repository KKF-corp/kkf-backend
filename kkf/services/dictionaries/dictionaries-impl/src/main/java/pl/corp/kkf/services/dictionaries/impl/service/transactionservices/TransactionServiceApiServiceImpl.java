package pl.corp.kkf.services.dictionaries.impl.service.transactionservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.services.dictionaries.api.transactionservices.TransactionServiceApiService;
import pl.corp.kkf.services.dictionaries.api.transactionservices.dto.TransactionServiceDto;

import java.util.List;

@Service
public class TransactionServiceApiServiceImpl implements TransactionServiceApiService {

    private final TransactionServiceService transactionServiceService;

    @Autowired
    public TransactionServiceApiServiceImpl(TransactionServiceService transactionServiceService) {
        this.transactionServiceService = transactionServiceService;
    }

    @Override
    public TransactionServiceDto getTransactionService(long id) {
        return transactionServiceService.getTransactionService(id);
    }

    @Override
    public TransactionServiceDto createTransactionService(TransactionServiceDto service) {
        return transactionServiceService.createTransactionService(service);
    }

    @Override
    public TransactionServiceDto updateTransactionService(TransactionServiceDto service) {
        return transactionServiceService.updateTransactionService(service);
    }

    @Override
    public GeneralResponse archiveTransactionService(long id) {
        transactionServiceService.archiveTransactionService(id);
        return new GeneralResponse();
    }

    @Override
    public GeneralResponse unarchiveTransactionService(long id) {
        transactionServiceService.unarchiveTransactionService(id);
        return new GeneralResponse();
    }

    @Override
    public List<TransactionServiceDto> getAllTransactionServices() {
        return transactionServiceService.getAllTransactionServices();
    }
}
package pl.corp.kkf.services.billings.impl.service.transactionservices;

import org.springframework.beans.factory.annotation.Autowired;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.services.billings.api.transactionservices.TransactionServiceApiService;
import pl.corp.kkf.services.billings.api.transactionservices.dto.Service;
import pl.corp.kkf.services.billings.api.transactionservices.dto.TransactionServiceDto;

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
    public TransactionServiceDto createTransactionService(TransactionServiceDto transactionService) {
        return transactionServiceService.createTransactionService(transactionService);
    }

    @Override
    public TransactionServiceDto updateTransactionService(TransactionServiceDto transactionService) {
        return transactionServiceService.updateTransactionService(transactionService);
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
package pl.corp.kkf.kkf.services.impl.service.transactionservices;

import jakarta.annotation.security.DenyAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.transactionservices.TransactionServiceApiService;
import pl.corp.kkf.kkf.services.api.transactionservices.dto.RevenueServiceDto;
import pl.corp.kkf.kkf.services.api.transactionservices.dto.TransactionServiceDto;

import java.util.List;

@Service
public class TransactionServiceApiServiceImpl implements TransactionServiceApiService {

    @Autowired
    private TransactionServiceService transactionServiceService;

    @DenyAll
    @Override
    public TransactionServiceDto getTransactionService(long id) {
        return (TransactionServiceDto) transactionServiceService.getTransactionService(id);
    }

    @DenyAll
    @Override
    public TransactionServiceDto createTransactionService(TransactionServiceDto transactionService) {
        return transactionServiceService.createRevenueService(transactionService);
//        return transactionServiceService.createExpenseService(transactionService);
    }

    @DenyAll
    @Override
    public TransactionServiceDto updateTransactionService(TransactionServiceDto transactionService) {
        return transactionServiceService.updateTransactionService(transactionService);
    }

    @DenyAll
    @Override
    public GeneralResponse archiveTransactionService(long id) {
        transactionServiceService.archiveTransactionService(id);
        return new GeneralResponse();
    }

    @DenyAll
    @Override
    public GeneralResponse unarchiveTransactionService(long id) {
        transactionServiceService.unarchiveTransactionService(id);
        return new GeneralResponse();
    }

    @DenyAll
    @Override
    public List<TransactionServiceDto> getAllTransactionServices() {
        return transactionServiceService.getAllTransactionServices();
    }
}
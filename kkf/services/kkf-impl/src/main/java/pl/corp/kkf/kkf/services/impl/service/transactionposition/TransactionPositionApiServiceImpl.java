package pl.corp.kkf.kkf.services.impl.service.transactionposition;

import jakarta.annotation.security.DenyAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.transactionservices.TransactionPositionApiService;
import pl.corp.kkf.kkf.services.api.transactionservices.dto.TransactionPosition;

import java.util.List;

@Service
public class TransactionPositionApiServiceImpl implements TransactionPositionApiService {

    @Autowired
    private TransactionPositionService transactionPositionService;

    @DenyAll
    @Override
    public TransactionPosition getTransactionService(long id) {
        return (TransactionPosition) transactionPositionService.getTransactionService(id);
    }

    @DenyAll
    @Override
    public TransactionPosition createTransactionService(TransactionPosition transactionService) {
        return transactionPositionService.createRevenueService(transactionService);
//        return transactionServiceService.createExpenseService(transactionService);
    }

    @DenyAll
    @Override
    public TransactionPosition updateTransactionService(TransactionPosition transactionService) {
        return transactionPositionService.updateTransactionService(transactionService);
    }

    @DenyAll
    @Override
    public GeneralResponse archiveTransactionService(long id) {
        transactionPositionService.archiveTransactionService(id);
        return new GeneralResponse();
    }

    @DenyAll
    @Override
    public GeneralResponse unarchiveTransactionService(long id) {
        transactionPositionService.unarchiveTransactionService(id);
        return new GeneralResponse();
    }

    @DenyAll
    @Override
    public List<TransactionPosition> getAllTransactionServices() {
        return transactionPositionService.getAllTransactionServices();
    }
}
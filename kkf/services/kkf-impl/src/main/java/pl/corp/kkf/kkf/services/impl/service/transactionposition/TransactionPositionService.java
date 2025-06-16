package pl.corp.kkf.kkf.services.impl.service.transactionposition;

import pl.corp.kkf.kkf.services.api.transactionservices.dto.TransactionPosition;

import java.util.List;

public interface TransactionPositionService {

    TransactionPosition getTransactionService(long id);

    TransactionPosition createRevenueService(TransactionPosition transactionService);

    TransactionPosition createExpenseService(TransactionPosition transactionService);

    TransactionPosition updateTransactionService(TransactionPosition service);

    void archiveTransactionService(long id);

    void unarchiveTransactionService(long id);

    List<TransactionPosition> getAllTransactionServices();
}
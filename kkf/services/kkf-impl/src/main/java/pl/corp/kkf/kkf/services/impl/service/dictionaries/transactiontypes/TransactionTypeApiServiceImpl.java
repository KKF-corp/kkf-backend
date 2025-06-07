package pl.corp.kkf.kkf.services.impl.service.dictionaries.transactiontypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.TransactionTypeApiService;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.dto.TransactionType;

import java.util.List;

@Service
public class TransactionTypeApiServiceImpl implements TransactionTypeApiService {

    private final TransactionTypeService transactionTypeService;

    @Autowired
    public TransactionTypeApiServiceImpl(TransactionTypeService transactionTypeService) {
        this.transactionTypeService = transactionTypeService;
    }

    @Override
    public TransactionType getTransactionType(long id) {
        return transactionTypeService.getTransactionType(id);
    }

    @Override
    public TransactionType createTransactionType(TransactionType transactionType) {
        return transactionTypeService.createTransactionType(transactionType);
    }

    @Override
    public TransactionType updateTransactionType(TransactionType transactionType) {
        return transactionTypeService.updateTransactionType(transactionType);
    }

    @Override
    public GeneralResponse archiveTransactionType(long id) {
        transactionTypeService.archiveTransactionType(id);
        return new GeneralResponse();
    }

    @Override
    public GeneralResponse unarchiveTransactionType(long id) {
        transactionTypeService.unarchiveTransactionType(id);
        return new GeneralResponse();
    }

    @Override
    public List<TransactionType> getAllTransactionTypes() {
        return transactionTypeService.getAllTransactionTypes();
    }
}
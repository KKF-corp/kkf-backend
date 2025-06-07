package pl.corp.kkf.services.dictionaries.impl.service.transactiontypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.services.dictionaries.api.transactiontypes.TransactionTypeApiService;
import pl.corp.kkf.services.dictionaries.api.transactiontypes.dto.TransactionType;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.services.dictionaries.impl.dao.converters.TransactionTypeConverter;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionTypeApiServiceImpl implements TransactionTypeApiService {

    private final TransactionTypeService transactionTypeService;

    @Autowired
    public TransactionTypeApiServiceImpl(TransactionTypeService transactionTypeService) {
        this.transactionTypeService = transactionTypeService;
    }

    @Override
    public TransactionType getTransactionType(Long id) {
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
    public GeneralResponse archiveTransactionType(Long id) {
        transactionTypeService.archiveTransactionType(id);
        return new GeneralResponse();
    }

    @Override
    public GeneralResponse unarchiveTransactionType(Long id) {
        transactionTypeService.unarchiveTransactionType(id);
        return new GeneralResponse();
    }

    @Override
    public List<TransactionType> getAllTransactionTypes() {
        return transactionTypeService.getAllTransactionTypes();
    }
}
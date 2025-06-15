package pl.corp.kkf.kkf.services.impl.service.dictionaries.transactiontypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.TransactionTypeApiService;
import pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.dto.TransactionType;
import pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.dto.TransactionTypeSearchRequest;
import pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.dto.TransactionTypeSearchResponse;
import pl.corp.kkf.kkf.services.impl.KKFModuleConstants;
import pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.TransactionTypeConverter;
import pl.corp.kkf.kkf.services.impl.dao.exceptions.dictionaries.TransactionTypeException;

import java.util.List;

@Service
public class TransactionTypeApiServiceImpl implements TransactionTypeApiService {

    @Autowired
    private TransactionTypeService transactionTypeService;

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER, readOnly = true)
    public TransactionType getTransactionType(long id) {
        return transactionTypeService.getTransactionType(id);
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER)
    public TransactionType createTransactionType(TransactionType transactionType) {
        return transactionTypeService.createTransactionType(transactionType);
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER)
    public TransactionType updateTransactionType(TransactionType transactionType) {
        return transactionTypeService.updateTransactionType(transactionType);
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER)
    public GeneralResponse archiveTransactionType(long id) {
        transactionTypeService.archiveTransactionType(id);
        return new GeneralResponse();
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER)
    public GeneralResponse unarchiveTransactionType(long id) {
        transactionTypeService.unarchiveTransactionType(id);
        return new GeneralResponse();
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER, readOnly = true)
    public List<TransactionType> getAllTransactionTypes() {
        return transactionTypeService.getAllTransactionTypes();
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER, readOnly = true)
    public TransactionTypeSearchResponse findByCriteria(TransactionTypeSearchRequest request) {
        try {
            PageDTO<TransactionType> byCriteria = transactionTypeService.findByCriteria(request);
            return TransactionTypeConverter.convertToContractorSearchResponse(byCriteria);
        } catch (TransactionTypeException e) {
            throw new TransactionTypeException("");
        }
    }
}
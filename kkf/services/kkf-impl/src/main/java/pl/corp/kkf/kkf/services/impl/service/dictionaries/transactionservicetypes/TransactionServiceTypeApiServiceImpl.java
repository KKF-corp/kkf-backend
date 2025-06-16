package pl.corp.kkf.kkf.services.impl.service.dictionaries.transactionservicetypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservicetypes.TransactionServiceTypeApiService;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservicetypes.dto.TransactionServiceType;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservicetypes.dto.TransactionServiceTypeSearchRequest;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservicetypes.dto.TransactionServiceTypeSearchResponse;
import pl.corp.kkf.kkf.services.impl.KKFModuleConstants;
import pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.TransactionServiceTypeConverter;
import pl.corp.kkf.kkf.services.impl.dao.exceptions.dictionaries.TransactionServiceTypeException;

import java.util.List;

@Service
public class TransactionServiceTypeApiServiceImpl implements TransactionServiceTypeApiService {

    @Autowired
    private TransactionServiceTypeService transactionServiceTypeService;

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER, readOnly = true)
    public TransactionServiceType getTransactionServiceType(long id) {
        return transactionServiceTypeService.getTransactionServiceType(id);
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER)
    public TransactionServiceType createTransactionServiceType(TransactionServiceType serviceType) {
        return transactionServiceTypeService.createTransactionServiceType(serviceType);
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER)
    public TransactionServiceType updateTransactionServiceType(TransactionServiceType serviceType) {
        return transactionServiceTypeService.updateTransactionServiceType(serviceType);
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER)
    public GeneralResponse archiveTransactionServiceType(long id) {
        transactionServiceTypeService.archiveTransactionServiceType(id);
        return new GeneralResponse();
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER)
    public GeneralResponse unarchiveTransactionServiceType(long id) {
        transactionServiceTypeService.unarchiveTransactionServiceType(id);
        return new GeneralResponse();
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER, readOnly = true)
    public List<TransactionServiceType> getAllTransactionServiceTypes() {
        return transactionServiceTypeService.getAllTransactionServiceTypes();
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER, readOnly = true)
    public TransactionServiceTypeSearchResponse findByCriteria(TransactionServiceTypeSearchRequest request) {
        try {
            PageDTO<TransactionServiceType> byCriteria = transactionServiceTypeService.findByCriteria(request);
            return TransactionServiceTypeConverter.convertToSearchResponse(byCriteria);
        } catch (TransactionServiceTypeException e) {
            throw new TransactionServiceTypeException("");
        }
    }
}
package pl.corp.kkf.kkf.services.impl.service.dictionaries.transactionservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.Contractor;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservices.TransactionServiceApiService;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservices.dto.TransactionServiceDto;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservices.dto.TransactionServiceSearchRequest;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservices.dto.TransactionServiceSearchResponse;
import pl.corp.kkf.kkf.services.impl.KKFModuleConstants;
import pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.ContractorConverter;
import pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.TransactionServiceDictionaryConverter;
import pl.corp.kkf.kkf.services.impl.dao.exceptions.dictionaries.ContractorException;
import pl.corp.kkf.kkf.services.impl.dao.exceptions.dictionaries.TransactionServiceException;
import pl.corp.kkf.kkf.services.impl.service.dictionaries.transactionservices.TransactionServiceService;

import java.util.List;

@Service
public class TransactionServiceApiServiceImpl implements TransactionServiceApiService {

    private final TransactionServiceService transactionServiceService;

    @Autowired
    public TransactionServiceApiServiceImpl(TransactionServiceService transactionServiceService) {
        this.transactionServiceService = transactionServiceService;
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER, readOnly = true)
    public TransactionServiceDto getTransactionService(long id) {
        return transactionServiceService.getTransactionService(id);
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER)
    public TransactionServiceDto createTransactionService(TransactionServiceDto service) {
        return transactionServiceService.createTransactionService(service);
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER)
    public TransactionServiceDto updateTransactionService(TransactionServiceDto service) {
        return transactionServiceService.updateTransactionService(service);
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER)
    public GeneralResponse archiveTransactionService(long id) {
        transactionServiceService.archiveTransactionService(id);
        return new GeneralResponse();
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER)
    public GeneralResponse unarchiveTransactionService(long id) {
        transactionServiceService.unarchiveTransactionService(id);
        return new GeneralResponse();
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER, readOnly = true)
    public List<TransactionServiceDto> getAllTransactionServices() {
        return transactionServiceService.getAllTransactionServices();
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER, readOnly = true)
    public TransactionServiceSearchResponse findByCriteria(TransactionServiceSearchRequest request) {
        try {
            PageDTO<TransactionServiceDto> byCriteria = transactionServiceService.findByCriteria(request);
            return TransactionServiceDictionaryConverter.convertToContractorSearchResponse(byCriteria);
        } catch (TransactionServiceException e) {
            throw new TransactionServiceException("");
        }
    }
}
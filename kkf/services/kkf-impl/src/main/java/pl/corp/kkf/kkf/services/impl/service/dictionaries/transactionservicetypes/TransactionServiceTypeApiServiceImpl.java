package pl.corp.kkf.kkf.services.impl.service.dictionaries.transactionservicetypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.dictionaries.servicetypes.TransactionServiceTypeApiService;
import pl.corp.kkf.kkf.services.api.dictionaries.servicetypes.dto.TransactionServiceType;
import pl.corp.kkf.kkf.services.api.dictionaries.servicetypes.TransactionServiceTypeSearchRequest;
import pl.corp.kkf.kkf.services.impl.service.dictionaries.transactionservicetypes.TransactionServiceTypeService;

import java.util.List;

@Service
public class TransactionServiceTypeApiServiceImpl implements TransactionServiceTypeApiService {

    private final TransactionServiceTypeService transactionServiceTypeService;

    @Autowired
    public TransactionServiceTypeApiServiceImpl(TransactionServiceTypeService transactionServiceTypeService) {
        this.transactionServiceTypeService = transactionServiceTypeService;
    }

    @Override
    public TransactionServiceType getTransactionServiceType(long id) {
        return transactionServiceTypeService.getTransactionServiceType(id);
    }

    @Override
    public TransactionServiceType createTransactionServiceType(TransactionServiceType serviceType) {
        return transactionServiceTypeService.createTransactionServiceType(serviceType);
    }

    @Override
    public TransactionServiceType updateTransactionServiceType(TransactionServiceType serviceType) {
        return transactionServiceTypeService.updateTransactionServiceType(serviceType);
    }

    @Override
    public GeneralResponse archiveTransactionServiceType(long id) {
        transactionServiceTypeService.archiveTransactionServiceType(id);
        return new GeneralResponse();
    }

    @Override
    public GeneralResponse unarchiveTransactionServiceType(long id) {
        transactionServiceTypeService.unarchiveTransactionServiceType(id);
        return new GeneralResponse();
    }

    @Override
    public List<TransactionServiceType> getAllTransactionServiceTypes() {
        return transactionServiceTypeService.getAllTransactionServiceTypes();
    }

    @Override
    public TransactionServiceTypeSearchResponse findByCriteria(TransactionServiceTypeSearchRequest request) {
        PageDTO<TransactionServiceType> byCriteria = transactionServiceTypeService.findByCriteria(request);
        TransactionServiceTypeSearchResponse transactionServiceTypeSearchResponse = new TransactionServiceTypeSearchResponse();
        transactionServiceTypeSearchResponse.setPageDTO(byCriteria);
        return transactionServiceTypeSearchResponse;
    }
}
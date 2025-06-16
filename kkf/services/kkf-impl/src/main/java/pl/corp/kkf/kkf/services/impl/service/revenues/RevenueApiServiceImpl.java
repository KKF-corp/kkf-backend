package pl.corp.kkf.kkf.services.impl.service.revenues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.revenues.RevenueApiService;
import pl.corp.kkf.kkf.services.api.revenues.dto.Revenue;
import pl.corp.kkf.kkf.services.api.revenues.dto.RevenueSearchRequest;
import pl.corp.kkf.kkf.services.api.revenues.dto.RevenueSearchResponse;
import pl.corp.kkf.kkf.services.impl.KKFModuleConstants;
import pl.corp.kkf.kkf.services.impl.dao.converters.RevenueConverter;
import pl.corp.kkf.kkf.services.impl.dao.exceptions.RevenueException;

import java.util.List;

@Service
public class RevenueApiServiceImpl implements RevenueApiService {

    @Autowired
    private RevenueService revenueService;

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER, readOnly = true)
    public Revenue getRevenue(long id) {
        return revenueService.getRevenue(id);
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER)
    public Revenue createRevenue(Revenue revenue) {
        return revenueService.createRevenue(revenue);
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER)
    public Revenue updateRevenue(Revenue revenue) {
        return revenueService.updateRevenue(revenue);
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER)
    public GeneralResponse deleteRevenue(long id) {
        revenueService.deleteRevenue(id);
        return new GeneralResponse();
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER, readOnly = true)
    public List<Revenue> getAllRevenues() {
        return revenueService.getAllRevenues();
    }

    @Override
    @Transactional(transactionManager = KKFModuleConstants.TRANSACTION_MANAGER, readOnly = true)
    public RevenueSearchResponse findByCriteria(RevenueSearchRequest request) {
        try {
            PageDTO<Revenue> byCriteria = revenueService.findByCriteria(request);
            return RevenueConverter.convertToSearchResponse(byCriteria);
        } catch (RevenueException e) {
            throw new RevenueException("");
        }
    }
}
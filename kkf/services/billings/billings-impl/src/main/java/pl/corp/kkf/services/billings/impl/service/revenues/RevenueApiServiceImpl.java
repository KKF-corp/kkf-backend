package pl.corp.kkf.services.billings.impl.service.revenues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.services.billings.api.revenues.RevenueApiService;
import pl.corp.kkf.services.billings.api.revenues.dto.Revenue;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;

import java.util.List;

@Service
public class RevenueApiServiceImpl implements RevenueApiService {

    private final RevenueService revenueService;

    @Autowired
    public RevenueApiServiceImpl(RevenueService revenueService) {
        this.revenueService = revenueService;
    }

    @Override
    public Revenue getRevenue(Long id) {
        return revenueService.getRevenue(id);
    }

    @Override
    public Revenue createRevenue(Revenue revenue) {
        return revenueService.createRevenue(revenue);
    }

    @Override
    public Revenue updateRevenue(Revenue revenue) {
        return revenueService.updateRevenue(revenue);
    }

    @Override
    public GeneralResponse archiveRevenue(Long id) {
        revenueService.archiveRevenue(id);
        return new GeneralResponse();
    }

    @Override
    public GeneralResponse unarchiveRevenue(Long id) {
        revenueService.unarchiveRevenue(id);
        return new GeneralResponse();
    }

    @Override
    public List<Revenue> getAllRevenues() {
        return revenueService.getAllRevenues();
    }
}
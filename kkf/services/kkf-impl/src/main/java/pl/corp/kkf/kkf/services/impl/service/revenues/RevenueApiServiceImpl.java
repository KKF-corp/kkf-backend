package pl.corp.kkf.kkf.services.impl.service.revenues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.revenues.RevenueApiService;
import pl.corp.kkf.kkf.services.api.revenues.dto.Revenue;

import java.util.List;

@Service
public class RevenueApiServiceImpl implements RevenueApiService {

    private final RevenueService revenueService;

    @Autowired
    public RevenueApiServiceImpl(RevenueService revenueService) {
        this.revenueService = revenueService;
    }

    @Override
    public Revenue getRevenue(long id) {
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
    public GeneralResponse archiveRevenue(long id) {
        revenueService.archiveRevenue(id);
        return new GeneralResponse();
    }

    @Override
    public GeneralResponse unarchiveRevenue(long id) {
        revenueService.unarchiveRevenue(id);
        return new GeneralResponse();
    }

    @Override
    public List<Revenue> getAllRevenues() {
        return revenueService.getAllRevenues();
    }
}
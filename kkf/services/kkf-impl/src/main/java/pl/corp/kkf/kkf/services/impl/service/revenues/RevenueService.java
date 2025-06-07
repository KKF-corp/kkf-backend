package pl.corp.kkf.kkf.services.impl.service.revenues;

import pl.corp.kkf.kkf.services.api.revenues.dto.Revenue;

import java.util.List;

public interface RevenueService {

    Revenue getRevenue(long id);

    Revenue createRevenue(Revenue revenue);

    Revenue updateRevenue(Revenue revenue);

    void archiveRevenue(long id);

    void unarchiveRevenue(long id);

    List<Revenue> getAllRevenues();
}
package pl.corp.kkf.services.billings.impl.service.revenues;

import pl.corp.kkf.services.billings.api.revenues.dto.Revenue;

import java.util.List;

public interface RevenueService {

    Revenue getRevenue(Long id);

    Revenue createRevenue(Revenue revenue);

    Revenue updateRevenue(Revenue revenue);

    void archiveRevenue(Long id);

    void unarchiveRevenue(Long id);

    List<Revenue> getAllRevenues();
}
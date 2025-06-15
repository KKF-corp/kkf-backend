package pl.corp.kkf.kkf.services.impl.service.revenues;

import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.kkf.services.api.revenues.dto.Revenue;
import pl.corp.kkf.kkf.services.api.revenues.dto.RevenueSearchRequest;

import java.util.List;

public interface RevenueService {

    Revenue getRevenue(long id);

    Revenue createRevenue(Revenue revenue);

    Revenue updateRevenue(Revenue revenue);

    void deleteRevenue(long id);

    List<Revenue> getAllRevenues();

    PageDTO<Revenue> findByCriteria(RevenueSearchRequest request);
}
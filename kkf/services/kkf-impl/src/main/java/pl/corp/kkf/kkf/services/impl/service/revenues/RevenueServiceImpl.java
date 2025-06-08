package pl.corp.kkf.kkf.services.impl.service.revenues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.revenues.dto.Revenue;
import pl.corp.kkf.kkf.services.api.revenues.dto.RevenueSearchRequest;
import pl.corp.kkf.kkf.services.impl.dao.repositories.RevenueRepository;
import pl.corp.kkf.kkf.services.impl.dao.converters.RevenueConverter;
import pl.corp.kkf.commons.base.service.PageUtils;
import pl.corp.kkf.kkf.services.model.RevenueEntity;
import org.springframework.data.jpa.domain.Specification;
import pl.corp.kkf.kkf.services.api.revenues.dto.RevenueCriteria;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RevenueServiceImpl implements RevenueService {

    @Autowired
    private RevenueRepository revenueRepository;

    @Override
    public Revenue getRevenue(long id) {
        RevenueEntity revenueEntity = revenueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Revenue not found with id: " + id));
        return RevenueConverter.toDto(revenueEntity);
    }

    @Override
    public Revenue createRevenue(Revenue revenue) {
        RevenueEntity revenueEntity = RevenueConverter.toEntity(revenue);
        RevenueEntity savedRevenueEntity = revenueRepository.save(revenueEntity);
        return RevenueConverter.toDto(savedRevenueEntity);
    }

    @Override
    public Revenue updateRevenue(Revenue revenue) {
        RevenueEntity revenueEntity = RevenueConverter.toEntity(revenue);
        RevenueEntity updatedRevenueEntity = revenueRepository.save(revenueEntity);
        return RevenueConverter.toDto(updatedRevenueEntity);
    }

    @Override
    public GeneralResponse archiveRevenue(long id) {
        RevenueEntity revenueEntity = revenueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Revenue not found with id: " + id));
        revenueEntity.setDeleted(true);
        revenueRepository.save(revenueEntity);
    }

    @Override
    public GeneralResponse unarchiveRevenue(long id) {
        RevenueEntity revenueEntity = revenueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Revenue not found with id: " + id));
        revenueEntity.setDeleted(false);
        revenueRepository.save(revenueEntity);
    }

    @Override
    public List<Revenue> getAllRevenues() {
        List<RevenueEntity> revenueEntities = revenueRepository.findAll();
        return revenueEntities.stream()
                .map(RevenueConverter::toDto)
                .collect(Collectors.toList());
    }

     @Override
    public PageDTO<Revenue> findByCriteria(RevenueSearchRequest request) {
        Pageable pageable = PageUtils.convertTo(request.getPageRequestDTO());
        Specification<RevenueEntity> specification = revenueRepository.getSpecification(request.getCriteria());
        Page<RevenueEntity> revenueEntities = revenueRepository.findAll(specification, pageable);
        PageDTO<Revenue> pageDTO = PageUtils.convertTo(revenueEntities.map(RevenueConverter::toDto));
        return pageDTO;
    }
}
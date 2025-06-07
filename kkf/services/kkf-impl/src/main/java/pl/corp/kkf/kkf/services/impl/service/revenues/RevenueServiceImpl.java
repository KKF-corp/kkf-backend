package pl.corp.kkf.kkf.services.impl.service.revenues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.kkf.services.api.revenues.dto.Revenue;
import pl.corp.kkf.kkf.services.impl.dao.converters.RevenueConverter;
import pl.corp.kkf.kkf.services.impl.dao.repositories.RevenueRepository;
import pl.corp.kkf.kkf.services.model.RevenueEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RevenueServiceImpl implements RevenueService {

    private final RevenueRepository revenueRepository;

    @Autowired
    public RevenueServiceImpl(RevenueRepository revenueRepository) {
        this.revenueRepository = revenueRepository;
    }

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
    public void archiveRevenue(long id) {
        RevenueEntity revenueEntity = revenueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Revenue not found with id: " + id));
        revenueEntity.setDeleted(true);
        revenueRepository.save(revenueEntity);
    }

    @Override
    public void unarchiveRevenue(long id) {
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
}
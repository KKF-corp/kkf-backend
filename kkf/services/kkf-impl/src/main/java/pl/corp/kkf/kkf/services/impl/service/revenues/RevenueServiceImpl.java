package pl.corp.kkf.kkf.services.impl.service.revenues;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.corp.kkf.commons.base.service.rest.PageUtils;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.kkf.services.api.revenues.dto.Revenue;
import pl.corp.kkf.kkf.services.api.revenues.dto.RevenueSearchRequest;
import pl.corp.kkf.kkf.services.impl.dao.converters.RevenueConverter;
import pl.corp.kkf.kkf.services.impl.dao.exceptions.RevenueException;
import pl.corp.kkf.kkf.services.impl.dao.repositories.RevenueRepository;
import pl.corp.kkf.kkf.services.impl.dao.validators.RevenueValidator;
import pl.corp.kkf.kkf.services.impl.dao.validators.TransactionServiceValidator;
import pl.corp.kkf.kkf.services.impl.service.dictionaries.contractors.ContractorService;
import pl.corp.kkf.kkf.services.impl.service.dictionaries.transactiontypes.TransactionTypeService;
import pl.corp.kkf.kkf.services.model.RevenueEntity;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static pl.corp.kkf.kkf.services.impl.dao.converters.RevenueConverter.toDto;
import static pl.corp.kkf.kkf.services.impl.dao.converters.RevenueConverter.toEntity;

@Service
public class RevenueServiceImpl implements RevenueService {

    public static final Supplier<@NotNull RevenueException> REVENUE_NOT_FOUND_EXCEPTION_SUPPLIER = () -> new RevenueException("Nie znaleziono przychodu o podanym identyfikatorze");

    @Autowired
    private RevenueRepository revenueRepository;
    @Autowired
    private RevenueValidator revenueValidator;
    @Autowired
    private TransactionServiceValidator transactionServiceValidator;
    @Autowired
    private ContractorService contractorService;
    @Autowired
    private TransactionTypeService transactionTypeService;

    @Override
    public Revenue getRevenue(long id) {
        RevenueEntity entity = revenueRepository.findById(id)
                .orElseThrow(REVENUE_NOT_FOUND_EXCEPTION_SUPPLIER);
        return toDto(entity);
    }

    @Override
    public Revenue createRevenue(Revenue revenue) {
        validateForCreation(revenue);
        return toDto(revenueRepository.save(toEntity(new RevenueEntity(), revenue)));
    }

    @Override
    public Revenue updateRevenue(Revenue revenue) {
        validateForUpdate(revenue);
        RevenueEntity entity = revenueRepository.findById(revenue.getId())
                .orElseThrow(REVENUE_NOT_FOUND_EXCEPTION_SUPPLIER);
        return toDto(revenueRepository.save(toEntity(entity, revenue)));
    }

    @Override
    public void deleteRevenue(long id) {
        RevenueEntity entity = revenueRepository.findById(id)
                .orElseThrow(REVENUE_NOT_FOUND_EXCEPTION_SUPPLIER);
        revenueValidator.validateForDelete(entity.getDeleted());
        entity.setDeleted(true);
        revenueRepository.save(entity);
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
        return PageUtils.convertTo(revenueEntities.map(RevenueConverter::toDto));
    }

    private void validateForCreation(Revenue revenue) {
        revenueValidator.validateForCreation(revenue, transactionServiceValidator, contractorService, transactionTypeService);
    }

    private void validateForUpdate(Revenue revenue) {
        revenueValidator.validateForUpdate(revenue, transactionServiceValidator, contractorService, transactionTypeService);
    }
}
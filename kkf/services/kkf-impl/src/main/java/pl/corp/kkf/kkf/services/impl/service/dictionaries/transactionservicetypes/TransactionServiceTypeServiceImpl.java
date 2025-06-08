package pl.corp.kkf.kkf.services.impl.service.dictionaries.transactionservicetypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import pl.corp.kkf.kkf.services.api.dictionaries.servicetypes.dto.TransactionServiceType;
import pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.ServiceTypeConverter;
import pl.corp.kkf.kkf.services.impl.dao.repositories.dictionaries.TransactionServiceTypeRepository;
import pl.corp.kkf.kkf.services.model.dictionaries.TransactionServiceTypeEntity;
import pl.corp.kkf.kkf.services.impl.validator.dictionaries.TransactionServiceTypeValidator;
import pl.corp.kkf.commons.base.service.PageUtils;
import pl.corp.kkf.commons.base.dao.BusinessException;
import org.springframework.data.jpa.domain.Specification;
import pl.corp.kkf.kkf.services.api.dictionaries.servicetypes.dto.TransactionServiceTypeCriteria;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceTypeServiceImpl implements TransactionServiceTypeService {

    private final TransactionServiceTypeRepository transactionServiceTypeRepository;
    private final TransactionServiceTypeValidator transactionServiceTypeValidator;

    @Autowired
    public TransactionServiceTypeServiceImpl(TransactionServiceTypeRepository transactionServiceTypeRepository, TransactionServiceTypeValidator transactionServiceTypeValidator) {
        this.transactionServiceTypeRepository = transactionServiceTypeRepository;
        this.transactionServiceTypeValidator = transactionServiceTypeValidator;
    }

    @Override
    public TransactionServiceType getTransactionServiceType(long id) {
        TransactionServiceTypeEntity transactionServiceTypeEntity = transactionServiceTypeRepository.findById(id)
                .orElseThrow(() -> new BusinessException("TransactionServiceType not found with id: " + id));
        return ServiceTypeConverter.toDto(transactionServiceTypeEntity);
    }

    @Override
    public TransactionServiceType createTransactionServiceType(TransactionServiceType serviceType) {
        transactionServiceTypeValidator.validateForCreate(serviceType);
        TransactionServiceTypeEntity transactionServiceTypeEntity = ServiceTypeConverter.toEntity(serviceType);
        TransactionServiceTypeEntity savedTransactionServiceTypeEntity = transactionServiceTypeRepository.save(transactionServiceTypeEntity);
        return ServiceTypeConverter.toDto(savedTransactionServiceTypeEntity);
    }

    @Override
    public TransactionServiceType updateTransactionServiceType(TransactionServiceType serviceType) {
        transactionServiceTypeValidator.validateForUpdate(serviceType);
        TransactionServiceTypeEntity transactionServiceTypeEntity = ServiceTypeConverter.toEntity(serviceType);
        TransactionServiceTypeEntity updatedTransactionServiceTypeEntity = transactionServiceTypeRepository.save(transactionServiceTypeEntity);
        return ServiceTypeConverter.toDto(updatedTransactionServiceTypeEntity);
    }

    @Override
    public void archiveTransactionServiceType(long id) {
        TransactionServiceTypeEntity transactionServiceTypeEntity = transactionServiceTypeRepository.findById(id)
                .orElseThrow(() -> new BusinessException("TransactionServiceType not found with id: " + id));
        transactionServiceTypeEntity.setArchival(true);
        transactionServiceTypeRepository.save(transactionServiceTypeEntity);
    }

    @Override
    public void unarchiveTransactionServiceType(long id) {
        TransactionServiceTypeEntity transactionServiceTypeEntity = transactionServiceTypeRepository.findById(id)
                .orElseThrow(() -> new BusinessException("TransactionServiceType not found with id: " + id));
        transactionServiceTypeEntity.setArchival(false);
        transactionServiceTypeRepository.save(transactionServiceTypeEntity);
    }

    @Override
    public List<TransactionServiceType> getAllTransactionServiceTypes() {
        List<TransactionServiceTypeEntity> serviceTypeEntities = transactionServiceTypeRepository.findAll();
        return serviceTypeEntities.stream()
                .map(ServiceTypeConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PageDTO<TransactionServiceType> findByCriteria(TransactionServiceTypeSearchRequest request) {
         Pageable pageable = PageUtils.convertTo(request.getPageRequestDTO());
        Specification<TransactionServiceTypeEntity> specification = transactionServiceTypeRepository.getSpecification(request.getCriteria());
        Page<TransactionServiceTypeEntity> transactionServiceTypeEntities = transactionServiceTypeRepository.findAll(specification, pageable);
        PageDTO<TransactionServiceType> pageDTO = PageUtils.convertTo(transactionServiceTypeEntities.map(ServiceTypeConverter::toDto));
        return pageDTO;
    }}

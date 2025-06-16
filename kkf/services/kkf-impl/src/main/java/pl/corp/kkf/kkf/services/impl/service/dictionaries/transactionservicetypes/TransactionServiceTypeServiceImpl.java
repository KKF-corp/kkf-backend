package pl.corp.kkf.kkf.services.impl.service.dictionaries.transactionservicetypes;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.corp.kkf.commons.base.service.rest.PageUtils;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservicetypes.dto.TransactionServiceType;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservicetypes.dto.TransactionServiceTypeSearchRequest;
import pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.TransactionServiceTypeConverter;
import pl.corp.kkf.kkf.services.impl.dao.exceptions.dictionaries.TransactionServiceTypeException;
import pl.corp.kkf.kkf.services.impl.dao.repositories.TransactionServiceTypeRepository;
import pl.corp.kkf.kkf.services.impl.dao.validators.dictionaries.TransactionServiceTypeValidator;
import pl.corp.kkf.kkf.services.model.TransactionServiceTypeEntity;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.TransactionServiceTypeConverter.toDto;
import static pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.TransactionServiceTypeConverter.toEntity;

@Service
public class TransactionServiceTypeServiceImpl implements TransactionServiceTypeService {

    public static final Supplier<@NotNull TransactionServiceTypeException> TRANSACTION_SERVICE_TYPE_NOT_FOUND_EXCEPTION_SUPPLIER = () -> new TransactionServiceTypeException("Nie znaleziono rodzaju usługi o podanym identyfikatorze");

    @Autowired
    private TransactionServiceTypeRepository transactionServiceTypeRepository;

    @Override
    public TransactionServiceType getTransactionServiceType(long id) {
        TransactionServiceTypeEntity entity = transactionServiceTypeRepository.findById(id)
                .orElseThrow(TRANSACTION_SERVICE_TYPE_NOT_FOUND_EXCEPTION_SUPPLIER);
        return toDto(entity);
    }

    @Override
    public TransactionServiceType createTransactionServiceType(TransactionServiceType serviceType) {
        TransactionServiceTypeValidator.validateForCreation(serviceType);
        TransactionServiceTypeEntity entity = transactionServiceTypeRepository.save(toEntity(new TransactionServiceTypeEntity(), serviceType));
        return toDto(entity);
    }

    @Override
    public TransactionServiceType updateTransactionServiceType(TransactionServiceType serviceType) {
        TransactionServiceTypeValidator.validateForUpdate(serviceType);
        TransactionServiceTypeEntity entity = transactionServiceTypeRepository.findById(serviceType.getId())
                .orElseThrow(TRANSACTION_SERVICE_TYPE_NOT_FOUND_EXCEPTION_SUPPLIER);
        return toDto(transactionServiceTypeRepository.save(toEntity(entity, serviceType)));
    }

    @Override
    public void archiveTransactionServiceType(long id) {
        TransactionServiceTypeEntity entity = transactionServiceTypeRepository.findById(id)
                .orElseThrow(TRANSACTION_SERVICE_TYPE_NOT_FOUND_EXCEPTION_SUPPLIER);
        TransactionServiceTypeValidator.validateForArchivization(entity.isArchival(), true);
        entity.setArchival(true);
        transactionServiceTypeRepository.save(entity);
    }

    @Override
    public void unarchiveTransactionServiceType(long id) {
        TransactionServiceTypeEntity entity = transactionServiceTypeRepository.findById(id)
                .orElseThrow(TRANSACTION_SERVICE_TYPE_NOT_FOUND_EXCEPTION_SUPPLIER);
        TransactionServiceTypeValidator.validateForArchivization(entity.isArchival(), false);
        entity.setArchival(false);
        transactionServiceTypeRepository.save(entity);
    }

    @Override
    public List<TransactionServiceType> getAllTransactionServiceTypes() {
        List<TransactionServiceTypeEntity> serviceTypeEntities = transactionServiceTypeRepository.findAll();
        return serviceTypeEntities.stream()
                .map(TransactionServiceTypeConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PageDTO<TransactionServiceType> findByCriteria(TransactionServiceTypeSearchRequest request) {
        Pageable pageable = PageUtils.convertTo(request.getPageRequestDTO());
        Specification<TransactionServiceTypeEntity> specification = transactionServiceTypeRepository.getSpecification(request.getCriteria());
        Page<TransactionServiceTypeEntity> transactionServiceTypeEntities = transactionServiceTypeRepository.findAll(specification, pageable);
        return PageUtils.convertTo(transactionServiceTypeEntities.map(TransactionServiceTypeConverter::toDto));
    }
}

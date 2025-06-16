package pl.corp.kkf.kkf.services.impl.service.dictionaries.transactionservices;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.corp.kkf.commons.base.service.rest.PageUtils;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservices.dto.TransactionServiceDto;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservices.dto.TransactionServiceSearchRequest;
import pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.TransactionServiceDictionaryConverter;
import pl.corp.kkf.kkf.services.impl.dao.exceptions.dictionaries.TransactionServiceException;
import pl.corp.kkf.kkf.services.impl.dao.repositories.TransactionServiceRepository;
import pl.corp.kkf.kkf.services.impl.dao.validators.dictionaries.TransactionServiceValidator;
import pl.corp.kkf.kkf.services.model.TransactionServiceEntity;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.TransactionServiceDictionaryConverter.toDto;
import static pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.TransactionServiceDictionaryConverter.toEntity;

@Service
public class TransactionServiceServiceImpl implements TransactionServiceService {

    public static final Supplier<@NotNull TransactionServiceException> TRANSACTION_SERVICE_NOT_FOUND_EXCEPTION_SUPPLIER = () -> new TransactionServiceException("Nie znaleziono szablonu usługi o podanym identyfikatorze");

    @Autowired
    private TransactionServiceRepository transactionServiceRepository;

    @Override
    public TransactionServiceDto getTransactionService(long id) {
        TransactionServiceEntity transactionServiceEntity = transactionServiceRepository.findById(id)
                .orElseThrow(TRANSACTION_SERVICE_NOT_FOUND_EXCEPTION_SUPPLIER);
        return toDto(transactionServiceEntity);
    }

    @Override
    public TransactionServiceDto createTransactionService(TransactionServiceDto transactionService) {
        TransactionServiceValidator.validateForCreation(transactionService);
        TransactionServiceEntity transactionServiceEntity = toEntity(new TransactionServiceEntity(), transactionService);
        return toDto(transactionServiceRepository.save(transactionServiceEntity));
    }

    @Override
    public TransactionServiceDto updateTransactionService(TransactionServiceDto transactionService) {
        TransactionServiceValidator.validateForUpdate(transactionService);
        TransactionServiceEntity entity = transactionServiceRepository.findById(transactionService.getId())
                .orElseThrow(TRANSACTION_SERVICE_NOT_FOUND_EXCEPTION_SUPPLIER);
        return toDto(transactionServiceRepository.save(transactionServiceRepository.save(toEntity(entity, transactionService))));
    }

    @Override
    public void archiveTransactionService(long id) {
        TransactionServiceEntity entity = transactionServiceRepository.findById(id)
                .orElseThrow(TRANSACTION_SERVICE_NOT_FOUND_EXCEPTION_SUPPLIER);
        TransactionServiceValidator.validateForArchivization(entity.getArchival(), true);
        entity.setArchival(true);
        transactionServiceRepository.save(entity);
    }

    @Override
    public void unarchiveTransactionService(long id) {
        TransactionServiceEntity entity = transactionServiceRepository.findById(id)
                .orElseThrow(TRANSACTION_SERVICE_NOT_FOUND_EXCEPTION_SUPPLIER);
        TransactionServiceValidator.validateForArchivization(entity.getArchival(), false);
        entity.setArchival(false);
        transactionServiceRepository.save(entity);
    }

    @Override
    public List<TransactionServiceDto> getAllTransactionServices() {
        List<TransactionServiceEntity> serviceEntities = transactionServiceRepository.findAll();
        return serviceEntities.stream()
                .map(TransactionServiceDictionaryConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PageDTO<TransactionServiceDto> findByCriteria(TransactionServiceSearchRequest request) {
        Pageable pageable = PageUtils.convertTo(request.getPageRequestDTO());
        Specification<TransactionServiceEntity> specification = transactionServiceRepository.getSpecification(request.getCriteria());
        Page<TransactionServiceEntity> transactionServiceEntities = transactionServiceRepository.findAll(specification, pageable);
        return PageUtils.convertTo(transactionServiceEntities.map(TransactionServiceDictionaryConverter::toDto));
    }
}

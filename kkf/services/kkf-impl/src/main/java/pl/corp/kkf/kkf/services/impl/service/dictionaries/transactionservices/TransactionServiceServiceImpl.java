package pl.corp.kkf.kkf.services.impl.service.dictionaries.transactionservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservices.dto.TransactionServiceDto;
import pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.TransactionServiceConverter;
import pl.corp.kkf.kkf.services.impl.dao.repositories.dictionaries.TransactionServiceRepository;
import pl.corp.kkf.kkf.services.model.dictionaries.TransactionServiceEntity;
import java.util.List;
import java.util.stream.Collectors;
import pl.corp.kkf.commons.base.service.PageUtils;
import org.springframework.data.jpa.domain.Specification;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservices.dto.TransactionServiceCriteria;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservices.dto.TransactionServiceSearchRequest;

import pl.corp.kkf.kkf.services.impl.validator.dictionaries.TransactionServiceValidator;

import pl.corp.kkf.commons.base.dao.BusinessException;

@Service
public class TransactionServiceServiceImpl implements TransactionServiceService {

    private final TransactionServiceRepository transactionServiceRepository;
    private final TransactionServiceValidator transactionServiceValidator;

    @Autowired
    public TransactionServiceServiceImpl(TransactionServiceRepository transactionServiceRepository, TransactionServiceValidator transactionServiceValidator) {
        this.transactionServiceRepository = transactionServiceRepository;
        this.transactionServiceValidator = transactionServiceValidator;
    }

    @Override
    public TransactionServiceDto getTransactionService(long id) {
        TransactionServiceEntity transactionServiceEntity = transactionServiceRepository.findById(id)
                .orElseThrow(() -> new BusinessException("TransactionService not found with id: " + id));
        return TransactionServiceConverter.toDto(transactionServiceEntity);
    }

    @Override
    public TransactionServiceDto createTransactionService(TransactionServiceDto transactionService) {
         transactionServiceValidator.validateForCreate(transactionService);
        TransactionServiceEntity transactionServiceEntity = TransactionServiceConverter.toEntity(new TransactionServiceEntity(),transactionService);
        TransactionServiceEntity savedTransactionServiceEntity = transactionServiceRepository.save(transactionServiceEntity);
        return TransactionServiceConverter.toDto(savedTransactionServiceEntity);
    }

    @Override
    public TransactionServiceDto updateTransactionService(TransactionServiceDto transactionService) {
         transactionServiceValidator.validateForUpdate(transactionService);
        TransactionServiceEntity transactionServiceEntity = transactionServiceRepository.findById(transactionService.getId())
                .orElseThrow(() -> new BusinessException("TransactionService not found with id: " + transactionService.getId()));
        TransactionServiceEntity updatedTransactionServiceEntity = transactionServiceRepository.save(TransactionServiceConverter.toEntity(transactionServiceEntity,transactionService));
        return TransactionServiceConverter.toDto(updatedTransactionServiceEntity);
    }

    @Override
    public GeneralResponse archiveTransactionService(long id) {
        TransactionServiceEntity transactionServiceEntity = transactionServiceRepository.findById(id)
                .orElseThrow(() -> new BusinessException("TransactionService not found with id: " + id));
        transactionServiceEntity.setArchival(true);
        transactionServiceRepository.save(transactionServiceEntity);
        return new GeneralResponse();
    }

    @Override
    public GeneralResponse unarchiveTransactionService(long id) {
        TransactionServiceEntity transactionServiceEntity = transactionServiceRepository.findById(id)
                .orElseThrow(() -> new BusinessException("TransactionService not found with id: " + id));
        transactionServiceEntity.setArchival(false);
        transactionServiceRepository.save(transactionServiceEntity);
        return new GeneralResponse();
    }

    @Override
    public List<TransactionServiceDto> getAllTransactionServices() {
        List<TransactionServiceEntity> serviceEntities = transactionServiceRepository.findAll();
        return serviceEntities.stream()
                .map(TransactionServiceConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PageDTO<TransactionServiceDto> findByCriteria(TransactionServiceSearchRequest request) {
        Pageable pageable = PageUtils.convertToPageable(request.getPageRequestDTO());
        Specification<TransactionServiceEntity> specification = transactionServiceRepository.getSpecification(request.getCriteria());
        Page<TransactionServiceEntity> transactionServiceEntities = transactionServiceRepository.findAll(specification, pageable);
        PageDTO<TransactionServiceDto> pageDTO = PageUtils.convertToPageDTO(transactionServiceEntities.map(TransactionServiceConverter::toDto));
        return pageDTO;
    }}

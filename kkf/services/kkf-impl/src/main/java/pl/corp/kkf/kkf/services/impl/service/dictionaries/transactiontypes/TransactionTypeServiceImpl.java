package pl.corp.kkf.kkf.services.impl.service.dictionaries.transactiontypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.dto.TransactionType;
import pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.dto.TransactionTypeSearchRequest;
import pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.TransactionTypeConverter;
import pl.corp.kkf.kkf.services.impl.dao.repositories.dictionaries.TransactionTypeRepository;
import pl.corp.kkf.kkf.services.model.dictionaries.TransactionTypeEntity;
import pl.corp.kkf.commons.base.service.PageUtils;
import pl.corp.kkf.commons.base.dao.BusinessException;
import org.springframework.data.jpa.domain.Specification;
import pl.corp.kkf.kkf.services.impl.validator.dictionaries.TransactionTypeValidator;
import pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.dto.TransactionTypeCriteria;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionTypeServiceImpl implements TransactionTypeService {

    private final TransactionTypeRepository transactionTypeRepository;
     private final TransactionTypeValidator transactionTypeValidator;

    @Autowired
    public TransactionTypeServiceImpl(TransactionTypeRepository transactionTypeRepository, TransactionTypeValidator transactionTypeValidator) {
        this.transactionTypeRepository = transactionTypeRepository;
        this.transactionTypeValidator = transactionTypeValidator;
    }

    @Override
    public TransactionType getTransactionType(long id) {
        TransactionTypeEntity transactionTypeEntity = transactionTypeRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Nie znaleziono typu transakcji o id: " + id));
        return TransactionTypeConverter.toDto(transactionTypeEntity);
    }

    @Override
    public TransactionType createTransactionType(TransactionType transactionType) {
        transactionTypeValidator.validateForCreate(transactionType);
        TransactionTypeEntity transactionTypeEntity = TransactionTypeConverter.toEntity(new TransactionTypeEntity(), transactionType);
        TransactionTypeEntity savedTransactionTypeEntity = transactionTypeRepository.save(transactionTypeEntity);
        return TransactionTypeConverter.toDto(savedTransactionTypeEntity);
    }

    @Override
    public TransactionType updateTransactionType(TransactionType transactionType) {
         transactionTypeValidator.validateForUpdate(transactionType);
        TransactionTypeEntity transactionTypeEntity = transactionTypeRepository.findById(transactionType.getId())
                .orElseThrow(() -> new BusinessException("Nie znaleziono typu transakcji o id: " + transactionType.getId()));
        transactionTypeEntity = TransactionTypeConverter.toEntity(transactionTypeEntity, transactionType);
        TransactionType updatedTransactionTypeEntity = transactionTypeRepository.save(transactionTypeEntity);
        return TransactionTypeConverter.toDto(updatedTransactionTypeEntity);
    }

    @Override
    public GeneralResponse archiveTransactionType(long id) {
        TransactionTypeEntity transactionTypeEntity = transactionTypeRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Nie znaleziono typu transakcji o id: " + id));
        transactionTypeEntity.setArchival(true);
        transactionTypeRepository.save(transactionTypeEntity);
        return new GeneralResponse();
    }

    @Override
    public GeneralResponse unarchiveTransactionType(long id) {
        TransactionTypeEntity transactionTypeEntity = transactionTypeRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Nie znaleziono typu transakcji o id: " + id));
        transactionTypeEntity.setArchival(false);
        transactionTypeRepository.save(transactionTypeEntity);
        return new GeneralResponse();
    }

    @Override
    public List<TransactionType> getAllTransactionTypes() {
        List<TransactionTypeEntity> transactionTypeEntities = transactionTypeRepository.findAll();
        return transactionTypeEntities.stream()
                .map(TransactionTypeConverter::toDto)
                .collect(Collectors.toList());
    }

     @Override
    public PageDTO<TransactionType> findByCriteria(TransactionTypeSearchRequest request) {
        Pageable pageable = PageUtils.convertToPageable(request.getPageRequestDTO());
        Specification<TransactionTypeEntity> specification = transactionTypeRepository.getSpecification(request.getCriteria());
        Page<TransactionTypeEntity> transactionTypeEntities = transactionTypeRepository.findAll(specification, pageable);
        PageDTO<TransactionType> pageDTO = PageUtils.convertToPageDTO(transactionTypeEntities.map(TransactionTypeConverter::toDto));
        return pageDTO;
    }}

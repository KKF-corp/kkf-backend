package pl.corp.kkf.kkf.services.impl.service.dictionaries.transactiontypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.corp.kkf.commons.base.service.rest.PageUtils;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.dto.TransactionType;
import pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.dto.TransactionTypeSearchRequest;
import pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.TransactionTypeConverter;
import pl.corp.kkf.kkf.services.impl.dao.exceptions.dictionaries.TransactionTypeException;
import pl.corp.kkf.kkf.services.impl.dao.repositories.dictionaries.TransactionTypeRepository;
import pl.corp.kkf.kkf.services.impl.dao.validators.dictionaries.TransactionTypeValidator;
import pl.corp.kkf.kkf.services.model.dictionaries.TransactionTypeEntity;

import java.util.List;
import java.util.stream.Collectors;

import static pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.TransactionTypeConverter.toDto;
import static pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.TransactionTypeConverter.toEntity;

@Service
public class TransactionTypeServiceImpl implements TransactionTypeService {

    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    @Override
    public TransactionType getTransactionType(long id) {
        TransactionTypeEntity transactionTypeEntity = transactionTypeRepository.findById(id)
                .orElseThrow(() -> new TransactionTypeException("Nie znaleziono typu transakcji o id: " + id));
        return toDto(transactionTypeEntity);
    }

    @Override
    public TransactionType createTransactionType(TransactionType transactionType) {
        TransactionTypeValidator.validateForCreation(transactionType);
        TransactionTypeEntity entity = toEntity(new TransactionTypeEntity(), transactionType);
        return toDto(transactionTypeRepository.save(entity));
    }

    @Override
    public TransactionType updateTransactionType(TransactionType transactionType) {
        TransactionTypeValidator.validateForUpdate(transactionType);
        TransactionTypeEntity entity = transactionTypeRepository.findById(transactionType.getId())
                .orElseThrow(() -> new TransactionTypeException("Nie znaleziono typu transakcji o id: " + transactionType.getId()));
        return toDto(transactionTypeRepository.save(toEntity(entity, transactionType)));
    }

    @Override
    public void archiveTransactionType(long id) {
        TransactionTypeEntity entity = transactionTypeRepository.findById(id)
                .orElseThrow(() -> new TransactionTypeException("Nie znaleziono typu transakcji o id: " + id));
        TransactionTypeValidator.validateForArchivization(entity.getArchival(), true);
        entity.setArchival(true);
        transactionTypeRepository.save(entity);
    }

    @Override
    public void unarchiveTransactionType(long id) {
        TransactionTypeEntity entity = transactionTypeRepository.findById(id)
                .orElseThrow(() -> new TransactionTypeException("Nie znaleziono typu transakcji o id: " + id));
        TransactionTypeValidator.validateForArchivization(entity.getArchival(), false);
        entity.setArchival(false);
        transactionTypeRepository.save(entity);
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
        Pageable pageable = PageUtils.convertTo(request.getPageRequestDTO());
        Specification<TransactionTypeEntity> specification = transactionTypeRepository.getSpecification(request.getCriteria());
        Page<TransactionTypeEntity> transactionTypeEntities = transactionTypeRepository.findAll(specification, pageable);
        return PageUtils.convertTo(transactionTypeEntities.map(TransactionTypeConverter::toDto));
    }

    @Override
    public boolean existsById(long id) {
        return transactionTypeRepository.existsById(id);
    }
}

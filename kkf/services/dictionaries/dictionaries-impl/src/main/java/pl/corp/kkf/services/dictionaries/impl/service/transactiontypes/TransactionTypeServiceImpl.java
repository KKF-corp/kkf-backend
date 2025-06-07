package pl.corp.kkf.services.dictionaries.impl.service.transactiontypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.services.dictionaries.api.transactiontypes.dto.TransactionType;
import pl.corp.kkf.services.dictionaries.impl.dao.converters.TransactionTypeConverter;
import pl.corp.kkf.services.dictionaries.impl.dao.repositories.TransactionTypeRepository;
import pl.corp.kkf.services.dictionaries.model.TransactionTypeEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionTypeServiceImpl implements TransactionTypeService {

    private final TransactionTypeRepository transactionTypeRepository;

    @Autowired
    public TransactionTypeServiceImpl(TransactionTypeRepository transactionTypeRepository) {
        this.transactionTypeRepository = transactionTypeRepository;
    }

    @Override
    public TransactionType getTransactionType(Long id) {
        TransactionTypeEntity transactionTypeEntity = transactionTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransactionType not found with id: " + id));
        return TransactionTypeConverter.toDto(transactionTypeEntity);
    }

    @Override
    public TransactionType createTransactionType(TransactionType transactionType) {
        TransactionTypeEntity transactionTypeEntity = TransactionTypeConverter.toEntity(transactionType);
        TransactionTypeEntity savedTransactionTypeEntity = transactionTypeRepository.save(transactionTypeEntity);
        return TransactionTypeConverter.toDto(savedTransactionTypeEntity);
    }

    @Override
    public TransactionType updateTransactionType(TransactionType transactionType) {
        TransactionTypeEntity transactionTypeEntity = TransactionTypeConverter.toEntity(transactionType);
        TransactionTypeEntity updatedTransactionTypeEntity = transactionTypeRepository.save(transactionTypeEntity);
        return TransactionTypeConverter.toDto(updatedTransactionTypeEntity);
    }

    @Override
    public void archiveTransactionType(Long id) {
        TransactionTypeEntity transactionTypeEntity = transactionTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransactionType not found with id: " + id));
        transactionTypeEntity.setArchival(true);
        transactionTypeRepository.save(transactionTypeEntity);
    }

    @Override
    public void unarchiveTransactionType(Long id) {
        TransactionTypeEntity transactionTypeEntity = transactionTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransactionType not found with id: " + id));
        transactionTypeEntity.setArchival(false);
        transactionTypeRepository.save(transactionTypeEntity);
    }

    @Override
    public List<TransactionType> getAllTransactionTypes() {
        List<TransactionTypeEntity> transactionTypeEntities = transactionTypeRepository.findAll();
        return transactionTypeEntities.stream()
                .map(TransactionTypeConverter::toDto)
                .collect(Collectors.toList());
    }
}
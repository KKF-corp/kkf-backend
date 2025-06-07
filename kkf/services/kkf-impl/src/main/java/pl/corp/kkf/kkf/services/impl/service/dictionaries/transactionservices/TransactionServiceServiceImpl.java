package pl.corp.kkf.kkf.services.impl.service.dictionaries.transactionservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservices.dto.TransactionServiceDto;
import pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.TransactionServiceDictionaryConverter;
import pl.corp.kkf.kkf.services.impl.dao.repositories.dictionaries.TransactionServiceRepository;
import pl.corp.kkf.kkf.services.model.dictionaries.TransactionServiceEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceServiceImpl implements TransactionServiceService {

    private final TransactionServiceRepository transactionServiceRepository;

    @Autowired
    public TransactionServiceServiceImpl(TransactionServiceRepository transactionServiceRepository) {
        this.transactionServiceRepository = transactionServiceRepository;
    }

    @Override
    public TransactionServiceDto getTransactionService(long id) {
        TransactionServiceEntity transactionServiceEntity = transactionServiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransactionServiceDto not found with id: " + id));
        return TransactionServiceDictionaryConverter.toDto(transactionServiceEntity);
    }

    @Override
    public TransactionServiceDto createTransactionService(TransactionServiceDto transactionService) {
        TransactionServiceEntity transactionServiceEntity = TransactionServiceDictionaryConverter.toEntity(transactionService);
        TransactionServiceEntity savedTransactionServiceEntity = transactionServiceRepository.save(transactionServiceEntity);
        return TransactionServiceDictionaryConverter.toDto(savedTransactionServiceEntity);
    }

    @Override
    public TransactionServiceDto updateTransactionService(TransactionServiceDto transactionService) {
        TransactionServiceEntity transactionServiceEntity = TransactionServiceDictionaryConverter.toEntity(transactionService);
        TransactionServiceEntity updatedTransactionServiceEntity = transactionServiceRepository.save(transactionServiceEntity);
        return TransactionServiceDictionaryConverter.toDto(updatedTransactionServiceEntity);
    }

    @Override
    public void archiveTransactionService(long id) {
        TransactionServiceEntity transactionServiceEntity = transactionServiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransactionServiceDto not found with id: " + id));
        transactionServiceEntity.setArchival(true);
        transactionServiceRepository.save(transactionServiceEntity);
    }

    @Override
    public void unarchiveTransactionService(long id) {
        TransactionServiceEntity transactionServiceEntity = transactionServiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransactionServiceDto not found with id: " + id));
        transactionServiceEntity.setArchival(false);
        transactionServiceRepository.save(transactionServiceEntity);
    }

    @Override
    public List<TransactionServiceDto> getAllTransactionServices() {
        List<TransactionServiceEntity> serviceEntities = transactionServiceRepository.findAll();
        return serviceEntities.stream()
                .map(TransactionServiceDictionaryConverter::toDto)
                .collect(Collectors.toList());
    }
}
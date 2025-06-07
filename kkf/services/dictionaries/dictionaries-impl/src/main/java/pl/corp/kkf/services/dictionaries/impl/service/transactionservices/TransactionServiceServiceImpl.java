package pl.corp.kkf.services.dictionaries.impl.service.transactionservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.services.dictionaries.api.transactionservices.dto.TransactionServiceDto;
import pl.corp.kkf.services.dictionaries.impl.dao.converters.TransactionServiceConverter;
import pl.corp.kkf.services.dictionaries.impl.dao.repositories.TransactionServiceRepository;
import pl.corp.kkf.services.dictionaries.model.TransactionServiceEntity;

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
    public TransactionServiceDto getTransactionService(Long id) {
        TransactionServiceEntity transactionServiceEntity = transactionServiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransactionServiceDto not found with id: " + id));
        return TransactionServiceConverter.toDto(transactionServiceEntity);
    }

    @Override
    public TransactionServiceDto createTransactionService(TransactionServiceDto transactionService) {
        TransactionServiceEntity transactionServiceEntity = TransactionServiceConverter.toEntity(transactionService);
        TransactionServiceEntity savedTransactionServiceEntity = transactionServiceRepository.save(transactionServiceEntity);
        return TransactionServiceConverter.toDto(savedTransactionServiceEntity);
    }

    @Override
    public TransactionServiceDto updateTransactionService(TransactionServiceDto transactionService) {
        TransactionServiceEntity transactionServiceEntity = TransactionServiceConverter.toEntity(transactionService);
        TransactionServiceEntity updatedTransactionServiceEntity = transactionServiceRepository.save(transactionServiceEntity);
        return TransactionServiceConverter.toDto(updatedTransactionServiceEntity);
    }

    @Override
    public void archiveTransactionService(Long id) {
        TransactionServiceEntity transactionServiceEntity = transactionServiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransactionServiceDto not found with id: " + id));
        transactionServiceEntity.setArchival(true);
        transactionServiceRepository.save(transactionServiceEntity);
    }

    @Override
    public void unarchiveTransactionService(Long id) {
        TransactionServiceEntity transactionServiceEntity = transactionServiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransactionServiceDto not found with id: " + id));
        transactionServiceEntity.setArchival(false);
        transactionServiceRepository.save(transactionServiceEntity);
    }

    @Override
    public List<TransactionServiceDto> getAllTransactionServices() {
        List<TransactionServiceEntity> serviceEntities = transactionServiceRepository.findAll();
        return serviceEntities.stream()
                .map(TransactionServiceConverter::toDto)
                .collect(Collectors.toList());
    }
}
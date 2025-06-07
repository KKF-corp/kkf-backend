package pl.corp.kkf.kkf.services.impl.service.transactionservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.kkf.services.api.transactionservices.dto.TransactionServiceDto;
import pl.corp.kkf.kkf.services.impl.dao.converters.TransactionServiceConverter;
import pl.corp.kkf.kkf.services.impl.dao.repositories.TransactionServiceRepository;
import pl.corp.kkf.kkf.services.model.TransactionServiceEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceServiceImpl implements TransactionServiceService {

    private final TransactionServiceRepository serviceRepository;

    @Autowired
    public TransactionServiceServiceImpl(TransactionServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public TransactionServiceDto getTransactionService(long id) {
        TransactionServiceEntity transactionServiceEntity = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransactionServiceDto not found with id: " + id));
        return TransactionServiceConverter.toDto(transactionServiceEntity);
    }

    @Override
    public TransactionServiceDto createTransactionService(TransactionServiceDto transactionService) {
        TransactionServiceEntity transactionServiceEntity = TransactionServiceConverter.toEntity(transactionService);
        TransactionServiceEntity savedServiceEntity = serviceRepository.save(transactionServiceEntity);
        return TransactionServiceConverter.toDto(savedServiceEntity);
    }

    @Override
    public TransactionServiceDto updateTransactionService(TransactionServiceDto transactionService) {
        TransactionServiceEntity transactionServiceEntity = TransactionServiceConverter.toEntity(transactionService);
        TransactionServiceEntity updatedServiceEntity = serviceRepository.save(transactionServiceEntity);
        return TransactionServiceConverter.toDto(updatedServiceEntity);
    }

    @Override
    public void archiveTransactionService(long id) {
        TransactionServiceEntity transactionServiceEntity = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransactionServiceDto not found with id: " + id));
        transactionServiceEntity.setArchival(true);
        serviceRepository.save(transactionServiceEntity);
    }

    @Override
    public void unarchiveTransactionService(long id) {
        TransactionServiceEntity transactionServiceEntity = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransactionServiceDto not found with id: " + id));
        transactionServiceEntity.setArchival(false);
        serviceRepository.save(transactionServiceEntity);
    }

    @Override
    public List<TransactionServiceDto> getAllTransactionServices() {
        List<TransactionServiceEntity> serviceEntities = serviceRepository.findAll();
        return serviceEntities.stream()
                .map(TransactionServiceConverter::toDto)
                .collect(Collectors.toList());
    }
}
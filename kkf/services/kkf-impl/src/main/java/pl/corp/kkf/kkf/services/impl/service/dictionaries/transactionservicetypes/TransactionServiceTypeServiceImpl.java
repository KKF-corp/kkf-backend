package pl.corp.kkf.kkf.services.impl.service.dictionaries.transactionservicetypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.kkf.services.api.dictionaries.servicetypes.dto.TransactionServiceType;
import pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.ServiceTypeConverter;
import pl.corp.kkf.kkf.services.impl.dao.repositories.dictionaries.TransactionServiceTypeRepository;
import pl.corp.kkf.kkf.services.model.dictionaries.TransactionServiceTypeEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceTypeServiceImpl implements TransactionServiceTypeService {

    private final TransactionServiceTypeRepository transactionServiceTypeRepository;

    @Autowired
    public TransactionServiceTypeServiceImpl(TransactionServiceTypeRepository transactionServiceTypeRepository) {
        this.transactionServiceTypeRepository = transactionServiceTypeRepository;
    }

    @Override
    public TransactionServiceType getTransactionServiceType(long id) {
        TransactionServiceTypeEntity TransactionServiceTypeEntity = transactionServiceTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransactionServiceType not found with id: " + id));
        return ServiceTypeConverter.toDto(TransactionServiceTypeEntity);
    }

    @Override
    public TransactionServiceType createTransactionServiceType(TransactionServiceType serviceType) {
        TransactionServiceTypeEntity TransactionServiceTypeEntity = ServiceTypeConverter.toEntity(serviceType);
        TransactionServiceTypeEntity savedTransactionServiceTypeEntity = transactionServiceTypeRepository.save(TransactionServiceTypeEntity);
        return ServiceTypeConverter.toDto(savedTransactionServiceTypeEntity);
    }

    @Override
    public TransactionServiceType updateTransactionServiceType(TransactionServiceType serviceType) {
        TransactionServiceTypeEntity TransactionServiceTypeEntity = ServiceTypeConverter.toEntity(serviceType);
        TransactionServiceTypeEntity updatedTransactionServiceTypeEntity = transactionServiceTypeRepository.save(TransactionServiceTypeEntity);
        return ServiceTypeConverter.toDto(updatedTransactionServiceTypeEntity);
    }

    @Override
    public void archiveTransactionServiceType(long id) {
        TransactionServiceTypeEntity TransactionServiceTypeEntity = transactionServiceTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransactionServiceType not found with id: " + id));
        TransactionServiceTypeEntity.setArchival(true);
        transactionServiceTypeRepository.save(TransactionServiceTypeEntity);
    }

    @Override
    public void unarchiveTransactionServiceType(long id) {
        TransactionServiceTypeEntity TransactionServiceTypeEntity = transactionServiceTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransactionServiceType not found with id: " + id));
        TransactionServiceTypeEntity.setArchival(false);
        transactionServiceTypeRepository.save(TransactionServiceTypeEntity);
    }

    @Override
    public List<TransactionServiceType> getAllTransactionServiceTypes() {
        List<TransactionServiceTypeEntity> serviceTypeEntities = transactionServiceTypeRepository.findAll();
        return serviceTypeEntities.stream()
                .map(ServiceTypeConverter::toDto)
                .collect(Collectors.toList());
    }
}
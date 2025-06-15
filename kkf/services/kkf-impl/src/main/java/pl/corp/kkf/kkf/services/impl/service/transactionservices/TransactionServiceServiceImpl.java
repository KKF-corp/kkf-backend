package pl.corp.kkf.kkf.services.impl.service.transactionservices;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.kkf.services.api.transactionservices.dto.RevenueServiceDto;
import pl.corp.kkf.kkf.services.api.transactionservices.dto.TransactionServiceDto;
import pl.corp.kkf.kkf.services.impl.dao.exceptions.TransactionServiceException;
import pl.corp.kkf.kkf.services.impl.dao.repositories.TransactionServiceRepository;
import pl.corp.kkf.kkf.services.model.ExpenseTransactionServiceEntity;
import pl.corp.kkf.kkf.services.model.RevenueTransactionServiceEntity;
import pl.corp.kkf.kkf.services.model.TransactionServiceEntity;

import java.util.List;
import java.util.function.Supplier;

import static pl.corp.kkf.kkf.services.impl.dao.converters.TransactionServiceConverter.toDto;
import static pl.corp.kkf.kkf.services.impl.dao.converters.TransactionServiceConverter.toEntity;

@Service
public class TransactionServiceServiceImpl implements TransactionServiceService {

    public static final Supplier<@NotNull TransactionServiceException> TRANSACTION_SERVICE_NOT_FOUND_EXCEPTION_SUPPLIER = () -> new TransactionServiceException("Nie znaleziono pozycji o podanym identyfikatorze");

    private final TransactionServiceRepository serviceRepository;

    @Autowired
    public TransactionServiceServiceImpl(TransactionServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public TransactionServiceDto getTransactionService(long id) {
        TransactionServiceEntity entity = serviceRepository.findById(id)
                .orElseThrow(TRANSACTION_SERVICE_NOT_FOUND_EXCEPTION_SUPPLIER);
        return toDto(entity, new RevenueServiceDto());
    }

    @Override
    public TransactionServiceDto createRevenueService(TransactionServiceDto transactionService) {
//        TransactionServiceValidator.validateForCreation(transactionService);
        return toDto(serviceRepository.save(toEntity(new RevenueTransactionServiceEntity(), transactionService)), new RevenueServiceDto());
    }

    @Override
    public TransactionServiceDto createExpenseService(TransactionServiceDto transactionService) {
//        TransactionServiceValidator.validateForCreation(transactionService);
        return toDto(serviceRepository.save(toEntity(new ExpenseTransactionServiceEntity(), transactionService)), new RevenueServiceDto());
    }

    @Override
    public TransactionServiceDto updateTransactionService(TransactionServiceDto transactionService) {
//        TransactionServiceValidator.validateForUpdate(transactionService);
        TransactionServiceEntity entity = serviceRepository.findById(transactionService.getId())
                .orElseThrow(TRANSACTION_SERVICE_NOT_FOUND_EXCEPTION_SUPPLIER);
        return toDto(serviceRepository.save(toEntity(entity, transactionService)), new RevenueServiceDto());
    }

    @Override
    public void archiveTransactionService(long id) {
        TransactionServiceEntity entity = serviceRepository.findById(id)
                .orElseThrow(TRANSACTION_SERVICE_NOT_FOUND_EXCEPTION_SUPPLIER);
//        TransactionServiceValidator.validateForArchivization(entity.getArchival(), true);
        entity.setArchival(true);
        serviceRepository.save(entity);
    }

    @Override
    public void unarchiveTransactionService(long id) {
        TransactionServiceEntity entity = serviceRepository.findById(id)
                .orElseThrow(TRANSACTION_SERVICE_NOT_FOUND_EXCEPTION_SUPPLIER);
//        TransactionServiceValidator.validateForArchivization(entity.getArchival(), false);
        entity.setArchival(false);
        serviceRepository.save(entity);
    }

    @Override
    public List<TransactionServiceDto> getAllTransactionServices() {
//        List<TransactionServiceEntity> serviceEntities = serviceRepository.findAll();
//        return serviceEntities.stream()
//                .map(TransactionServiceConverter::toDto)
//                .collect(Collectors.toList());
        return null;
    }
}
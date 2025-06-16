package pl.corp.kkf.kkf.services.impl.service.transactionposition;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.kkf.services.api.transactionservices.dto.RevenuePosition;
import pl.corp.kkf.kkf.services.api.transactionservices.dto.TransactionPosition;
import pl.corp.kkf.kkf.services.impl.dao.exceptions.TransactionPositionException;
import pl.corp.kkf.kkf.services.impl.dao.repositories.TransactionPositionRepository;
import pl.corp.kkf.kkf.services.model.ExpenseTransactionPositionEntity;
import pl.corp.kkf.kkf.services.model.RevenueTransactionPositionEntity;
import pl.corp.kkf.kkf.services.model.TransactionPositionEntity;

import java.util.List;
import java.util.function.Supplier;

import static pl.corp.kkf.kkf.services.impl.dao.converters.TransactionPositionConverter.toDto;
import static pl.corp.kkf.kkf.services.impl.dao.converters.TransactionPositionConverter.toEntity;

@Service
public class TransactionPositionServiceImpl implements TransactionPositionService {

    public static final Supplier<@NotNull TransactionPositionException> TRANSACTION_SERVICE_NOT_FOUND_EXCEPTION_SUPPLIER = () -> new TransactionPositionException("Nie znaleziono pozycji o podanym identyfikatorze");

    @Autowired
    private TransactionPositionRepository serviceRepository;

    @Override
    public TransactionPosition getTransactionService(long id) {
        TransactionPositionEntity entity = serviceRepository.findById(id)
                .orElseThrow(TRANSACTION_SERVICE_NOT_FOUND_EXCEPTION_SUPPLIER);
        return toDto(entity, new RevenuePosition());
    }

    @Override
    public TransactionPosition createRevenueService(TransactionPosition transactionService) {
//        TransactionServiceValidator.validateForCreation(transactionService);
        return toDto(serviceRepository.save(toEntity(new RevenueTransactionPositionEntity(), transactionService)), new RevenuePosition());
    }

    @Override
    public TransactionPosition createExpenseService(TransactionPosition transactionService) {
//        TransactionServiceValidator.validateForCreation(transactionService);
        return toDto(serviceRepository.save(toEntity(new ExpenseTransactionPositionEntity(), transactionService)), new RevenuePosition());
    }

    @Override
    public TransactionPosition updateTransactionService(TransactionPosition transactionService) {
//        TransactionServiceValidator.validateForUpdate(transactionService);
        TransactionPositionEntity entity = serviceRepository.findById(transactionService.getId())
                .orElseThrow(TRANSACTION_SERVICE_NOT_FOUND_EXCEPTION_SUPPLIER);
        return toDto(serviceRepository.save(toEntity(entity, transactionService)), new RevenuePosition());
    }

    @Override
    public void archiveTransactionService(long id) {
        TransactionPositionEntity entity = serviceRepository.findById(id)
                .orElseThrow(TRANSACTION_SERVICE_NOT_FOUND_EXCEPTION_SUPPLIER);
//        TransactionServiceValidator.validateForArchivization(entity.getArchival(), true);
        entity.setArchival(true);
        serviceRepository.save(entity);
    }

    @Override
    public void unarchiveTransactionService(long id) {
        TransactionPositionEntity entity = serviceRepository.findById(id)
                .orElseThrow(TRANSACTION_SERVICE_NOT_FOUND_EXCEPTION_SUPPLIER);
//        TransactionServiceValidator.validateForArchivization(entity.getArchival(), false);
        entity.setArchival(false);
        serviceRepository.save(entity);
    }

    @Override
    public List<TransactionPosition> getAllTransactionServices() {
//        List<TransactionServiceEntity> serviceEntities = serviceRepository.findAll();
//        return serviceEntities.stream()
//                .map(TransactionServiceConverter::toDto)
//                .collect(Collectors.toList());
        return null;
    }
}
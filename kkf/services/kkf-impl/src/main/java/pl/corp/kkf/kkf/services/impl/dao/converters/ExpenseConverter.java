package pl.corp.kkf.kkf.services.impl.dao.converters;

import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.Contractor;
import pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.dto.TransactionType;
import pl.corp.kkf.kkf.services.api.expenses.dto.Expense;
import pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.ContractorConverter;
import pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.TransactionTypeConverter;
import pl.corp.kkf.kkf.services.model.ExpenseEntity;
import pl.corp.kkf.kkf.services.model.dictionaries.ContractorEntity;
import pl.corp.kkf.kkf.services.model.dictionaries.TransactionTypeEntity;

public class ExpenseConverter {

    public static ExpenseEntity toEntity(Expense dto) {
        ExpenseEntity entity = new ExpenseEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setDeleted(dto.getDeleted());
        entity.setPurchaseDate(dto.getPurchaseDate());
        entity.setTotalNetPrice(dto.getTotalNetPrice());
        entity.setTotalGrossPrice(dto.getTotalGrossPrice());

        if (dto.getTransactionType() != null) {
            TransactionTypeEntity transactionTypeEntity = TransactionTypeConverter.toEntity(dto.getTransactionType());
            entity.setTransactionType(transactionTypeEntity);
        }

        if (dto.getContractor() != null) {
            ContractorEntity contractorEntity = ContractorConverter.convertToContractorEntity(dto.getContractor());
            entity.setContractor(contractorEntity);
        }

        return entity;
    }

    public static Expense toDto(ExpenseEntity entity) {
        Expense dto = new Expense();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setDeleted(entity.getDeleted());
        dto.setPurchaseDate(entity.getPurchaseDate());
        dto.setTotalNetPrice(entity.getTotalNetPrice());
        dto.setTotalGrossPrice(entity.getTotalGrossPrice());

        if (entity.getTransactionType() != null) {
            TransactionType transactionTypeDto = TransactionTypeConverter.toDto(entity.getTransactionType());
            dto.setTransactionType(transactionTypeDto);
        }

        if (entity.getContractor() != null) {
            Contractor contractorDto = ContractorConverter.convertToContractor(entity.getContractor());
            dto.setContractor(contractorDto);
        }

        return dto;
    }
}
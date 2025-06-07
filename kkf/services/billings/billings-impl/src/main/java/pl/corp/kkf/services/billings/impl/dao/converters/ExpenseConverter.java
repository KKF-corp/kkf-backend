package pl.corp.kkf.services.billings.impl.dao.converters;

import pl.corp.kkf.services.billings.api.expenses.dto.Expense;
import pl.corp.kkf.services.billings.model.ExpenseEntity;
import pl.corp.kkf.services.dictionaries.impl.dao.converters.TransactionTypeConverter;
import pl.corp.kkf.services.dictionaries.impl.dao.converters.ContractorConverter;
import pl.corp.kkf.services.dictionaries.model.TransactionTypeEntity;
import pl.corp.kkf.services.dictionaries.model.ContractorEntity;

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
            ContractorEntity contractorEntity = ContractorConverter.toEntity(dto.getContractor());
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
            pl.corp.kkf.services.dictionaries.api.transactiontypes.dto.TransactionType transactionTypeDto = TransactionTypeConverter.toDto(entity.getTransactionType());
            dto.setTransactionType(transactionTypeDto);
        }

         if (entity.getContractor() != null) {
            pl.corp.kkf.services.dictionaries.api.contractors.dto.Contractor contractorDto = ContractorConverter.toDto(entity.getContractor());
            dto.setContractor(contractorDto);
        }

        return dto;
    }
}
package pl.corp.kkf.kkf.services.impl.dao.converters;

import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.kkf.services.api.expenses.dto.Expense;
import pl.corp.kkf.kkf.services.api.expenses.dto.ExpenseSearchResponse;
import pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.ContractorConverter;
import pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.TransactionTypeConverter;
import pl.corp.kkf.kkf.services.model.ExpenseEntity;
import pl.corp.kkf.kkf.services.model.dictionaries.ContractorEntity;
import pl.corp.kkf.kkf.services.model.dictionaries.TransactionTypeEntity;

import java.util.Optional;

public class ExpenseConverter {

    public static ExpenseEntity toEntity(ExpenseEntity entity, Expense dto) {
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setDeleted(dto.getDeleted());
        entity.setPurchaseDate(dto.getPurchaseDate());
        entity.setTotalNetPrice(dto.getTotalNetPrice());
        entity.setTotalGrossPrice(dto.getTotalGrossPrice());

        if (dto.getTransactionType() != null) {
            entity.setTransactionType(TransactionTypeConverter.toEntity(Optional.ofNullable(entity.getTransactionType())
                    .orElse(new TransactionTypeEntity()), dto.getTransactionType()));
        }

        if (dto.getContractor() != null) {
            entity.setContractor(ContractorConverter.toEntity(new ContractorEntity(), dto.getContractor()));
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
            dto.setTransactionType(TransactionTypeConverter.toDto(entity.getTransactionType()));
        }

        if (entity.getContractor() != null) {
            dto.setContractor(ContractorConverter.toDto(entity.getContractor()));
        }

        return dto;
    }

    public static ExpenseSearchResponse convertToSearchResponse(PageDTO<Expense> byCriteria) {
        return null;
    }
}
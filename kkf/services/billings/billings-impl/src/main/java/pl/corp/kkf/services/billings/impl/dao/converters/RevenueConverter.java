package pl.corp.kkf.services.billings.impl.dao.converters;

import pl.corp.kkf.services.billings.api.revenues.dto.Revenue;
import pl.corp.kkf.services.billings.model.RevenueEntity;
import pl.corp.kkf.services.dictionaries.impl.dao.converters.TransactionTypeConverter;
import pl.corp.kkf.services.dictionaries.impl.dao.converters.ContractorConverter;
import pl.corp.kkf.services.dictionaries.model.TransactionTypeEntity;
import pl.corp.kkf.services.dictionaries.model.ContractorEntity;

public class RevenueConverter {

    public static RevenueEntity toEntity(Revenue dto) {
        RevenueEntity entity = new RevenueEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setDeleted(dto.getDeleted());
        entity.setSaleDate(dto.getSaleDate());
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

    public static Revenue toDto(RevenueEntity entity) {
        Revenue dto = new Revenue();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setDeleted(entity.getDeleted());
        dto.setSaleDate(entity.getSaleDate());
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
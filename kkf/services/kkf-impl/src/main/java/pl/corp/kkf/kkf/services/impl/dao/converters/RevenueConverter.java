package pl.corp.kkf.kkf.services.impl.dao.converters;

import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.Contractor;
import pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.dto.TransactionType;
import pl.corp.kkf.kkf.services.api.revenues.dto.Revenue;
import pl.corp.kkf.kkf.services.api.revenues.dto.RevenueSearchResponse;
import pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.ContractorConverter;
import pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.TransactionTypeConverter;
import pl.corp.kkf.kkf.services.model.RevenueEntity;
import pl.corp.kkf.kkf.services.model.ContractorEntity;
import pl.corp.kkf.kkf.services.model.TransactionTypeEntity;

import java.util.Optional;

public class RevenueConverter {

    public static RevenueEntity toEntity(RevenueEntity entity, Revenue dto) {
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setDeleted(dto.getDeleted());
        entity.setSaleDate(dto.getSaleDate());
        entity.setTotalNetPrice(dto.getTotalNetPrice());
        entity.setTotalGrossPrice(dto.getTotalGrossPrice());

        if (dto.getTransactionType() != null) {
            entity.setTransactionType(TransactionTypeConverter.toEntity(Optional.ofNullable(entity.getTransactionType())
                    .orElse(new TransactionTypeEntity()), dto.getTransactionType()));
        }

        if (dto.getContractor() != null) {
            ContractorEntity contractorEntity = ContractorConverter.toEntity(Optional.ofNullable(entity.getContractor())
                    .orElse(new ContractorEntity()), dto.getContractor());
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
            TransactionType transactionTypeDto = TransactionTypeConverter.toDto(entity.getTransactionType());
            dto.setTransactionType(transactionTypeDto);
        }

        if (entity.getContractor() != null) {
            Contractor contractorDto = ContractorConverter.toDto(entity.getContractor());
            dto.setContractor(contractorDto);
        }

        return dto;
    }

    public static RevenueSearchResponse convertToSearchResponse(PageDTO<Revenue> byCriteria) {
        return null;
    }
}
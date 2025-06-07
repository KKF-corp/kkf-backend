package pl.corp.kkf.kkf.services.impl.dao.converters;

import pl.corp.kkf.kkf.services.api.dictionaries.servicetypes.dto.TransactionServiceType;
import pl.corp.kkf.kkf.services.api.transactionservices.dto.TransactionServiceDto;
import pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.ServiceTypeConverter;
import pl.corp.kkf.kkf.services.model.RevenueTransactionServiceEntity;
import pl.corp.kkf.kkf.services.model.TransactionServiceEntity;
import pl.corp.kkf.kkf.services.model.dictionaries.TransactionServiceTypeEntity;

public class TransactionServiceConverter {

    public static TransactionServiceEntity toEntity(TransactionServiceDto dto) {
        TransactionServiceEntity entity = new RevenueTransactionServiceEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setDiscount(dto.getDiscount());
        entity.setNetPrice(dto.getNetPrice());
        entity.setGrossPrice(dto.getGrossPrice());
        entity.setVat(dto.getVat());
        entity.setUnit(dto.getUnit());
        entity.setQuantity(dto.getQuantity());
        entity.setArchival(dto.getArchival());

        if (dto.getTransactionServiceType() != null) {
            TransactionServiceTypeEntity serviceTypeEntity = ServiceTypeConverter.toEntity(dto.getTransactionServiceType());
            entity.setTransactionServiceType(serviceTypeEntity);
        }

        return entity;
    }

    public static TransactionServiceDto toDto(TransactionServiceEntity entity) {
        TransactionServiceDto dto = new TransactionServiceDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setDiscount(entity.getDiscount());
        dto.setNetPrice(entity.getNetPrice());
        dto.setGrossPrice(entity.getGrossPrice());
        dto.setVat(entity.getVat());
        dto.setUnit(entity.getUnit());
        dto.setQuantity(entity.getQuantity());
        dto.setArchival(entity.getArchival());

        if (entity.getTransactionServiceType() != null) {
            TransactionServiceType serviceTypeDto = ServiceTypeConverter.toDto(entity.getTransactionServiceType());
            dto.setTransactionServiceType(serviceTypeDto);
        }

        return dto;
    }
}
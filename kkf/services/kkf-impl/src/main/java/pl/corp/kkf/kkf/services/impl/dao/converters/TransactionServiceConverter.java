package pl.corp.kkf.kkf.services.impl.dao.converters;

import pl.corp.kkf.kkf.services.api.dictionaries.transactionservicetypes.dto.TransactionServiceType;
import pl.corp.kkf.kkf.services.api.transactionservices.dto.TransactionServiceDto;
import pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.TransactionServiceTypeConverter;
import pl.corp.kkf.kkf.services.model.TransactionServiceEntity;
import pl.corp.kkf.kkf.services.model.dictionaries.TransactionServiceTypeEntity;

import java.util.Optional;

public class TransactionServiceConverter {

    public static TransactionServiceEntity toEntity(TransactionServiceEntity entity, TransactionServiceDto dto) {
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
            TransactionServiceTypeEntity serviceTypeEntity = TransactionServiceTypeConverter.toEntity(Optional.ofNullable(entity.getTransactionServiceType())
                    .orElse(new TransactionServiceTypeEntity()), dto.getTransactionServiceType());
            entity.setTransactionServiceType(serviceTypeEntity);
        }

        return entity;
    }

    public static TransactionServiceDto toDto(TransactionServiceEntity entity, TransactionServiceDto dto) {
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
            TransactionServiceType serviceTypeDto = TransactionServiceTypeConverter.toDto(entity.getTransactionServiceType());
            dto.setTransactionServiceType(serviceTypeDto);
        }

        return dto;
    }
}
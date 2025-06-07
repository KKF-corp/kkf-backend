package pl.corp.kkf.services.dictionaries.impl.dao.converters;

import pl.corp.kkf.services.dictionaries.api.transactionservices.dto.TransactionServiceDto;
import pl.corp.kkf.services.dictionaries.model.TransactionServiceEntity;

public class TransactionServiceConverter {

    public static TransactionServiceEntity toEntity(TransactionServiceDto dto) {
        TransactionServiceEntity entity = new TransactionServiceEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setArchival(dto.getArchival());
        entity.setDiscount(dto.getDiscount());
        entity.setNetPrice(dto.getNetPrice());
        entity.setGrossPrice(dto.getGrossPrice());
        entity.setVat(dto.getVat());
        entity.setUnit(dto.getUnit());
        entity.setQuantity(dto.getQuantity());
        entity.setServiceType(ServiceTypeConverter.toEntity(dto.getServiceType()));
        return entity;
    }

    public static TransactionServiceDto toDto(TransactionServiceEntity entity) {
        TransactionServiceDto dto = new TransactionServiceDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setArchival(entity.getArchival());
        dto.setDiscount(entity.getDiscount());
        dto.setNetPrice(entity.getNetPrice());
        dto.setGrossPrice(entity.getGrossPrice());
        dto.setVat(entity.getVat());
        dto.setUnit(entity.getUnit());
        dto.setQuantity(entity.getQuantity());
        dto.setServiceType(ServiceTypeConverter.toDto(entity.getServiceType()));
        return dto;
    }
}
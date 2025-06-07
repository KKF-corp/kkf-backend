package pl.corp.kkf.services.billings.impl.dao.converters;

import pl.corp.kkf.services.billings.api.transactionservices.dto.TransactionServiceDto;
import pl.corp.kkf.services.billings.model.TransactionServiceEntity;
import pl.corp.kkf.services.dictionaries.impl.dao.converters.ServiceTypeConverter;
import pl.corp.kkf.services.dictionaries.model.ServiceTypeEntity;

public class TransactionServiceConverter {

    public static TransactionServiceEntity toEntity(TransactionServiceDto dto) {
        TransactionServiceEntity entity = new TransactionServiceEntity();
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

        if (dto.getServiceType() != null) {
            ServiceTypeEntity serviceTypeEntity = ServiceTypeConverter.toEntity(dto.getServiceType());
            entity.setServiceType(serviceTypeEntity);
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

        if (entity.getServiceType() != null) {
            pl.corp.kkf.services.dictionaries.api.servicetypes.dto.ServiceType serviceTypeDto = ServiceTypeConverter.toDto(entity.getServiceType());
            dto.setServiceType(serviceTypeDto);
        }

        return dto;
    }
}
package pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries;

import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservices.dto.TransactionServiceDto;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservices.dto.TransactionServiceSearchResponse;
import pl.corp.kkf.kkf.services.model.dictionaries.TransactionServiceEntity;
import pl.corp.kkf.kkf.services.model.dictionaries.TransactionServiceTypeEntity;

import java.util.Objects;
import java.util.Optional;

public class TransactionServiceDictionaryConverter {

    public static TransactionServiceEntity toEntity(TransactionServiceEntity entity, TransactionServiceDto dto) {
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
        if (Objects.nonNull(dto.getTransactionServiceType())) {
            entity.setTransactionServiceType(TransactionServiceTypeConverter.toEntity(Optional.ofNullable(entity.getTransactionServiceType())
                    .orElse(new TransactionServiceTypeEntity()), dto.getTransactionServiceType()));
        }
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
        dto.setTransactionServiceType(TransactionServiceTypeConverter.toDto(entity.getTransactionServiceType()));
        return dto;
    }

    public static TransactionServiceSearchResponse convertToContractorSearchResponse(PageDTO<TransactionServiceDto> byCriteria) {
        return null;
    }
}
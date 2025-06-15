package pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries;

import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservicetypes.dto.TransactionServiceType;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservicetypes.dto.TransactionServiceTypeSearchResponse;
import pl.corp.kkf.kkf.services.model.dictionaries.TransactionServiceTypeEntity;

public class TransactionServiceTypeConverter {

    public static TransactionServiceTypeEntity toEntity(TransactionServiceTypeEntity entity,TransactionServiceType dto) {
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setArchival(dto.getArchival());
        return entity;
    }

    public static TransactionServiceType toDto(TransactionServiceTypeEntity entity) {
        TransactionServiceType dto = new TransactionServiceType();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setArchival(entity.isArchival());
        return dto;
    }

    public static TransactionServiceTypeSearchResponse convertToSearchResponse(PageDTO<TransactionServiceType> byCriteria) {
        return null;
    }
}
package pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries;

import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.dto.TransactionType;
import pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.dto.TransactionTypeSearchResponse;
import pl.corp.kkf.kkf.services.model.dictionaries.TransactionTypeEntity;

public class TransactionTypeConverter {

    public static TransactionTypeEntity toEntity(TransactionTypeEntity entity, TransactionType dto) {
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setType(dto.getType());
        return entity;
    }

    public static TransactionType toDto(TransactionTypeEntity entity) {
        TransactionType dto = new TransactionType();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setType(entity.getType());
        return dto;
    }

    public static TransactionTypeSearchResponse convertToContractorSearchResponse(PageDTO<TransactionType> byCriteria) {
        return null;
    }
}
package pl.corp.kkf.services.dictionaries.impl.dao.converters;

import pl.corp.kkf.services.dictionaries.api.transactiontypes.dto.TransactionType;
import pl.corp.kkf.services.dictionaries.model.TransactionTypeEntity;

public class TransactionTypeConverter {

    public static TransactionTypeEntity toEntity(TransactionType dto) {
        TransactionTypeEntity entity = new TransactionTypeEntity();
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
}
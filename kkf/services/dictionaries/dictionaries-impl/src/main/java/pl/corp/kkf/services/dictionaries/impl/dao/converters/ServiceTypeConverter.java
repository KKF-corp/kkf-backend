package pl.corp.kkf.services.dictionaries.impl.dao.converters;

import pl.corp.kkf.services.dictionaries.api.servicetypes.dto.ServiceType;
import pl.corp.kkf.services.dictionaries.model.ServiceTypeEntity;

public class ServiceTypeConverter {

    public static ServiceTypeEntity toEntity(ServiceType dto) {
        ServiceTypeEntity entity = new ServiceTypeEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setArchival(dto.getArchival());
        return entity;
    }

    public static ServiceType toDto(ServiceTypeEntity entity) {
        ServiceType dto = new ServiceType();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setArchival(entity.getArchival());
        return dto;
    }
}
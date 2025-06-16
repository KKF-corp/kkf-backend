package pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries;


import pl.corp.kkf.kkf.services.api.dictionaries.addresses.dto.Address;
import pl.corp.kkf.kkf.services.model.AddressEntity;

public class AddressConverter {
    public static Address toDto(AddressEntity entity) {
        Address dto = new Address();
        dto.setId(entity.getId());
        dto.setStreet(entity.getStreet());
        dto.setPostcode(entity.getPostcode());
        dto.setCity(entity.getCity());
        dto.setCountry(entity.getCountry());
        return dto;
    }

    public static AddressEntity toEntity(AddressEntity entity, Address dto) {
        entity.setId(dto.getId());
        entity.setStreet(dto.getStreet());
        entity.setPostcode(dto.getPostcode());
        entity.setCity(dto.getCity());
        entity.setCountry(dto.getCountry());
        return entity;
    }

}

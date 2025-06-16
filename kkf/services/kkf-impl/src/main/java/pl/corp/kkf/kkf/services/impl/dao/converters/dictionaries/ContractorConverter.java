package pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries;

import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.Contractor;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.ContractorListResponse;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.ContractorResponse;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.ContractorSearchResponse;
import pl.corp.kkf.kkf.services.model.AddressEntity;
import pl.corp.kkf.kkf.services.model.ContractorEntity;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ContractorConverter {

    public static Contractor toDto(ContractorEntity entity) {
        Contractor dto = new Contractor();
        dto.setId(entity.getId());
        dto.setContractorType(entity.getContractorType());
        dto.setName(entity.getName());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setDescription(entity.getDescription());
        dto.setArchival(entity.isArchival());
        dto.setNip(entity.getNip());
        dto.setEmail(entity.getEmail());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setBankAccountNumber(entity.getBankAccountNumber());
        dto.setBankName(entity.getBankName());
        dto.setFax(entity.getFax());
        dto.setSwift(entity.getSwift());
        dto.setAddress(AddressConverter.toDto(entity.getAddress()));
        return dto;
    }

    public static ContractorEntity toEntity(ContractorEntity entity, Contractor dto) {
        entity.setId(dto.getId());
        entity.setContractorType(dto.getContractorType());
        entity.setName(dto.getName());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setDescription(dto.getDescription());
        entity.setArchival(dto.getArchival());
        entity.setNip(dto.getNip());
        entity.setEmail(dto.getEmail());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setBankAccountNumber(dto.getBankAccountNumber());
        entity.setBankName(dto.getBankName());
        entity.setFax(dto.getFax());
        entity.setSwift(dto.getSwift());
        if (Objects.nonNull(dto.getAddress())) {
            entity.setAddress(AddressConverter.toEntity(Optional.ofNullable(entity.getAddress())
                    .orElse(new AddressEntity()), dto.getAddress()));
        }
        return entity;
    }

    public static ContractorResponse convertToContractorResponse(Contractor dto) {
        ContractorResponse response = new ContractorResponse();
        response.setContractor(dto);
        return response;
    }

    public static ContractorListResponse convertToContractorListResponse(List<Contractor> contractors) {
        ContractorListResponse response = new ContractorListResponse();
        response.setContractor(contractors);
        return response;
    }

    public static ContractorSearchResponse convertToContractorSearchResponse(PageDTO<Contractor> contractorPageDTO) {
        ContractorSearchResponse response = new ContractorSearchResponse();
        response.setPageDTO(contractorPageDTO);
        return response;
    }
}

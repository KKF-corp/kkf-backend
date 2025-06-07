package pl.corp.kkf.services.dictionaries.impl.dao.converters;

import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.services.dictionaries.api.contractors.dto.Contractor;
import pl.corp.kkf.services.dictionaries.api.contractors.dto.ContractorListResponse;
import pl.corp.kkf.services.dictionaries.api.contractors.dto.ContractorResponse;
import pl.corp.kkf.services.dictionaries.api.contractors.dto.ContractorSearchResponse;
import pl.corp.kkf.services.dictionaries.model.ContractorEntity;

import java.util.List;

public class ContractorConverter {

    public static Contractor convertToContractor(ContractorEntity entity) {
        Contractor dto = new Contractor();
        return dto;
    }

    public static ContractorEntity convertToContractorEntity(Contractor dto) {
        ContractorEntity entity = new ContractorEntity();
        return entity;
    }

    public static ContractorResponse convertToContractorResponse(Contractor dto) {
        ContractorResponse response = new ContractorResponse();
        return response;
    }

    public static ContractorListResponse convertToContractorListResponse(List<Contractor> contractors) {
        ContractorListResponse response = new ContractorListResponse();
        return response;
    }

    public static ContractorSearchResponse convertToContractorSearchResponse(PageDTO<Contractor> contractorPageDTO) {
        ContractorSearchResponse response = new ContractorSearchResponse();
        return response;
    }
}

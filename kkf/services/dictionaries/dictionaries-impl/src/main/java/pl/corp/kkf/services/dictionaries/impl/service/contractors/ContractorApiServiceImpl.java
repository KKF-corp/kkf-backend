package pl.corp.kkf.services.dictionaries.impl.service.contractors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.services.dictionaries.api.contractors.ContractorApiService;
import pl.corp.kkf.services.dictionaries.api.contractors.dto.*;
import pl.corp.kkf.services.dictionaries.impl.dao.converters.ContractorConverter;
import pl.corp.kkf.services.dictionaries.impl.dao.exceptions.ContractorException;

import java.util.List;

@Service
public class ContractorApiServiceImpl implements ContractorApiService {

    @Autowired
    private ContractorService contractorService;

    @Override
    public ContractorResponse getContractor(long id) {
        try {
            Contractor contractor = contractorService.getContractor(id);
            return ContractorConverter.convertToContractorResponse(contractor);
        } catch (ContractorException e) {
            throw new ContractorException();
        }
    }

    @Override
    public ContractorResponse createContractor(Contractor dto) {
        try {
            Contractor contractor = contractorService.createContractor(dto);
            return ContractorConverter.convertToContractorResponse(contractor);
        } catch (ContractorException e) {
            throw new ContractorException();
        }
    }

    @Override
    public ContractorResponse updateContractor(Contractor dto) {
        try {
            Contractor contractor = contractorService.updateContractor(dto);
            return ContractorConverter.convertToContractorResponse(contractor);
        } catch (ContractorException e) {
            throw new ContractorException();
        }
    }

    @Override
    public GeneralResponse archiveContractor(long id) {
        try {
            return contractorService.archiveContractor(id);
        } catch (ContractorException e) {
            throw new ContractorException();
        }
    }

    @Override
    public GeneralResponse unarchiveContractor(long id) {
        try {
            return contractorService.unarchiveContractor(id);
        } catch (ContractorException e) {
            throw new ContractorException();
        }
    }

    @Override
    public ContractorListResponse getAllContractors() {
        try {
            List<Contractor> allContractors = contractorService.getAllContractors();
            return ContractorConverter.convertToContractorListResponse(allContractors);
        } catch (ContractorException e) {
            throw new ContractorException();
        }
    }

    @Override
    public ContractorSearchResponse findByCriteria(ContractorSearchRequest request) {
        try {
            return contractorService.findByCriteria(request);
        } catch (ContractorException e) {
            throw new ContractorException();
        }
    }
}

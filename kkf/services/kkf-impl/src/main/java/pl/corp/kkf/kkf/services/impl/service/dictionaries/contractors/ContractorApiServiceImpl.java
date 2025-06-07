package pl.corp.kkf.kkf.services.impl.service.dictionaries.contractors;

import jdk.internal.joptsimple.internal.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.ContractorApiService;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.*;
import pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.ContractorConverter;
import pl.corp.kkf.kkf.services.impl.dao.exceptions.dictionaries.ContractorException;

import java.util.List;

@Service
public class ContractorApiServiceImpl implements ContractorApiService {

    @Autowired
    private ContractorService contractorService;

    @Override
    public Contractor getContractor(long id) {
        try {
            Contractor contractor = contractorService.getContractor(id);
            return contractor;
        } catch (ContractorException e) {
            throw new ContractorException(Strings.EMPTY);
        }
    }

    @Override
    public Contractor createContractor(Contractor dto) {
        try {
            Contractor contractor = contractorService.createContractor(dto);
            return contractor;
        } catch (ContractorException e) {
            throw new ContractorException(Strings.EMPTY);
        }
    }

    @Override
    public Contractor updateContractor(Contractor dto) {
        try {
            Contractor contractor = contractorService.updateContractor(dto);
            return contractor;
        } catch (ContractorException e) {
            throw new ContractorException(Strings.EMPTY);
        }
    }

    @Override
    public GeneralResponse archiveContractor(long id) {
        try {
            return contractorService.archiveContractor(id);
        } catch (ContractorException e) {
            throw new ContractorException(Strings.EMPTY);
        }
    }

    @Override
    public GeneralResponse unarchiveContractor(long id) {
        try {
            return contractorService.unarchiveContractor(id);
        } catch (ContractorException e) {
            throw new ContractorException(Strings.EMPTY);
        }
    }

    @Override
    public List<Contractor> getAllContractors() {
        try {
            List<Contractor> allContractors = contractorService.getAllContractors();
            return allContractors;
        } catch (ContractorException e) {
            throw new ContractorException(Strings.EMPTY);
        }
    }

    @Override
    public ContractorSearchResponse findByCriteria(ContractorSearchRequest request) {
        try {
            PageDTO<Contractor> byCriteria = contractorService.findByCriteria(request);
            return ContractorConverter.convertToContractorSearchResponse(byCriteria);
        } catch (ContractorException e) {
            throw new ContractorException(Strings.EMPTY);
        }
    }
}

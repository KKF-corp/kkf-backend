package pl.corp.kkf.kkf.services.impl.service.dictionaries.contractors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.ContractorApiService;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.Contractor;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.ContractorSearchRequest;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.ContractorSearchResponse;
import pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.ContractorConverter;
import pl.corp.kkf.kkf.services.impl.dao.exceptions.dictionaries.ContractorException;

import java.util.List;

@Service
public class ContractorApiServiceImpl implements ContractorApiService {

    public static final String ERROR_DURING_CONTRACTOR_OPERATION = "Wystąpił błąd podczas %s kontrahenta: %s";
    public static final String ERROR_DURING_MULTIPLE_CONTRACTORS_OPERATION = "Wystąpił błąd podczas %s kontrahentów: %s";

    @Autowired
    private ContractorService contractorService;

    @Override
    public Contractor getContractor(long id) {
        try {
            return contractorService.getContractor(id);
        } catch (ContractorException e) {
            throw new ContractorException(String.format(ERROR_DURING_CONTRACTOR_OPERATION, "pobierania", e.getMessage()));
        }
    }

    @Override
    public Contractor createContractor(Contractor dto) {
        try {
            return contractorService.createContractor(dto);
        } catch (ContractorException e) {
            throw new ContractorException(String.format(ERROR_DURING_CONTRACTOR_OPERATION, "tworzenia", e.getMessage()));
        }
    }

    @Override
    public Contractor updateContractor(Contractor dto) {
        try {
            return contractorService.updateContractor(dto);
        } catch (ContractorException e) {
            throw new ContractorException(String.format(ERROR_DURING_CONTRACTOR_OPERATION, "modyfikacji", e.getMessage()));
        }
    }

    @Override
    public GeneralResponse archiveContractor(long id) {
        try {
            return contractorService.archiveContractor(id);
        } catch (ContractorException e) {
            throw new ContractorException(String.format(ERROR_DURING_CONTRACTOR_OPERATION, "archiwizacji", e.getMessage()));
        }
    }

    @Override
    public GeneralResponse unarchiveContractor(long id) {
        try {
            return contractorService.unarchiveContractor(id);
        } catch (ContractorException e) {
            throw new ContractorException(String.format(ERROR_DURING_CONTRACTOR_OPERATION, "aktywacji", e.getMessage()));
        }
    }

    @Override
    public List<Contractor> getAllContractors() {
        try {
            return contractorService.getAllContractors();
        } catch (ContractorException e) {
            throw new ContractorException(String.format(ERROR_DURING_MULTIPLE_CONTRACTORS_OPERATION, "pobierania", e.getMessage()));
        }
    }

    @Override
    public ContractorSearchResponse findByCriteria(ContractorSearchRequest request) {
        try {
            PageDTO<Contractor> byCriteria = contractorService.findByCriteria(request);
            return ContractorConverter.convertToContractorSearchResponse(byCriteria);
        } catch (ContractorException e) {
            throw new ContractorException(String.format(ERROR_DURING_MULTIPLE_CONTRACTORS_OPERATION, "paginacji", e.getMessage()));
        }
    }
}

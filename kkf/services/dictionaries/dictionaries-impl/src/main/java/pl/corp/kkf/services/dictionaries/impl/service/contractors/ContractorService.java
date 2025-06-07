package pl.corp.kkf.services.dictionaries.impl.service.contractors;

import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.services.dictionaries.api.contractors.dto.Contractor;
import pl.corp.kkf.services.dictionaries.api.contractors.dto.ContractorSearchRequest;
import pl.corp.kkf.services.dictionaries.api.contractors.dto.ContractorSearchResponse;

import java.util.List;

public interface ContractorService {

    Contractor getContractor(long id);

    Contractor createContractor(Contractor contractor);

    Contractor updateContractor(Contractor contractor);

    GeneralResponse archiveContractor(long id);

    GeneralResponse unarchiveContractor(long id);

    List<Contractor> getAllContractors();

    ContractorSearchResponse findByCriteria(ContractorSearchRequest request);
}

package pl.corp.kkf.kkf.services.impl.service.dictionaries.contractors;

import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.Contractor;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.ContractorSearchRequest;

import java.util.List;

public interface ContractorService {

    Contractor getContractor(long id);

    Contractor createContractor(Contractor contractor);

    Contractor updateContractor(Contractor contractor);

    void archiveContractor(long id);

    void unarchiveContractor(long id);

    List<Contractor> getAllContractors();

    PageDTO<Contractor> findByCriteria(ContractorSearchRequest request);

    boolean existsById(long id);
}

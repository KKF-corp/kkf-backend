package pl.corp.kkf.services.dictionaries.impl.service.contractors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.services.dictionaries.api.contractors.dto.Contractor;
import pl.corp.kkf.services.dictionaries.api.contractors.dto.ContractorSearchRequest;
import pl.corp.kkf.services.dictionaries.api.contractors.dto.ContractorSearchResponse;
import pl.corp.kkf.services.dictionaries.impl.dao.repositories.ContractorRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractorServiceImpl implements ContractorService {

    @Autowired
    private ContractorRepository contractorRepository;

    @Override
    public Contractor getContractor(long id) {
        return null;
    }

    @Override
    public Contractor createContractor(Contractor contractor) {
        return null;
    }

    @Override
    public Contractor updateContractor(Contractor contractor) {
        return null;
    }

    @Override
    public GeneralResponse archiveContractor(long id) {
        return null;
    }

    @Override
    public GeneralResponse unarchiveContractor(long id) {
        return null;
    }

    @Override
    public List<Contractor> getAllContractors() {
        return new ArrayList<>();
    }

    @Override
    public ContractorSearchResponse findByCriteria(ContractorSearchRequest request) {
        return null;
    }
}

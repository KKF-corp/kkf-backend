package pl.corp.kkf.kkf.services.impl.service.dictionaries.contractors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.Contractor;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.ContractorSearchRequest;
import pl.corp.kkf.kkf.services.impl.dao.repositories.dictionaries.ContractorRepository;

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
    public PageDTO<Contractor> findByCriteria(ContractorSearchRequest request) {
        return null;
    }
}

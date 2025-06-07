package pl.corp.kkf.kkf.services.impl.service.dictionaries.contractors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.Contractor;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.ContractorSearchRequest;
import pl.corp.kkf.kkf.services.impl.dao.repositories.dictionaries.ContractorRepository;
import pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.ContractorConverter;
import pl.corp.kkf.commons.base.service.PageUtils;
import pl.corp.kkf.kkf.services.model.dictionaries.ContractorEntity;
import org.springframework.data.jpa.domain.Specification;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.ContractorCriteria;

import java.util.List;
import java.util.stream.Collectors;

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
        Pageable pageable = PageUtils.convertToPageable(request.getPageRequestDTO());
        Specification<ContractorEntity> specification = contractorRepository.getSpecification(request.getCriteria());
        Page<ContractorEntity> contractorEntities = contractorRepository.findAll(specification, pageable);

        PageDTO<Contractor> pageDTO = PageUtils.convertToPageDTO(contractorEntities.map(ContractorConverter::toDto));


        return pageDTO;
    }

}

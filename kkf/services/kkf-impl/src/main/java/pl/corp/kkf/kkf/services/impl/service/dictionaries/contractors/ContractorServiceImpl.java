package pl.corp.kkf.kkf.services.impl.service.dictionaries.contractors;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.corp.kkf.commons.base.service.rest.PageUtils;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.Contractor;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.ContractorSearchRequest;
import pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.ContractorConverter;
import pl.corp.kkf.kkf.services.impl.dao.exceptions.dictionaries.ContractorException;
import pl.corp.kkf.kkf.services.impl.dao.repositories.dictionaries.ContractorRepository;
import pl.corp.kkf.kkf.services.impl.dao.validators.dictionaries.ContractorValidator;
import pl.corp.kkf.kkf.services.model.dictionaries.ContractorEntity;

import java.util.List;
import java.util.function.Supplier;

import static pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.ContractorConverter.toDto;
import static pl.corp.kkf.kkf.services.impl.dao.converters.dictionaries.ContractorConverter.toEntity;

@Service
public class ContractorServiceImpl implements ContractorService {

    public static final Supplier<@NotNull ContractorException> CONTRACTOR_NOT_FOUND_EXCEPTION_SUPPLIER = () -> new ContractorException("Nie znaleziono kontrahenta o podanym identyfikatorze");

    @Autowired
    private ContractorRepository contractorRepository;

    @Override
    public Contractor getContractor(long id) {
        return toDto(contractorRepository.findById(id)
                .orElseThrow(CONTRACTOR_NOT_FOUND_EXCEPTION_SUPPLIER));
    }

    @Override
    public Contractor createContractor(Contractor contractor) {
        ContractorValidator.validateForCreation(contractor);
        return toDto(contractorRepository.save(toEntity(new ContractorEntity(), contractor)));
    }

    @Override
    public Contractor updateContractor(Contractor contractor) {
        ContractorValidator.validateForUpdate(contractor);
        ContractorEntity entity = contractorRepository.findById(contractor.getId())
                .orElseThrow(CONTRACTOR_NOT_FOUND_EXCEPTION_SUPPLIER);
        return toDto(contractorRepository.save(toEntity(entity, contractor)));
    }

    @Override
    public void archiveContractor(long id) {
        ContractorEntity entity = contractorRepository.findById(id)
                .orElseThrow(CONTRACTOR_NOT_FOUND_EXCEPTION_SUPPLIER);
        ContractorValidator.validateForArchivization(entity.isArchival(), true);
        entity.setArchival(true);
        contractorRepository.save(entity);
    }

    @Override
    public void unarchiveContractor(long id) {
        ContractorEntity entity = contractorRepository.findById(id)
                .orElseThrow(CONTRACTOR_NOT_FOUND_EXCEPTION_SUPPLIER);
        ContractorValidator.validateForArchivization(entity.isArchival(), false);
        entity.setArchival(false);
        contractorRepository.save(entity);
    }

    @Override
    public List<Contractor> getAllContractors() {
        return contractorRepository.findAll().stream()
                .map(ContractorConverter::toDto)
                .toList();
    }

    @Override
    public PageDTO<Contractor> findByCriteria(ContractorSearchRequest request) {
        Pageable pageable = PageUtils.convertTo(request.getPageRequestDTO());
        Specification<ContractorEntity> specification = contractorRepository.getSpecification(request.getCriteria());
        Page<ContractorEntity> contractorEntities = contractorRepository.findAll(specification, pageable);
        return PageUtils.convertTo(contractorEntities.map(ContractorConverter::toDto));
    }

    @Override
    public boolean existsById(long id) {
        return contractorRepository.existsById(id);
    }

}

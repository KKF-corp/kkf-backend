package pl.corp.kkf.kkf.services.impl.dao.repositories.dictionaries;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.ContractorCriteria;
import pl.corp.kkf.kkf.services.model.dictionaries.ContractorEntity;
import pl.corp.kkf.commons.base.dao.FilterBuilder;

import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaBuilder;

public interface ContractorRepository extends JpaRepository<ContractorEntity, Long>,
        JpaSpecificationExecutor<ContractorEntity> {

    default Specification<ContractorEntity> getSpecification(ContractorCriteria criteria) {
        return (root, query, criteriaBuilder) -> {
            FilterBuilder<ContractorEntity> filterBuilder = new FilterBuilder<>(root, query, criteriaBuilder);

            filterBuilder.like("name", criteria.getFilterByName())
                    .like("firstName", criteria.getFilterByFirstName())
                    .like("lastName", criteria.getFilterByLastName())
                    .like("description", criteria.getFilterByDescription())
                    .equal("archival", criteria.getFilterByArchival())
                    .like("nip", criteria.getFilterByNip())
                    .like("email", criteria.getFilterByEmail())
                    .like("phoneNumber", criteria.getFilterByPhoneNumber())
                    .like("bankAccountNumber", criteria.getFilterByBankAccountNumber())
                    .like("bankName", criteria.getFilterByBankName())
                    .like("fax", criteria.getFilterByFax())
                    .like("swift", criteria.getFilterBySwift());

            if (criteria.getFilterByAddressId() != null) {
                filterBuilder.equal("address.id", criteria.getFilterByAddressId());
            }
             if (criteria.getFilterByContractorType() != null) {
                filterBuilder.equal("contractorType", criteria.getFilterByContractorType());
            }

            return filterBuilder.build().toPredicate(root, query, criteriaBuilder);
        }};

}
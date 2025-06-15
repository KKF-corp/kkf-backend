package pl.corp.kkf.kkf.services.impl.dao.repositories.dictionaries;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.corp.kkf.commons.base.dao.FilterBuilder;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.ContractorCriteria;
import pl.corp.kkf.kkf.services.model.dictionaries.ContractorEntity;


public interface ContractorRepository extends JpaRepository<ContractorEntity, Long>,
        JpaSpecificationExecutor<ContractorEntity> {

    default Specification<ContractorEntity> getSpecification(@NotNull ContractorCriteria criteria) {
        return null;
//        return (root, query, builder) -> new FilterBuilder<ContractorEntity_>(root, query, builder)
//                .equalTo(ContractorEntity_.isArchival, criteria.getFilterByArchival())
//                .build();


//        {
//            FilterBuilder<ContractorEntity> filterBuilder = new FilterBuilder<>(root, query, criteriaBuilder);
//
//            filterBuilder.like("name", criteria.getFilterByName())
//                    .like("firstName", criteria.getFilterByFirstName())
//                    .like("lastName", criteria.getFilterByLastName())
//                    .like("description", criteria.getFilterByDescription())
//                    .equal("archival", criteria.getFilterByArchival())
//                    .like("nip", criteria.getFilterByNip())
//                    .like("email", criteria.getFilterByEmail())
//                    .like("phoneNumber", criteria.getFilterByPhoneNumber())
//                    .like("bankAccountNumber", criteria.getFilterByBankAccountNumber())
//                    .like("bankName", criteria.getFilterByBankName())
//                    .like("fax", criteria.getFilterByFax())
//                    .like("swift", criteria.getFilterBySwift());
//
//            if (criteria.getFilterByAddressId() != null) {
//                filterBuilder.equal("address.id", criteria.getFilterByAddressId());
//            }
//             if (criteria.getFilterByContractorType() != null) {
//                filterBuilder.equal("contractorType", criteria.getFilterByContractorType());
//            }
//
//            return filterBuilder.build().toPredicate(root, query, criteriaBuilder);
//        }};
    }

}
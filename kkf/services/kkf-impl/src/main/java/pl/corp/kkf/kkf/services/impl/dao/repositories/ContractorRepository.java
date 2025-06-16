package pl.corp.kkf.kkf.services.impl.dao.repositories;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.corp.kkf.commons.base.dao.FilterBuilder;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.ContractorCriteria;
import pl.corp.kkf.kkf.services.model.ContractorEntity;


public interface ContractorRepository extends JpaRepository<ContractorEntity, Long>,
        JpaSpecificationExecutor<ContractorEntity> {

    default Specification<ContractorEntity> getSpecification(@NotNull ContractorCriteria criteria) {
        return (root, query, builder) -> new FilterBuilder<>(root, query, builder)
//                .equalTo(ContractorEntity_.name, criteria.getFilterByName())
//                .equalTo(ContractorEntity_.firstName, criteria.getFilterByFirstName())
//                .equalTo(ContractorEntity_.lastName, criteria.getFilterByLastName())
//                .equalTo(ContractorEntity_.archival, criteria.getFilterByArchival())
//                .equalTo(ContractorEntity_.nip, criteria.getFilterByNip())
//                .equalTo(ContractorEntity_.email, criteria.getFilterByEmail())
//                .equalTo(ContractorEntity_.phoneNumber, criteria.getFilterByPhoneNumber())
//                .equalTo(ContractorEntity_.bankAccountNumber, criteria.getFilterByBankAccountNumber())
//                .equalTo(ContractorEntity_.bankName, criteria.getFilterByBankName())
                .build();


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
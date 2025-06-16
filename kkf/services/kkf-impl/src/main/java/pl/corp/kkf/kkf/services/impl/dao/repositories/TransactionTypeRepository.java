package pl.corp.kkf.kkf.services.impl.dao.repositories;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.dto.TransactionTypeCriteria;
import pl.corp.kkf.kkf.services.model.TransactionTypeEntity;


public interface TransactionTypeRepository extends JpaRepository<TransactionTypeEntity, Long>,
        JpaSpecificationExecutor<TransactionTypeEntity> {

    default Specification<TransactionTypeEntity> getSpecification(TransactionTypeCriteria criteria) {
        return null;
    }
}
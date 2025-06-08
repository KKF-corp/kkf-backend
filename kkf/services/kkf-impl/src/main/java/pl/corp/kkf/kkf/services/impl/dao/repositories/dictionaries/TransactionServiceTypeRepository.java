package pl.corp.kkf.kkf.services.impl.dao.repositories.dictionaries;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservicetypes.dto.TransactionServiceTypeCriteria;
import pl.corp.kkf.kkf.services.model.dictionaries.TransactionServiceTypeEntity;


public interface TransactionServiceTypeRepository extends JpaRepository<TransactionServiceTypeEntity, Long>,
        JpaSpecificationExecutor<TransactionServiceTypeEntity> {

    default Specification<TransactionServiceTypeEntity> getSpecification(@NotNull TransactionServiceTypeCriteria criteria) {
        return null;
    }
}
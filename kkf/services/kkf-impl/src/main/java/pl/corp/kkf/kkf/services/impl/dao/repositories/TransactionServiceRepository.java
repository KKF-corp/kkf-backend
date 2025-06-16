package pl.corp.kkf.kkf.services.impl.dao.repositories;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservices.dto.TransactionServiceCriteria;
import pl.corp.kkf.kkf.services.model.TransactionServiceEntity;

public interface TransactionServiceRepository extends JpaRepository<TransactionServiceEntity, Long>,
        JpaSpecificationExecutor<TransactionServiceEntity> {

    default Specification<TransactionServiceEntity> getSpecification(@NotNull TransactionServiceCriteria criteria) {
        return null;
    }
}
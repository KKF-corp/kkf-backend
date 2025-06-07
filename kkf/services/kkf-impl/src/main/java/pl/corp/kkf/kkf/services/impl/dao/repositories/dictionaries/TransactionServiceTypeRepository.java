package pl.corp.kkf.kkf.services.impl.dao.repositories.dictionaries;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.corp.kkf.kkf.services.model.dictionaries.TransactionServiceTypeEntity;

public interface TransactionServiceTypeRepository extends JpaRepository<TransactionServiceTypeEntity, Long> {
}
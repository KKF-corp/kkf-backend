package pl.corp.kkf.kkf.services.impl.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.corp.kkf.kkf.services.model.TransactionServiceEntity;

public interface TransactionServiceRepository extends JpaRepository<TransactionServiceEntity, Long> {
}
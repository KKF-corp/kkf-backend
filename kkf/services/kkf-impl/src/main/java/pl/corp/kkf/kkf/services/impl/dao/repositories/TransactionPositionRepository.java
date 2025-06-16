package pl.corp.kkf.kkf.services.impl.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.corp.kkf.kkf.services.model.TransactionPositionEntity;

public interface TransactionPositionRepository extends JpaRepository<TransactionPositionEntity, Long> {
}
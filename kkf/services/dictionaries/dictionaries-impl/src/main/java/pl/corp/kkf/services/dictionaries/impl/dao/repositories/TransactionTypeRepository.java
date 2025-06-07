package pl.corp.kkf.services.dictionaries.impl.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.corp.kkf.services.dictionaries.model.TransactionTypeEntity;

public interface TransactionTypeRepository extends JpaRepository<TransactionTypeEntity, Long> {
}
package pl.corp.kkf.services.dictionaries.impl.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.corp.kkf.services.dictionaries.model.ServiceTypeEntity;

public interface ServiceTypeRepository extends JpaRepository<ServiceTypeEntity, Long> {
}
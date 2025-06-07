package pl.corp.kkf.services.billings.impl.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.corp.kkf.services.billings.model.services.ServiceEntity;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
}
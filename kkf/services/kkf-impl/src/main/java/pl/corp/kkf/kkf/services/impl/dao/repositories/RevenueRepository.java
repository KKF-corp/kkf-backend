package pl.corp.kkf.kkf.services.impl.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.corp.kkf.kkf.services.model.RevenueEntity;

public interface RevenueRepository extends JpaRepository<RevenueEntity, Long> {
}
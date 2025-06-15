package pl.corp.kkf.kkf.services.impl.dao.repositories;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.corp.kkf.kkf.services.api.revenues.dto.RevenueCriteria;
import pl.corp.kkf.kkf.services.model.RevenueEntity;
import pl.corp.kkf.commons.base.dao.FilterBuilder;

public interface RevenueRepository extends JpaRepository<RevenueEntity, Long>,
        JpaSpecificationExecutor<RevenueEntity> {

     default Specification<RevenueEntity> getSpecification(RevenueCriteria criteria) {
        return (root, query, criteriaBuilder) -> new FilterBuilder<>(root, query, criteriaBuilder)
            .build();
    };
}
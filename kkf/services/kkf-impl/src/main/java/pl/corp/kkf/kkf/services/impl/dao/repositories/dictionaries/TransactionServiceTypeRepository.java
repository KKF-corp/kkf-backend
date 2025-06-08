package pl.corp.kkf.kkf.services.impl.dao.repositories.dictionaries;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.corp.kkf.kkf.services.model.dictionaries.TransactionServiceTypeEntity;
import pl.corp.kkf.kkf.services.api.dictionaries.servicetypes.dto.TransactionServiceTypeCriteria;
import pl.corp.kkf.commons.base.dao.FilterBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaBuilder;


public interface TransactionServiceTypeRepository extends JpaRepository<TransactionServiceTypeEntity, Long>  {

     default Specification<TransactionServiceTypeEntity> getSpecification(TransactionServiceTypeCriteria criteria) {
          return (root, query, criteriaBuilder) -> {
            FilterBuilder<TransactionServiceTypeEntity> filterBuilder = new FilterBuilder<>(root, query, criteriaBuilder);

            filterBuilder.like("name", criteria.getFilterByName())
                    .like("description", criteria.getFilterByDescription())
                    .equal("archival", criteria.getFilterByArchival());

            return filterBuilder.build().toPredicate(root, query, criteriaBuilder);
        }};
}
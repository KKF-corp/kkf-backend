package pl.corp.kkf.kkf.services.impl.dao.repositories.dictionaries;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.corp.kkf.kkf.services.model.dictionaries.TransactionTypeEntity;
import pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.dto.TransactionTypeCriteria;
import pl.corp.kkf.commons.base.dao.FilterBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaBuilder;


public interface TransactionTypeRepository extends JpaRepository<TransactionTypeEntity, Long> {

    default Specification<TransactionTypeEntity> getSpecification(TransactionTypeCriteria criteria) {
        return (root, query, criteriaBuilder) -> {
            FilterBuilder<TransactionTypeEntity> filterBuilder = new FilterBuilder<>(root, query, criteriaBuilder);

            filterBuilder.like("name", criteria.getFilterByName())
                    .like("type", criteria.getFilterByType());

            return filterBuilder.build().toPredicate(root, query, criteriaBuilder);
        }};
}
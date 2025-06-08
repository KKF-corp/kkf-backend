package pl.corp.kkf.kkf.services.impl.dao.repositories;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.corp.kkf.kkf.services.api.expenses.dto.ExpenseCriteria;
import pl.corp.kkf.kkf.services.model.ExpenseEntity;
import pl.corp.kkf.commons.base.dao.FilterBuilder;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long>,
        JpaSpecificationExecutor<ExpenseEntity> {

    default Specification<ExpenseEntity> getSpecification(ExpenseCriteria criteria) {
        return (root, query, criteriaBuilder) -> {
            FilterBuilder<ExpenseEntity> filterBuilder = new FilterBuilder<>(root, query, criteriaBuilder);

            filterBuilder.like("name", criteria.getFilterByName())
                    .like("description", criteria.getFilterByDescription())
                    .equal("deleted", criteria.getFilterByDeleted())
                    .equal("purchaseDate", criteria.getFilterByPurchaseDate())
                    .equal("totalNetPrice", criteria.getFilterByTotalNetPrice())
                    .equal("totalGrossPrice", criteria.getFilterByTotalGrossPrice());
                    
             if (criteria.getFilterByTransactionTypeId() != null) {
                filterBuilder.equal("transactionType.id", criteria.getFilterByTransactionTypeId());
            }

            if (criteria.getFilterByContractorId() != null) {
                filterBuilder.equal("contractor.id", criteria.getFilterByContractorId());
            }

            return filterBuilder.build().toPredicate(root, query, criteriaBuilder);
        }};

}
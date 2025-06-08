package pl.corp.kkf.kkf.services.impl.dao.repositories;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.corp.kkf.kkf.services.api.expenses.dto.ExpenseCriteria;
import pl.corp.kkf.kkf.services.model.ExpenseEntity;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long>,
        JpaSpecificationExecutor<ExpenseEntity> {

    default Specification<ExpenseEntity> getSpecification(@NotNull ExpenseCriteria criteria) {
        return null;
    }
}
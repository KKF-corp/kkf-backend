package pl.corp.kkf.commons.base.dao;

import jakarta.persistence.criteria.AbstractQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.metamodel.SingularAttribute;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

public class FilterBuilder<T> {

    private final List<Predicate> predicates = new ArrayList<>();
    private final Root<T> root;
    private final AbstractQuery<?> query;
    private final CriteriaBuilder criteriaBuilder;

    private void commonEqualTo(SingularAttribute<? super T, ?> field, Object value) {
        if (nonNull(value)) {
            predicates.add(criteriaBuilder.equal(root.get(field), value));
        }
    }

    public FilterBuilder(Root<T> root, AbstractQuery<?> query, CriteriaBuilder criteriaBuilder) {
        this.root = root;
        this.query = query;
        this.criteriaBuilder = criteriaBuilder;
    }

    public FilterBuilder<T> like(String attribute, String value) {
        if (value != null) {
            predicates.add(criteriaBuilder.like(root.get(attribute), "%" + value + "%"));
        }
        return this;
    }

    public FilterBuilder<T> equal(String attribute, Object value) {
        if (value != null) {
            predicates.add(criteriaBuilder.equal(root.get(attribute), value));
        }
        return this;
    }

    public FilterBuilder<T> equalTo(SingularAttribute<? super T, String> field, String value) {
        commonEqualTo(field, value);
        return this;
    }

    public FilterBuilder<T> equalTo(SingularAttribute<? super T, Boolean> field, Boolean value) {
        commonEqualTo(field, value);
        return this;
    }

    public FilterBuilder<T> equalTo(SingularAttribute<? super T, BigDecimal> field, BigDecimal value) {
        commonEqualTo(field, value);
        return this;
    }

    public Predicate build() {
        if (predicates.isEmpty()) {
            return null;
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
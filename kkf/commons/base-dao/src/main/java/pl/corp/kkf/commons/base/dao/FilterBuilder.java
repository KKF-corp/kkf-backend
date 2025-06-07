package pl.corp.kkf.commons.base.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class FilterBuilder<T> {

    private final List<Predicate> predicates = new ArrayList<>();
    private final Root<T> root;
    private final CriteriaQuery<?> query;
    private final CriteriaBuilder criteriaBuilder;

    public FilterBuilder(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
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

    public Specification<T> build() {
        return (root, query, criteriaBuilder) -> {
            if (predicates.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            Predicate[] predicatesArray = predicates.toArray(new Predicate[0]);
            return criteriaBuilder.and(predicatesArray);
        }};
}
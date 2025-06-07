package pl.corp.kkf.kkf.services.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class RevenueTransactionServiceEntity extends TransactionServiceEntity {

    @ManyToOne
    @JoinColumn(name = "REVENUE_ID", referencedColumnName = "ID")
    private RevenueEntity revenue;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RevenueTransactionServiceEntity that = (RevenueTransactionServiceEntity) o;
        return Objects.equals(revenue, that.revenue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), revenue);
    }
}
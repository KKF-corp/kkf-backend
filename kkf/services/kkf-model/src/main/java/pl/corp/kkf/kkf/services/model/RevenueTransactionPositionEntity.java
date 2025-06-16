package pl.corp.kkf.kkf.services.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class RevenueTransactionPositionEntity extends TransactionPositionEntity {

    @ManyToOne
    @JoinColumn(name = "REVENUE_ID", referencedColumnName = "ID")
    private RevenueEntity revenue;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RevenueTransactionPositionEntity that = (RevenueTransactionPositionEntity) o;
        return Objects.equals(revenue, that.revenue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), revenue);
    }
}
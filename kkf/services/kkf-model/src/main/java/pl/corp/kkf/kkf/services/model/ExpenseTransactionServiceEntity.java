package pl.corp.kkf.kkf.services.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Entity
public class ExpenseTransactionServiceEntity extends TransactionServiceEntity {

    @ManyToOne
    @JoinColumn(name = "EXPENSE_ID", referencedColumnName = "ID")
    private ExpenseEntity expense;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ExpenseTransactionServiceEntity that = (ExpenseTransactionServiceEntity) o;
        return Objects.equals(expense, that.expense);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), expense);
    }
}
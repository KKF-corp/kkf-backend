package pl.corp.kkf.kkf.services.model;

import jakarta.persistence.*;
import pl.corp.kkf.commons.base.model.BaseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "EXPENSES", schema = "KKF")
public class ExpenseEntity extends BaseEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceExpenseEntity")
    @SequenceGenerator(name = "SequenceExpenseEntity", schema = "KKF", sequenceName = "SEQ_EXPENSES")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DELETED")
    private boolean deleted;

    @Column(name = "PURCHASE_DATE", nullable = false)
    private LocalDate purchaseDate;

    @Column(name = "TOTAL_NET_PRICE")
    private BigDecimal totalNetPrice;

    @Column(name = "TOTAL_GROSS_PRICE")
    private BigDecimal TotalGrossPrice;

    @ManyToOne
    @JoinColumn(name = "TRANSACTION_TYPE_ID", referencedColumnName = "ID", nullable = false)
    private TransactionTypeEntity transactionType;

    @ManyToOne
    @JoinColumn(name = "CONTRACTOR_ID", referencedColumnName = "ID")
    private ContractorEntity contractor;

    @OneToMany(mappedBy = "expense", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ExpenseTransactionPositionEntity> transactionServices;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getTotalNetPrice() {
        return totalNetPrice;
    }

    public void setTotalNetPrice(BigDecimal totalNetPrice) {
        this.totalNetPrice = totalNetPrice;
    }

    public BigDecimal getTotalGrossPrice() {
        return TotalGrossPrice;
    }

    public void setTotalGrossPrice(BigDecimal totalGrossPrice) {
        TotalGrossPrice = totalGrossPrice;
    }

    public TransactionTypeEntity getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionTypeEntity transactionType) {
        this.transactionType = transactionType;
    }

    public ContractorEntity getContractor() {
        return contractor;
    }

    public void setContractor(ContractorEntity contractor) {
        this.contractor = contractor;
    }

    public Set<ExpenseTransactionPositionEntity> getTransactionServices() {
        return transactionServices;
    }

    public void setTransactionServices(Set<ExpenseTransactionPositionEntity> transactionServices) {
        this.transactionServices = transactionServices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpenseEntity that = (ExpenseEntity) o;
        return Objects.equals(id, that.id)
                && Objects.equals(name, that.name)
                && Objects.equals(description, that.description)
                && Objects.equals(deleted, that.deleted)
                && Objects.equals(purchaseDate, that.purchaseDate)
                && Objects.equals(totalNetPrice, that.totalNetPrice)
                && Objects.equals(TotalGrossPrice, that.TotalGrossPrice)
                && Objects.equals(transactionType, that.transactionType)
                && Objects.equals(contractor, that.contractor)
                && Objects.equals(transactionServices, that.transactionServices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, deleted, purchaseDate, totalNetPrice, TotalGrossPrice,
                transactionType, contractor, transactionServices);
    }
}
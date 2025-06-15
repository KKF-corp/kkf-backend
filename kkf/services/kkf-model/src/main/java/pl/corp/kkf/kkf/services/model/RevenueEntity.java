package pl.corp.kkf.kkf.services.model;

import jakarta.persistence.*;
import pl.corp.kkf.commons.base.model.BaseEntity;
import pl.corp.kkf.kkf.services.model.dictionaries.ContractorEntity;
import pl.corp.kkf.kkf.services.model.dictionaries.TransactionTypeEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "REVENUES", schema = "BILLING")
public class RevenueEntity extends BaseEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceRevenueEntity")
    @SequenceGenerator(name = "SequenceRevenueEntity", schema = "BILLING", sequenceName = "SEQ_REVENUES")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DELETED")
    private Boolean deleted;

    @Column(name = "SALE_DATE")
    private LocalDate saleDate;

    @Column(name = "TOTAL_NET_PRICE")
    private BigDecimal totalNetPrice;

    @Column(name = "TOTAL_GROSS_PRICE")
    private BigDecimal totalGrossPrice;

    @ManyToOne
    @JoinColumn(name = "TRANSACTION_TYPE_ID", referencedColumnName = "ID")
    private TransactionTypeEntity transactionType;

    @ManyToOne
    @JoinColumn(name = "CONTRACTOR_ID", referencedColumnName = "ID")
    private ContractorEntity contractor;

    @OneToMany(mappedBy = "revenue", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<RevenueTransactionServiceEntity> transactionServices;

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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public BigDecimal getTotalNetPrice() {
        return totalNetPrice;
    }

    public void setTotalNetPrice(BigDecimal totalNetPrice) {
        this.totalNetPrice = totalNetPrice;
    }

    public BigDecimal getTotalGrossPrice() {
        return totalGrossPrice;
    }

    public void setTotalGrossPrice(BigDecimal totalGrossPrice) {
        this.totalGrossPrice = totalGrossPrice;
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

    public Set<RevenueTransactionServiceEntity> getTransactionServices() {
        return transactionServices;
    }

    public void setTransactionServices(Set<RevenueTransactionServiceEntity> transactionServices) {
        this.transactionServices = transactionServices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RevenueEntity that = (RevenueEntity) o;
        return Objects.equals(id, that.id)
                && Objects.equals(name, that.name)
                && Objects.equals(description, that.description)
                && Objects.equals(deleted, that.deleted)
                && Objects.equals(saleDate, that.saleDate)
                && Objects.equals(totalNetPrice, that.totalNetPrice)
                && Objects.equals(totalGrossPrice, that.totalGrossPrice)
                && Objects.equals(transactionType, that.transactionType)
                && Objects.equals(contractor, that.contractor)
                && Objects.equals(transactionServices, that.transactionServices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, deleted, saleDate, totalNetPrice, totalGrossPrice,
                transactionType, contractor, transactionServices);
    }
}
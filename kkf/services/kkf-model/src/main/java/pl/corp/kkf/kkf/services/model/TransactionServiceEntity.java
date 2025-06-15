package pl.corp.kkf.kkf.services.model;

import jakarta.persistence.*;
import pl.corp.kkf.commons.base.model.BaseEntity;
import pl.corp.kkf.kkf.services.model.dictionaries.TransactionServiceTypeEntity;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "TRANSACTION_SERVICES_FOR_BILLINGS", schema = "KKF")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class TransactionServiceEntity extends BaseEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceTransactionServiceEntity")
    @SequenceGenerator(name = "SequenceTransactionServiceEntity", schema = "KKF", sequenceName = "SEQ_TRANSACTION_SERVICES_FOR_BILLINGS")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DISCOUNT", nullable = false)
    private BigDecimal discount;

    @Column(name = "NET_PRICE", nullable = false)
    private BigDecimal netPrice;

    @Column(name = "GROSS_PRICE", nullable = false)
    private BigDecimal grossPrice;

    @Column(name = "VAT", nullable = false)
    private BigDecimal vat;

    @Column(name = "UNIT", nullable = false)
    private String unit;

    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "TRANSACTION_SERVICE_TYPE_ID", referencedColumnName = "ID", nullable = false)
    private TransactionServiceTypeEntity transactionServiceType;

    @Column(name = "ARCHIVAL")
    private boolean archival;

    @Enumerated(EnumType.STRING)
    @Column(name = "DTYPE")
    private String dType;

    @ManyToOne
    @JoinColumn(name = "REVENUE_ID", referencedColumnName = "ID")
    private RevenueEntity revenue;

    @ManyToOne
    @JoinColumn(name = "EXPENSE_ID", referencedColumnName = "ID")
    private ExpenseEntity expense;

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

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(BigDecimal netPrice) {
        this.netPrice = netPrice;
    }

    public BigDecimal getGrossPrice() {
        return grossPrice;
    }

    public void setGrossPrice(BigDecimal grossPrice) {
        this.grossPrice = grossPrice;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public TransactionServiceTypeEntity getTransactionServiceType() {
        return transactionServiceType;
    }

    public void setTransactionServiceType(TransactionServiceTypeEntity serviceType) {
        this.transactionServiceType = serviceType;
    }

    public boolean getArchival() {
        return archival;
    }

    public void setArchival(boolean archival) {
        this.archival = archival;
    }

    public String getdType() {
        return dType;
    }

    public void setdType(String dType) {
        this.dType = dType;
    }

    public RevenueEntity getRevenue() {
        return revenue;
    }

    public void setRevenue(RevenueEntity revenue) {
        this.revenue = revenue;
    }

    public ExpenseEntity getExpense() {
        return expense;
    }

    public void setExpense(ExpenseEntity expense) {
        this.expense = expense;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionServiceEntity that = (TransactionServiceEntity) o;
        return Objects.equals(id, that.id)
                && Objects.equals(name, that.name)
                && Objects.equals(description, that.description)
                && Objects.equals(discount, that.discount)
                && Objects.equals(netPrice, that.netPrice)
                && Objects.equals(grossPrice, that.grossPrice)
                && Objects.equals(vat, that.vat)
                && Objects.equals(unit, that.unit)
                && Objects.equals(quantity, that.quantity)
                && Objects.equals(transactionServiceType, that.transactionServiceType)
                && Objects.equals(archival, that.archival)
                && Objects.equals(dType, that.dType)
                && Objects.equals(revenue, that.revenue)
                && Objects.equals(expense, that.expense);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, discount, netPrice, grossPrice, vat, unit, quantity,
                transactionServiceType, archival, dType, revenue, expense);
    }
}
package pl.corp.kkf.services.dictionaries.model;

import jakarta.persistence.*;
import pl.corp.kkf.commons.base.model.BaseEntity;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "SERVICES", schema = "DICTIONARIES")
public class ServiceEntity extends BaseEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceServiceEntity")
    @SequenceGenerator(name = "SequenceServiceEntity", schema = "DICTIONARIES", sequenceName = "SEQ_SERVICES")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ARCHIVAL")
    private Boolean archival;

    @Column(name = "DISCOUNT")
    private BigDecimal discount;

    @Column(name = "NET_PRICE")
    private BigDecimal netPrice;

    @Column(name = "GROSS_PRICE")
    private BigDecimal grossPrice;

    @Column(name = "VAT")
    private BigDecimal vat;

    @Column(name = "UNIT")
    private String unit;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "SERVICE_TYPE_ID")
    private ServiceTypeEntity serviceType;

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

    public Boolean getArchival() {
        return archival;
    }

    public void setArchival(Boolean archival) {
        this.archival = archival;
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

    public ServiceTypeEntity getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceTypeEntity serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceEntity that = (ServiceEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(archival, that.archival) && Objects.equals(discount, that.discount) && Objects.equals(netPrice, that.netPrice) && Objects.equals(grossPrice, that.grossPrice) && Objects.equals(vat, that.vat) && Objects.equals(unit, that.unit) && Objects.equals(quantity, that.quantity) && Objects.equals(serviceType, that.serviceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, archival, discount, netPrice, grossPrice, vat, unit, quantity, serviceType);
    }
}
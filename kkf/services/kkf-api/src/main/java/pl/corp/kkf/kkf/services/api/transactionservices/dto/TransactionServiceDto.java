package pl.corp.kkf.kkf.services.api.transactionservices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.corp.kkf.kkf.services.api.dictionaries.servicetypes.dto.TransactionServiceType;

import java.math.BigDecimal;

@Schema(description = "Wpis dla usługi")
public class TransactionServiceDto {

    @Schema(description = "Identyfikator")
    private long id;

    @Schema(description = "Nazwa")
    private String name;

    @Schema(description = "Opis")
    private String description;

    @Schema(description = "Rabat")
    private BigDecimal discount;

    @Schema(description = "Cena netto")
    private BigDecimal netPrice;

    @Schema(description = "Cena brutto")
    private BigDecimal grossPrice;

    @Schema(description = "VAT")
    private BigDecimal vat;

    @Schema(description = "Jednostka")
    private String unit;

    @Schema(description = "Ilość")
    private Integer quantity;

    @Schema(description = "Typ usługi")
    private TransactionServiceType transactionServiceType;

    @Schema(description = "Wskaźnik czy archiwalny")
    private Boolean archival;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public TransactionServiceType getTransactionServiceType() {
        return transactionServiceType;
    }

    public void setTransactionServiceType(TransactionServiceType transactionServiceType) {
        this.transactionServiceType = transactionServiceType;
    }

    public Boolean getArchival() {
        return archival;
    }

    public void setArchival(Boolean archival) {
        this.archival = archival;
    }
}
package pl.corp.kkf.kkf.services.api.dictionaries.transactionservices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservicetypes.dto.TransactionServiceType;

import java.math.BigDecimal;

@Schema(description = "Wpis dla usługi")
public class TransactionServiceDto {

    @Schema(description = "Identyfikator")
    private Long id;

    @NotNull
    @Size(max = 255)
    @Schema(description = "Nazwa")
    private String name;

    @Size(max = 255)
    @Schema(description = "Opis")
    private String description;

    @Schema(description = "Wskaźnik czy archiwalny")
    private Boolean archival;

    @Schema(description = "Rabat")
    private BigDecimal discount;

    @Schema(description = "Cena netto")
    private BigDecimal netPrice;

    @Schema(description = "Cena brutto")
    private BigDecimal grossPrice;

    @Schema(description = "VAT")
    private BigDecimal vat;

    @Size(max = 10)
    @Schema(description = "Jednostka")
    private String unit;

    @Schema(description = "Ilość")
    private Integer quantity;

    @Schema(description = "Typ usługi")
    private TransactionServiceType transactionServiceType;

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

    public TransactionServiceType getTransactionServiceType() {
        return transactionServiceType;
    }

    public void setTransactionServiceType(TransactionServiceType transactionServiceType) {
        this.transactionServiceType = transactionServiceType;
    }
}
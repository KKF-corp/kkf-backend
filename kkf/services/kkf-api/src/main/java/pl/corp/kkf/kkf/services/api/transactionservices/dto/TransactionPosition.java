package pl.corp.kkf.kkf.services.api.transactionservices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import pl.corp.kkf.kkf.services.api.dictionaries.transactionservicetypes.dto.TransactionServiceType;

import java.math.BigDecimal;

/*@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @Type(value = RevenueServiceDto.class, name = "Revenue"),
        @Type(value = ExpenseServiceDto.class, name = "Expense")
})*/
@Schema(description = "Wpis dla usługi")
public abstract class TransactionPosition {

    @Schema(description = "Identyfikator")
    private Long id;

    @NotNull
    @Size(max = 255)
    @Schema(description = "Nazwa")
    private String name;

    @Schema(description = "Opis")
    private String description;

    @NotNull
    @PositiveOrZero
    @Schema(description = "Rabat")
    private BigDecimal discount;

    @NotNull
    @PositiveOrZero
    @Schema(description = "Cena netto")
    private BigDecimal netPrice;

    @PositiveOrZero
    @Schema(description = "Cena brutto")
    private BigDecimal grossPrice;

    @NotNull
    @PositiveOrZero
    @Schema(description = "VAT")
    private BigDecimal vat;

    @NotNull
    @Size(max = 10)
    @Schema(description = "Jednostka")
    private String unit;

    @NotNull
    @PositiveOrZero
    @Schema(description = "Ilość")
    private Integer quantity;

    @Schema(description = "Typ usługi")
    private TransactionServiceType transactionServiceType;

    @Schema(description = "Wskaźnik czy archiwalny")
    private Boolean archival;

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
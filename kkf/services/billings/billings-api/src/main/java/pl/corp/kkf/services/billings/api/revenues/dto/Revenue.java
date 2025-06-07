package pl.corp.kkf.services.billings.api.revenues.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.corp.kkf.services.dictionaries.api.transactiontypes.dto.TransactionType;
import pl.corp.kkf.services.dictionaries.api.contractors.dto.Contractor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "Wpis dla przychodu")
public class Revenue {

    @Schema(description = "Identyfikator")
    private Long id;

    @Schema(description = "Nazwa")
    private String name;

    @Schema(description = "Opis")
    private String description;

    @Schema(description = "Wskaźnik czy usunięty")
    private Boolean deleted;

    @Schema(description = "Data sprzedaży")
    private LocalDate saleDate;

    @Schema(description = "Cena netto")
    private BigDecimal totalNetPrice;

    @Schema(description = "Cena brutto")
    private BigDecimal totalGrossPrice;

    @Schema(description = "Typ transakcji")
    private TransactionType transactionType;

    @Schema(description = "Kontrahent")
    private Contractor contractor;

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

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }
}
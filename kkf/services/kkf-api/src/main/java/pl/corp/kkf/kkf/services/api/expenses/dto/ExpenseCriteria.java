package pl.corp.kkf.kkf.services.api.expenses.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "Filtr do wyszukiwania wydatków")
public class ExpenseCriteria {

    @Schema(description = "Filtrowanie według nazwy")
    private String filterByName;

    @Schema(description = "Filtrowanie według opisu")
    private String filterByDescription;

    @Schema(description = "Filtrowanie według usunięty")
    private Boolean filterByDeleted;

    @Schema(description = "Filtrowanie według daty zakupu")
    private LocalDate filterByPurchaseDate;

    @Schema(description = "Filtrowanie według ceny netto")
    private BigDecimal filterByTotalNetPrice;

    @Schema(description = "Filtrowanie według ceny brutto")
    private BigDecimal filterByTotalGrossPrice;

    @Schema(description = "Filtrowanie według identyfikatora typu transakcji")
    private Long filterByTransactionTypeId;

    @Schema(description = "Filtrowanie według identyfikatora kontrahenta")
    private Long filterByContractorId;

    public String getFilterByName() {
        return filterByName;
    }

    public void setFilterByName(String filterByName) {
        this.filterByName = filterByName;
    }

    public String getFilterByDescription() {
        return filterByDescription;
    }

    public void setFilterByDescription(String filterByDescription) {
        this.filterByDescription = filterByDescription;
    }

    public Boolean getFilterByDeleted() {
        return filterByDeleted;
    }

    public void setFilterByDeleted(Boolean filterByDeleted) {
        this.filterByDeleted = filterByDeleted;
    }

    public LocalDate getFilterByPurchaseDate() {
        return filterByPurchaseDate;
    }

    public void setFilterByPurchaseDate(LocalDate filterByPurchaseDate) {
        this.filterByPurchaseDate = filterByPurchaseDate;
    }

    public BigDecimal getFilterByTotalNetPrice() {
        return filterByTotalNetPrice;
    }

    public void setFilterByTotalNetPrice(BigDecimal filterByTotalNetPrice) {
        this.filterByTotalNetPrice = filterByTotalNetPrice;
    }

    public BigDecimal getFilterByTotalGrossPrice() {
        return filterByTotalGrossPrice;
    }

    public void setFilterByTotalGrossPrice(BigDecimal filterByTotalGrossPrice) {
        this.filterByTotalGrossPrice = filterByTotalGrossPrice;
    }

    public Long getFilterByTransactionTypeId() {
        return filterByTransactionTypeId;
    }

    public void setFilterByTransactionTypeId(Long filterByTransactionTypeId) {
        this.filterByTransactionTypeId = filterByTransactionTypeId;
    }

    public Long getFilterByContractorId() {
        return filterByContractorId;
    }

    public void setFilterByContractorId(Long filterByContractorId) {
        this.filterByContractorId = filterByContractorId;
    }
}
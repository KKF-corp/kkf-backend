package pl.corp.kkf.kkf.services.api.dictionaries.transactionservices.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Filtr do wyszukiwania usługi")
public class TransactionServiceCriteria {

    @Schema(description = "Filtrowanie według nazwy")
    private String filterByName;

    @Schema(description = "Filtrowanie według opisu")
    private String filterByDescription;

    @Schema(description = "Filtrowanie według archiwalny")
    private Boolean filterByArchival;

    @Schema(description = "Filtrowanie według discount")
    private BigDecimal filterByDiscount;

    @Schema(description = "Filtrowanie według netPrice")
    private BigDecimal filterByNetPrice;

    @Schema(description = "Filtrowanie według grossPrice")
    private BigDecimal filterByGrossPrice;

    @Schema(description = "Filtrowanie według vat")
    private BigDecimal filterByVat;

    @Schema(description = "Filtrowanie według unit")
    private String filterByUnit;

    @Schema(description = "Filtrowanie według quantity")
    private Integer filterByQuantity;

    @Schema(description = "Filtrowanie według transactionServiceTypeId")
    private Long filterByTransactionServiceTypeId;

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

    public Boolean getFilterByArchival() {
        return filterByArchival;
    }

    public void setFilterByArchival(Boolean filterByArchival) {
        this.filterByArchival = filterByArchival;
    }

     public BigDecimal getFilterByDiscount() {
        return filterByDiscount;
    }

    public void setFilterByDiscount(BigDecimal filterByDiscount) {
        this.filterByDiscount = filterByDiscount;
    }

    public BigDecimal getFilterByNetPrice() {
        return filterByNetPrice;
    }

    public void setFilterByNetPrice(BigDecimal filterByNetPrice) {
        this.filterByNetPrice = filterByNetPrice;
    }

    public BigDecimal getFilterByGrossPrice() {
        return filterByGrossPrice;
    }

    public void setFilterByGrossPrice(BigDecimal filterByGrossPrice) {
        this.filterByGrossPrice = filterByGrossPrice;
    }

    public BigDecimal getFilterByVat() {
        return filterByVat;
    }

    public void setFilterByVat(BigDecimal filterByVat) {
        this.filterByVat = filterByVat;
    }

    public String getFilterByUnit() {
        return filterByUnit;
    }

    public void setFilterByUnit(String filterByUnit) {
        this.filterByUnit = filterByUnit;
    }

    public Integer getFilterByQuantity() {
        return filterByQuantity;
    }

    public void setFilterByQuantity(Integer filterByQuantity) {
        this.filterByQuantity = filterByQuantity;
    }

    public Long getFilterByTransactionServiceTypeId() {
        return filterByTransactionServiceTypeId;
    }

    public void setFilterByTransactionServiceTypeId(Long filterByTransactionServiceTypeId) {
        this.filterByTransactionServiceTypeId = filterByTransactionServiceTypeId;
    }
}
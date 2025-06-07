package pl.corp.kkf.kkf.services.api.dictionaries.transactionservices;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Filtr do wyszukiwania usługi")
public class TransactionServiceCriteria {

    @Schema(description = "Filtrowanie według nazwy")
    private String filterByName;

    @Schema(description = "Filtrowanie według opisu")
    private String filterByDescription;

    @Schema(description = "Filtrowanie według archiwalny")
    private Boolean filterByArchival;

    @Schema(description = "Filtrowanie według discount")
    private Double filterByDiscount;

    @Schema(description = "Filtrowanie według netPrice")
    private Double filterByNetPrice;

    @Schema(description = "Filtrowanie według grossPrice")
    private Double filterByGrossPrice;

    @Schema(description = "Filtrowanie według vat")
    private Double filterByVat;

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

     public Double getFilterByDiscount() {
        return filterByDiscount;
    }

    public void setFilterByDiscount(Double filterByDiscount) {
        this.filterByDiscount = filterByDiscount;
    }

    public Double getFilterByNetPrice() {
        return filterByNetPrice;
    }

    public void setFilterByNetPrice(Double filterByNetPrice) {
        this.filterByNetPrice = filterByNetPrice;
    }

    public Double getFilterByGrossPrice() {
        return filterByGrossPrice;
    }

    public void setFilterByGrossPrice(Double filterByGrossPrice) {
        this.filterByGrossPrice = filterByGrossPrice;
    }

    public Double getFilterByVat() {
        return filterByVat;
    }

    public void setFilterByVat(Double filterByVat) {
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
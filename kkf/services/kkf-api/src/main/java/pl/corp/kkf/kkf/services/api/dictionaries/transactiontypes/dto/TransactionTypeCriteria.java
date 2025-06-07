package pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Filtr do wyszukiwania typu transakcji")
public class TransactionTypeCriteria {

    @Schema(description = "Filtrowanie według nazwy")
    private String filterByName;

    @Schema(description = "Filtrowanie według typu")
    private String filterByType;

    public String getFilterByName() {
        return filterByName;
    }

    public void setFilterByName(String filterByName) {
        this.filterByName = filterByName;
    }

    public String getFilterByType() {
        return filterByType;
    }

    public void setFilterByType(String filterByType) {
        this.filterByType = filterByType;
    }
}
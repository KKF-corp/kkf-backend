package pl.corp.kkf.kkf.services.api.dictionaries.servicetypes.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Filtr do wyszukiwania typu usługa")
public class TransactionServiceTypeCriteria {

    @Schema(description = "Filtrowanie według nazwy")
    private String filterByName;

    @Schema(description = "Filtrowanie według opisu")
    private String filterByDescription;

    @Schema(description = "Filtrowanie według archiwalny")
    private Boolean filterByArchival;

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
}
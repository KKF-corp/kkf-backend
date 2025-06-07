package pl.corp.kkf.services.dictionaries.api.contractors.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Filtr do wyszukiwania kontrahenta")
public class ContractorCriteria {

    @Schema(description = "Filtrowanie według nazwy")
    private String filterByName;

    public String getFilterByName() {
        return filterByName;
    }

    public void setFilterByName(String filterByName) {
        this.filterByName = filterByName;
    }
}

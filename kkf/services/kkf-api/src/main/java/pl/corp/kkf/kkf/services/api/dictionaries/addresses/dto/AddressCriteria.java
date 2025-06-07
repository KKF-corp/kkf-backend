package pl.corp.kkf.kkf.services.api.dictionaries.addresses.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Filtr do wyszukiwania adresu")
public class AddressCriteria {

    @Schema(description = "Filtrowanie według miasta")
    private String filterByCity;

    public String getFilterByCity() {
        return filterByCity;
    }

    public void setFilterByCity(String filterByCity) {
        this.filterByCity = filterByCity;
    }
}

package pl.corp.kkf.kkf.services.api.dictionaries.addresses.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Filtr do wyszukiwania adresu")
public class AddressCriteria {

    @Schema(description = "Filtrowanie według miasta")
    private String filterByCity;

    @Schema(description = "Filtrowanie według ulicy")
    private String filterByStreet;

    @Schema(description = "Filtrowanie według kodu pocztowego")
    private String filterByPostcode;

    @Schema(description = "Filtrowanie według kraju")
    private String filterByCountry;

    @Schema(description = "Filtrowanie według archiwalny")
    private Boolean filterByArchival;

    public String getFilterByCity() {
        return filterByCity;
    }

    public void setFilterByCity(String filterByCity) {
        this.filterByCity = filterByCity;
    }

    public String getFilterByStreet() {
        return filterByStreet;
    }

    public void setFilterByStreet(String filterByStreet) {
        this.filterByStreet = filterByStreet;
    }

    public String getFilterByPostcode() {
        return filterByPostcode;
    }

    public void setFilterByPostcode(String filterByPostcode) {
        this.filterByPostcode = filterByPostcode;
    }

    public String getFilterByCountry() {
        return filterByCountry;
    }

    public void setFilterByCountry(String filterByCountry) {
        this.filterByCountry = filterByCountry;
    }

    public Boolean getFilterByArchival() {
        return filterByArchival;
    }

    public void setFilterByArchival(Boolean filterByArchival) {
        this.filterByArchival = filterByArchival;
    }
}
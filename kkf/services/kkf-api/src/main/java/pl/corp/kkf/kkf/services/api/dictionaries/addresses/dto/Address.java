package pl.corp.kkf.kkf.services.api.dictionaries.addresses.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "Wpis dla adresu")
public class Address {

    @Schema(description = "Identyfikator")
    private Long id;

    @Schema(description = "Ulica")
    private String street;

    @Schema(description = "Kod pocztowy")
    private String postcode;

    @Schema(description = "Miasto")
    private String city;

    @NotNull
    @Size(max = 50)
    @Schema(description = "Kraj")
    private String country;

    @Schema(description = "Wskaźnik czy archiwalny")
    private Boolean archival;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getArchival() {
        return archival;
    }

    public void setArchival(Boolean archival) {
        this.archival = archival;
    }

}
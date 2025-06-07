package pl.corp.kkf.kkf.services.api.dictionaries.addresses.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;

@Schema(description = "Odpowiedź dla adresu")
public class AddressResponse extends GeneralResponse {

    @Schema(description = "Adres")
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

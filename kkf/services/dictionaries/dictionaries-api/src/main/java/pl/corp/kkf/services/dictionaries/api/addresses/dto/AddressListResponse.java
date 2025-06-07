package pl.corp.kkf.services.dictionaries.api.addresses.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;

import java.util.List;

@Schema(description = "Odpowiedź dla wyszukiwania wszystkich adresów")
public class AddressListResponse extends GeneralResponse {

    @Schema(description = "Lista adresów")
    private List<Address> address;

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
}

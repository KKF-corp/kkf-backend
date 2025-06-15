package pl.corp.kkf.kkf.services.api.dictionaries.addresses.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;

@Schema(description = "Odpowiedź do wyszukiwania adresów")
public class AddressSearchResponse {

    @Schema(description = "Strona z listą wyszukiwania adresów")
    private PageDTO<Address> pageDTO;

    public PageDTO<Address> getPageDTO() {
        return pageDTO;
    }

    public void setPageDTO(PageDTO<Address> pageDTO) {
        this.pageDTO = pageDTO;
    }
}

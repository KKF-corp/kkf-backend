package pl.corp.kkf.services.dictionaries.api.addresses.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.corp.kkf.commons.rest.types.api.annotations.PageRequestCheck;
import pl.corp.kkf.commons.rest.types.api.pages.PageRequestDTO;

@Schema(description = "Zapytanie do wyszukiwania adresów")
public class AddressSearchRequest {

    @Schema(description = "Kryteria wyszukiwania adresów")
    private AddressCriteria criteria;

    @Schema(description = "Parametry stronnicowania")
    @PageRequestCheck(sortByAllowed = {"city"})
    private PageRequestDTO pageRequestDTO;

    public AddressCriteria getCriteria() {
        return criteria;
    }

    public void setCriteria(AddressCriteria criteria) {
        this.criteria = criteria;
    }

    public PageRequestDTO getPageRequestDTO() {
        return pageRequestDTO;
    }

    public void setPageRequestDTO(PageRequestDTO pageRequestDTO) {
        this.pageRequestDTO = pageRequestDTO;
    }
}

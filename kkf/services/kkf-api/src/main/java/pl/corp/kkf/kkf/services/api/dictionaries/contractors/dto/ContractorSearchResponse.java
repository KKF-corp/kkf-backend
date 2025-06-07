package pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;

@Schema(description = "Odpowiedź do wyszukiwania kontrahentów")
public class ContractorSearchResponse {

    @Schema(description = "Strona z listą wyszukiwania kontrahentów")
    private PageDTO<Contractor> pageDTO;

    public PageDTO<Contractor> getPageDTO() {
        return pageDTO;
    }

    public void setPageDTO(PageDTO<Contractor> pageDTO) {
        this.pageDTO = pageDTO;
    }
}

package pl.corp.kkf.kkf.services.api.revenues.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;

@Schema(description = "Odpowiedź do wyszukiwania przychodów")
public class RevenueSearchResponse {

    @Schema(description = "Strona z listą wyszukiwania przychodów")
    private PageDTO<Revenue> pageDTO;

    public PageDTO<Revenue> getPageDTO() {
        return pageDTO;
    }

    public void setPageDTO(PageDTO<Revenue> pageDTO) {
        this.pageDTO = pageDTO;
    }
}
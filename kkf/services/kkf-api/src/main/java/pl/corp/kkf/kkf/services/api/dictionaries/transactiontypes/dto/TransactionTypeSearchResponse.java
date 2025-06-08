package pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;

@Schema(description = "Zapytanie do wyszukiwania typu usługi")
public class TransactionTypeSearchResponse {

    @Schema(description = "Strona z listą wyszukiwania typu usługi")
    private PageDTO<TransactionType> pageDTO;

    public PageDTO<TransactionType> getPageDTO() {
        return pageDTO;
    }

    public void setPageDTO(PageDTO<TransactionType> pageDTO) {
        this.pageDTO = pageDTO;
    }
}
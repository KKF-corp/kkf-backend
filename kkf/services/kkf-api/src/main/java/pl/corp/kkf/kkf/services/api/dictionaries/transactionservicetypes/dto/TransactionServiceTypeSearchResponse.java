package pl.corp.kkf.kkf.services.api.dictionaries.transactionservicetypes.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;

@Schema(description = "Zapytanie do wyszukiwania typu usługa")
public class TransactionServiceTypeSearchResponse {

    @Schema(description = "Strona z listą wyszukiwania typu usługa")
    private PageDTO<TransactionServiceType> pageDTO;

    public PageDTO<TransactionServiceType> getPageDTO() {
        return pageDTO;
    }

    public void setPageDTO(PageDTO<TransactionServiceType> pageDTO) {
        this.pageDTO = pageDTO;
    }
}
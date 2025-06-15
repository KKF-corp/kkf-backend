package pl.corp.kkf.kkf.services.api.dictionaries.transactionservices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;

@Schema(description = "Zapytanie do wyszukiwania usługi")
public class TransactionServiceSearchResponse {

    @Schema(description = "Strona z listą wyszukiwania usługi")
    private PageDTO<TransactionServiceDto> pageDTO;

    public PageDTO<TransactionServiceDto> getPageDTO() {
        return pageDTO;
    }

    public void setPageDTO(PageDTO<TransactionServiceDto> pageDTO) {
        this.pageDTO = pageDTO;
    }
}
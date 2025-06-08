package pl.corp.kkf.kkf.services.api.dictionaries.transactionservicetypes.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.corp.kkf.commons.rest.types.api.annotations.PageRequestCheck;
import pl.corp.kkf.commons.rest.types.api.pages.PageRequestDTO;

@Schema(description = "Zapytanie do wyszukiwania typu usługa")
public class TransactionServiceTypeSearchRequest {

    @Schema(description = "Kryteria wyszukiwania typu usługa")
    private TransactionServiceTypeCriteria criteria;

    @Schema(description = "Parametry stronnicowania")
    @PageRequestCheck(sortByAllowed = {"name"})
    private PageRequestDTO pageRequestDTO;

    public TransactionServiceTypeCriteria getCriteria() {
        return criteria;
    }

    public void setCriteria(TransactionServiceTypeCriteria criteria) {
        this.criteria = criteria;
    }

    public PageRequestDTO getPageRequestDTO() {
        return pageRequestDTO;
    }

    public void setPageRequestDTO(PageRequestDTO pageRequestDTO) {
        this.pageRequestDTO = pageRequestDTO;
    }
}
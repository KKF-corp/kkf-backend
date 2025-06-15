package pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.corp.kkf.commons.rest.types.api.annotations.PageRequestCheck;
import pl.corp.kkf.commons.rest.types.api.pages.PageRequestDTO;

@Schema(description = "Zapytanie do wyszukiwania typu transakcji")
public class TransactionTypeSearchRequest {

    @Schema(description = "Kryteria wyszukiwania typu transakcji")
    private TransactionTypeCriteria criteria;

    @Schema(description = "Parametry stronnicowania")
    @PageRequestCheck(sortByAllowed = {"name"})
    private PageRequestDTO pageRequestDTO;

    public TransactionTypeCriteria getCriteria() {
        return criteria;
    }

    public void setCriteria(TransactionTypeCriteria criteria) {
        this.criteria = criteria;
    }

    public PageRequestDTO getPageRequestDTO() {
        return pageRequestDTO;
    }

    public void setPageRequestDTO(PageRequestDTO pageRequestDTO) {
        this.pageRequestDTO = pageRequestDTO;
    }
}
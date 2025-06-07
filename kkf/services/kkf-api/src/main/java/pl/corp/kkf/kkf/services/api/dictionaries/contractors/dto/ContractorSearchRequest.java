package pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.corp.kkf.commons.rest.types.api.annotations.PageRequestCheck;
import pl.corp.kkf.commons.rest.types.api.pages.PageRequestDTO;

@Schema(description = "Zapytanie do wyszukiwania kontrahentów")
public class ContractorSearchRequest {

    @Schema(description = "Kryteria wyszukiwania kontrahetów")
    private ContractorCriteria criteria;

    @Schema(description = "Parametry stronnicowania")
    @PageRequestCheck(sortByAllowed = {"name"})
    private PageRequestDTO pageRequestDTO;

    public ContractorCriteria getCriteria() {
        return criteria;
    }

    public void setCriteria(ContractorCriteria criteria) {
        this.criteria = criteria;
    }

    public PageRequestDTO getPageRequestDTO() {
        return pageRequestDTO;
    }

    public void setPageRequestDTO(PageRequestDTO pageRequestDTO) {
        this.pageRequestDTO = pageRequestDTO;
    }
}

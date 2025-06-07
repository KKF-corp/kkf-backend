package pl.corp.kkf.kkf.services.api.revenues.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.corp.kkf.commons.rest.types.api.annotations.PageRequestCheck;
import pl.corp.kkf.commons.rest.types.api.pages.PageRequestDTO;

@Schema(description = "Zapytanie do wyszukiwania przychodów")
public class RevenueSearchRequest {

    @Schema(description = "Kryteria wyszukiwania przychodów")
    private RevenueCriteria criteria;

    @Schema(description = "Parametry stronnicowania")
    @PageRequestCheck(sortByAllowed = {"name"})
    private PageRequestDTO pageRequestDTO;

    public RevenueCriteria getCriteria() {
        return criteria;
    }

    public void setCriteria(RevenueCriteria criteria) {
        this.criteria = criteria;
    }

    public PageRequestDTO getPageRequestDTO() {
        return pageRequestDTO;
    }

    public void setPageRequestDTO(PageRequestDTO pageRequestDTO) {
        this.pageRequestDTO = pageRequestDTO;
    }
}
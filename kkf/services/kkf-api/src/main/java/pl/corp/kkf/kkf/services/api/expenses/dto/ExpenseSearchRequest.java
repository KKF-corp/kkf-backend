package pl.corp.kkf.kkf.services.api.expenses.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.corp.kkf.commons.rest.types.api.annotations.PageRequestCheck;
import pl.corp.kkf.commons.rest.types.api.pages.PageRequestDTO;

@Schema(description = "Zapytanie do wyszukiwania wydatków")
public class ExpenseSearchRequest {

    @Schema(description = "Kryteria wyszukiwania wydatków")
    private ExpenseCriteria criteria;

    @Schema(description = "Parametry stronnicowania")
    @PageRequestCheck(sortByAllowed = {"name"})
    private PageRequestDTO pageRequestDTO;

    public ExpenseCriteria getCriteria() {
        return criteria;
    }

    public void setCriteria(ExpenseCriteria criteria) {
        this.criteria = criteria;
    }

    public PageRequestDTO getPageRequestDTO() {
        return pageRequestDTO;
    }

    public void setPageRequestDTO(PageRequestDTO pageRequestDTO) {
        this.pageRequestDTO = pageRequestDTO;
    }
}
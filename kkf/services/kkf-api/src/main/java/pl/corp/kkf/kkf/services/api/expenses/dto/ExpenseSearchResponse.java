package pl.corp.kkf.kkf.services.api.expenses.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;

@Schema(description = "Odpowiedź do wyszukiwania wydatków")
public class ExpenseSearchResponse {

    @Schema(description = "Strona z listą wyszukiwania wydatków")
    private PageDTO<Expense> pageDTO;

    public PageDTO<Expense> getPageDTO() {
        return pageDTO;
    }

    public void setPageDTO(PageDTO<Expense> pageDTO) {
        this.pageDTO = pageDTO;
    }
}
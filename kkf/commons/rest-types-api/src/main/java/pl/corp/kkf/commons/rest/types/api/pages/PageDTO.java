package pl.corp.kkf.commons.rest.types.api.pages;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@Schema(description = "Strona z danymi")
public class PageDTO<T> {

    @Valid
    @Schema(description = "Zawartość strony")
    private List<T> content = new ArrayList<>();

    @Schema(description = "Ilość wszystkich elemenetów na wszystkich stronach")
    private Long total;

    @Schema(description = "Ilość stron")
    private Long totalPages;

    @Valid
    @Schema(description = "Obecna strona")
    private PageRequestDTO currentPage;

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public PageRequestDTO getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(PageRequestDTO currentPage) {
        this.currentPage = currentPage;
    }
}

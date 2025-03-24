package pl.corp.kkf.commons.rest.types.api.pages;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.ws.rs.QueryParam;

@Schema(description = "Typ generyczny dla paginacji")
public class PageRequestDTO {

    @QueryParam("page")
    @Schema(description = "Numer strony")
    private Long page;

    @QueryParam("size")
    @Schema(description = "Wielkość strony")
    private Long size;

    @QueryParam("sortBy")
    @Schema(description = "Sortowanie po polu")
    private String sortBy;

    @QueryParam("direction")
    @Schema(description = "Kierunek sortowania")
    private SortDirection direction;

    public PageRequestDTO() {
    }

    public PageRequestDTO(Long page, Long size, String sortBy, SortDirection direction) {
        this.page = page;
        this.size = size;
        this.sortBy = sortBy;
        this.direction = direction;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public SortDirection getDirection() {
        return direction;
    }

    public void setDirection(SortDirection direction) {
        this.direction = direction;
    }
}

package pl.corp.kkf.commons.rest.types.api.pages;

import java.util.ArrayList;
import java.util.List;

public class PageDTO<T> {

    private List<T> content = new ArrayList<>();

    private Long totalElements;

    private Long TotalPages;

    private PageRequestDTO currentPage;

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public Long getTotalPages() {
        return TotalPages;
    }

    public void setTotalPages(Long totalPages) {
        TotalPages = totalPages;
    }

    public PageRequestDTO getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(PageRequestDTO currentPage) {
        this.currentPage = currentPage;
    }
}

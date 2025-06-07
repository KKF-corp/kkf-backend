package pl.corp.kkf.commons.base.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import pl.corp.kkf.commons.rest.types.api.pages.PageRequestDTO;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.commons.rest.types.api.pages.SortDirection;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class PageUtils {

    public static final int FIRST_PAGE = 0;
    public static final int DEFAULT_PAGE_SIZE = 50;
    public static final int MAX_PAGE_SIZE = 200;

    public static final Map<SortDirection, Sort.Direction> directionMap = new HashMap<>() {{
        put(SortDirection.ASC, Sort.Direction.ASC);
        put(SortDirection.DESC, Sort.Direction.DESC);
    }};

    public static final Map<Sort.Direction, SortDirection> directionReverseMap = new HashMap<>() {{
        put(Sort.Direction.ASC, SortDirection.ASC);
        put(Sort.Direction.DESC, SortDirection.DESC);
    }};

    public static Pageable convertToPageable(PageRequestDTO pageRequestDTO) {
        validatePageRequest(pageRequestDTO);
        Sort sort = Sort.unsorted();
        if (pageRequestDTO.getSortBy() != null && !pageRequestDTO.getSortBy().isEmpty()) {
            Sort.Direction direction = directionMap.get(pageRequestDTO.getSortDirection());
            sort = Sort.by(direction, pageRequestDTO.getSortBy());
        }

        int page = pageRequestDTO.getPage() != null ? pageRequestDTO.getPage() : FIRST_PAGE;
        int size = pageRequestDTO.getPageSize() != null ? pageRequestDTO.getPageSize() : DEFAULT_PAGE_SIZE;

        return PageRequest.of(page, size, sort);
    }}

    public static PageRequestDTO convertToPageRequestDTO(Pageable pageable) {
        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        pageRequestDTO.setPage(pageable.getPageNumber());
        pageRequestDTO.setPageSize(pageable.getPageSize());

        if (pageable.getSort().isSorted()) {
            Sort.Order order = pageable.getSort().iterator().next();
            pageRequestDTO.setSortBy(order.getProperty());
            pageRequestDTO.setSortDirection(directionReverseMap.get(order.getDirection()));
        }

        return pageRequestDTO;
    }}

    public static <T> PageDTO<T> convertToPageDTO(Page<T> page) {
        PageDTO<T> pageDTO = new PageDTO<>();
        pageDTO.setContent(page.getContent());
        pageDTO.setNumber(page.getNumber());
        pageDTO.setSize(page.getSize());
        pageDTO.setTotalElements(page.getTotalElements());
        pageDTO.setTotalPages(page.getTotalPages());
        return pageDTO;
    }}

    private static void validatePageRequest(PageRequestDTO pageRequestDTO) {
        if (pageRequestDTO.getPageSize() != null && pageRequestDTO.getPageSize() > MAX_PAGE_SIZE) {
            throw new IllegalArgumentException("Page size cannot be greater than " + MAX_PAGE_SIZE);
        }
    }}
}
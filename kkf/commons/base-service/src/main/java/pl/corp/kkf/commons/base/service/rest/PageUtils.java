package pl.corp.kkf.commons.base.service.rest;

import org.apache.commons.collections4.MapUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import pl.corp.kkf.commons.rest.types.api.pages.PageDTO;
import pl.corp.kkf.commons.rest.types.api.pages.PageRequestDTO;
import pl.corp.kkf.commons.rest.types.api.pages.SortDirection;

import java.util.*;

public class PageUtils {

    public static final int FIRST_PAGE = 0;
    public static final int DEFAULT_PAGE_SIZE = 50;
    public static final int MAX_PAGE_SIZE = 200;

    public static final Map<SortDirection, Sort.Direction> directionMap = new HashMap<>() {{
        put(SortDirection.ASC, Sort.Direction.ASC);
        put(SortDirection.DESC, Sort.Direction.DESC);
    }};

    public static final Map<Sort.Direction, SortDirection> directionReverseMap = MapUtils.invertMap(directionMap);

    public static Pageable convertTo(PageRequestDTO pageRequestDTO, Sort.Order... orders) {
//        validatePageRequest(pageRequestDTO);

        if (pageRequestDTO == null) {
            if (orders == null || orders.length == 0) {
                return PageRequest.of(FIRST_PAGE, DEFAULT_PAGE_SIZE);
            } else {
                return PageRequest.of(FIRST_PAGE, DEFAULT_PAGE_SIZE, Sort.by(orders));
            }
        }

        if (pageRequestDTO.getPage() == null || pageRequestDTO.getPage() < FIRST_PAGE) {
            pageRequestDTO.setPage((long) FIRST_PAGE);
        }

        if (pageRequestDTO.getSize() == null || pageRequestDTO.getSize() <= 0) {
            pageRequestDTO.setSize((long) DEFAULT_PAGE_SIZE);
        }

        if (pageRequestDTO.getSize() > MAX_PAGE_SIZE) {
            pageRequestDTO.setSize((long) MAX_PAGE_SIZE);
        }

        return PageRequest.of(pageRequestDTO.getPage().intValue(), pageRequestDTO.getSize().intValue(), convertToSort(pageRequestDTO, orders));
    }

    public static PageRequestDTO convertTo(Pageable pageable) {
        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        pageRequestDTO.setPage((long) pageable.getPageNumber());
        pageRequestDTO.setSize((long) pageable.getPageSize());
        Sort sort = pageable.getSort();

        sort.get()
                .findFirst()
                .ifPresent(order -> {
                    pageRequestDTO.setDirection(getReverseDirection(order));
                    pageRequestDTO.setSortBy(order.getProperty());
                });

        return pageRequestDTO;
    }

    public static Sort convertToSort(PageRequestDTO pageRequestDTO, Sort.Order[] sortOrders) {
        List<Sort.Order> orders = new LinkedList<>();
        String sortBy = pageRequestDTO.getSortBy();

        if (sortBy != null) {
            orders.add(new Sort.Order(getDirection(pageRequestDTO), sortBy));
        }

        if (sortOrders != null) {
            orders.addAll(Arrays.asList(sortOrders));
        }

        return orders.isEmpty() ? Sort.unsorted() : Sort.by(orders);
    }

    private static Sort.Direction getDirection(PageRequestDTO requestDTO) {
        return Optional.ofNullable(requestDTO.getDirection())
                .map(directionMap::get)
                .orElse(Sort.Direction.ASC);
    }

    private static SortDirection getReverseDirection(Sort.Order order) {
        return directionReverseMap.get(order.getDirection());
    }

    public static <T> PageDTO<T> convertTo(Page<T> page) {
        PageDTO<T> results = new PageDTO<>();
        results.setContent(page.getContent());
        results.setTotal(page.getTotalElements());
        results.setTotalPages((long) page.getTotalPages());
        results.setCurrentPage(convertTo(page.getPageable()));
        return results;
    }

    private static void validatePageRequest(PageRequestDTO pageRequestDTO) {
        if (pageRequestDTO.getSize() != null && pageRequestDTO.getSize() > MAX_PAGE_SIZE) {
            throw new IllegalArgumentException("Page size cannot be greater than " + MAX_PAGE_SIZE);
        }
    }
}
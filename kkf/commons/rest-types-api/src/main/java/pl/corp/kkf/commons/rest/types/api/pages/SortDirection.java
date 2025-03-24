package pl.corp.kkf.commons.rest.types.api.pages;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Kierunek stronnicowania")
public enum SortDirection {

    ASC,
    DESC;
}

package pl.corp.kkf.commons.base.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public abstract class BaseItemDto {

    @Schema(description = "Wskaźnik czy pole archiwalne")
    private boolean archival;

    @Schema(description = "Nazwa")
    private String name;

    @Schema(description = "Opis")
    private String description;

    public boolean isArchival() {
        return archival;
    }

    public void setArchival(boolean archival) {
        this.archival = archival;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

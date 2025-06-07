package pl.corp.kkf.services.dictionaries.api.servicetypes.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Wpis dla typu serwisu")
public class ServiceType {

    @Schema(description = "Identyfikator")
    private Long id;

    @Schema(description = "Nazwa")
    private String name;

    @Schema(description = "Opis")
    private String description;

    @Schema(description = "Wskaźnik czy archiwalny")
    private Boolean archival;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getArchival() {
        return archival;
    }

    public void setArchival(Boolean archival) {
        this.archival = archival;
    }
}
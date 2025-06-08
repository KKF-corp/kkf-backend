package pl.corp.kkf.kkf.services.api.dictionaries.servicetypes.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Wpis dla typu usługa")
public class TransactionServiceType {

    @Schema(description = "Identyfikator")
    private long id;

    @Schema(description = "Nazwa")
    private String name;

    @Schema(description = "Opis")
    private String description;

    @Schema(description = "Wskaźnik czy archiwalny")
    private Boolean archival;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
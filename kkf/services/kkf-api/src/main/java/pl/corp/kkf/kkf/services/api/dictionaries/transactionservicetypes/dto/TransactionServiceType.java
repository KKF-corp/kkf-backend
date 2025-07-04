package pl.corp.kkf.kkf.services.api.dictionaries.transactionservicetypes.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Wpis dla typu usługa")
public class TransactionServiceType {

    @Schema(description = "Identyfikator")
    private Long id;

    @NotNull
    @Schema(description = "Nazwa")
    private String name;

    @NotNull
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
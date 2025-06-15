package pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Wpis dla typu transakcji")
public class TransactionType {

    @Schema(description = "Identyfikator")
    private Long id;

    @NotNull
    @Schema(description = "Nazwa")
    private String name;

    @NotNull
    @Schema(description = "Typ")
    private String type;

    @Schema(description = "Wskaźnik czy zarchiwizowano")
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getArchival() {
        return archival;
    }

    public void setArchival(Boolean archival) {
        this.archival = archival;
    }
}
package pl.corp.kkf.services.dictionaries.api.transactiontypes.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Wpis dla typu transakcji")
public class TransactionType {

    @Schema(description = "Identyfikator")
    private Long id;

    @Schema(description = "Nazwa")
    private String name;

    @Schema(description = "Typ")
    private String type;

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
}
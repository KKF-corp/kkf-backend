package pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;

@Schema(description = "Odpowiedź dla kontrahenta")
public class ContractorResponse extends GeneralResponse {

    @Schema(description = "Kontrahent")
    private Contractor contractor;

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }
}

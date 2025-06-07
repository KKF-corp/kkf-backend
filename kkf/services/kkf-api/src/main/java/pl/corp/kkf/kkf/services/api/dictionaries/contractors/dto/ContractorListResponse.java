package pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.corp.kkf.commons.rest.types.api.responses.GeneralResponse;

import java.util.List;

@Schema(description = "Odpowiedź dla wyszukiwania wszystkich kontrahentów")
public class ContractorListResponse extends GeneralResponse {

    @Schema(description = "Lista kontrahentów")
    private List<Contractor> contractor;

    public List<Contractor> getContractor() {
        return contractor;
    }

    public void setContractor(List<Contractor> contractor) {
        this.contractor = contractor;
    }
}

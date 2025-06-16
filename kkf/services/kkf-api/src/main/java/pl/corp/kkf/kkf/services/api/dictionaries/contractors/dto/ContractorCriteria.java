package pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.corp.kkf.kkf.services.shared.types.ContractorType;

@Schema(description = "Filtr do wyszukiwania kontrahenta")
public class ContractorCriteria {

    @Schema(description = "Filtrowanie według nazwy")
    private String filterByName;

    @Schema(description = "Filtrowanie według imienia")
    private String filterByFirstName;

    @Schema(description = "Filtrowanie według nazwiska")
    private String filterByLastName;

    @Schema(description = "Filtrowanie według archiwalny")
    private Boolean filterByArchival;

    @Schema(description = "Filtrowanie według NIP")
    private String filterByNip;

    @Schema(description = "Filtrowanie według email")
    private String filterByEmail;

    @Schema(description = "Filtrowanie według numeru telefonu")
    private String filterByPhoneNumber;

    @Schema(description = "Filtrowanie według numeru konta bankowego")
    private String filterByBankAccountNumber;

    @Schema(description = "Filtrowanie według nazwy banku")
    private String filterByBankName;

    @Schema(description = "Filtrowanie według rodzaju kontrahenta")
    private ContractorType filterByContractorType;

    @Schema(description = "Filtrowanie według identyfikatora adresu")
    private Long filterByAddressId;

    public String getFilterByName() {
        return filterByName;
    }

    public void setFilterByName(String filterByName) {
        this.filterByName = filterByName;
    }

    public String getFilterByFirstName() {
        return filterByFirstName;
    }

    public void setFilterByFirstName(String filterByFirstName) {
        this.filterByFirstName = filterByFirstName;
    }

    public String getFilterByLastName() {
        return filterByLastName;
    }

    public void setFilterByLastName(String filterByLastName) {
        this.filterByLastName = filterByLastName;
    }

    public Boolean getFilterByArchival() {
        return filterByArchival;
    }

    public void setFilterByArchival(Boolean filterByArchival) {
        this.filterByArchival = filterByArchival;
    }

    public String getFilterByNip() {
        return filterByNip;
    }

    public void setFilterByNip(String filterByNip) {
        this.filterByNip = filterByNip;
    }

    public String getFilterByEmail() {
        return filterByEmail;
    }

    public void setFilterByEmail(String filterByEmail) {
        this.filterByEmail = filterByEmail;
    }

    public String getFilterByPhoneNumber() {
        return filterByPhoneNumber;
    }

    public void setFilterByPhoneNumber(String filterByPhoneNumber) {
        this.filterByPhoneNumber = filterByPhoneNumber;
    }

    public String getFilterByBankAccountNumber() {
        return filterByBankAccountNumber;
    }

    public void setFilterByBankAccountNumber(String filterByBankAccountNumber) {
        this.filterByBankAccountNumber = filterByBankAccountNumber;
    }

    public String getFilterByBankName() {
        return filterByBankName;
    }

    public void setFilterByBankName(String filterByBankName) {
        this.filterByBankName = filterByBankName;
    }

    public ContractorType getFilterByContractorType() {
        return filterByContractorType;
    }

    public void setFilterByContractorType(ContractorType filterByContractorType) {
        this.filterByContractorType = filterByContractorType;
    }

    public Long getFilterByAddressId() {
        return filterByAddressId;
    }

    public void setFilterByAddressId(Long filterByAddressId) {
        this.filterByAddressId = filterByAddressId;
    }
}
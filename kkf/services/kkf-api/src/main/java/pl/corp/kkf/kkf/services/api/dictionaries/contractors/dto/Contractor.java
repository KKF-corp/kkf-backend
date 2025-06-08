package pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import pl.corp.kkf.kkf.services.api.dictionaries.addresses.dto.Address;
import pl.corp.kkf.kkf.services.shared.types.ContractorType;

@Schema(description = "Wpis dla kontrahenta")
public class Contractor {

    @Schema(description = "Identyfikator")
    private Long id;

    @Size(max = 100)
    @Schema(description = "Nazwa")
    private String name;

    @Size(max = 45)
    @Schema(description = "Imię")
    private String firstName;

    @Size(max = 45)
    @Schema(description = "Nazwisko")
    private String lastName;

    @Size(max = 255)
    @Schema(description = "Opis")
    private String description;

    @Schema(description = "Wskaźnik czy archiwalny")
    private Boolean archival;

    @Size(max = 10)
    @Schema(description = "NIP")
    private String nip;

    @Size(max = 75)
    @Schema(description = "email")
    private String email;

    @Size(max = 15)
    @Schema(description = "Numer telefonu")
    private String phoneNumber;

    @NotNull
    @Size(max = 26)
    @Schema(description = "Numer konta")
    private String bankAccountNumber;

    @NotNull
    @Size(max = 45)
    @Schema(description = "Nazwa banku")
    private String bankName;

    @Size(max = 45)
    @Schema(description = "Fax")
    private String fax;

    @Size(max = 45)
    @Schema(description = "Swift")
    private String swift;

    @NotNull
    @Schema(description = "Rodzaj kontrahenta")
    private ContractorType contractorType;

    @Schema(description = "Adres kontrahenta")
    private Address address;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public ContractorType getContractorType() {
        return contractorType;
    }

    public void setContractorType(ContractorType contractorType) {
        this.contractorType = contractorType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

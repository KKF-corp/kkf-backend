package pl.corp.kkf.kkf.services.model.dictionaries;

import jakarta.persistence.*;
import pl.corp.kkf.commons.base.model.BaseEntity;
import pl.corp.kkf.kkf.services.shared.types.ContractorType;

import java.util.Objects;

//@NamedEntityGraphs()
@Entity
@Table(name = "CONTRACTORS", schema = "DICTIONARIES")
public class ContractorEntity extends BaseEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceContractorEntity")
    @SequenceGenerator(name = "SequenceContractorEntity", schema = "DICTIONARIES",
            sequenceName = "SEQ_CONTRACTORS")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ARCHIVAL")
    private Boolean archival;

    @Column(name = "NIP")
    private String nip;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "BANK_NUMBER_ACCOUNT")
    private String bankAccountNumber;

    @Column(name = "BANK_NAME")
    private String bankName;

    @Column(name = "FAX")
    private String fax;

    @Column(name = "SWIFT")
    private String swift;

    @Enumerated(EnumType.STRING)
    @Column(name = "CONTRACTOR_TYPE")
    private ContractorType contractorType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID")
    private AddressEntity address;

    public Long getId() {
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

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ContractorEntity that = (ContractorEntity) o;
        return Objects.equals(id, that.id)
                && Objects.equals(name, that.name)
                && Objects.equals(firstName, that.firstName)
                && Objects.equals(lastName, that.lastName)
                && Objects.equals(description, that.description)
                && Objects.equals(archival, that.archival)
                && Objects.equals(nip, that.nip)
                && Objects.equals(email, that.email)
                && Objects.equals(phoneNumber, that.phoneNumber)
                && Objects.equals(bankAccountNumber, that.bankAccountNumber)
                && Objects.equals(bankName, that.bankName)
                && Objects.equals(fax, that.fax)
                && Objects.equals(swift, that.swift)
                && Objects.equals(contractorType, that.contractorType)
                && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, firstName, lastName, description, archival, nip, email, phoneNumber,
                bankAccountNumber, bankName, fax, swift, contractorType, address);
    }
}

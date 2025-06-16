package pl.corp.kkf.kkf.services.api.expenses.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import pl.corp.kkf.kkf.services.api.dictionaries.contractors.dto.Contractor;
import pl.corp.kkf.kkf.services.api.dictionaries.transactiontypes.dto.TransactionType;
import pl.corp.kkf.kkf.services.api.transactionservices.dto.ExpensePosition;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Schema(description = "Wpis dla wydatku")
public class Expense {

    @Schema(description = "Identyfikator")
    private Long id;

    @NotNull
    @Size(max = 255)
    @Schema(description = "Nazwa")
    private String name;

    @Size(max = 500)
    @Schema(description = "Opis")
    private String description;

    @Schema(description = "Wskaźnik czy usunięty")
    private Boolean deleted;

    @NotNull
    @PastOrPresent
    @Schema(description = "Data zakupu")
    private LocalDate purchaseDate;

    @Schema(description = "Cena netto")
    private BigDecimal totalNetPrice;

    @Schema(description = "Cena brutto")
    private BigDecimal totalGrossPrice;

    @NotNull
    @Schema(description = "Typ transakcji")
    private TransactionType transactionType;

    @Schema(description = "Kontrahent")
    private Contractor contractor;

    @Valid
    @NotNull
    @Schema(description = "Pozycje rozchodu")
    private List<ExpensePosition> expenseServiceDtos;

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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getTotalNetPrice() {
        return totalNetPrice;
    }

    public void setTotalNetPrice(BigDecimal totalNetPrice) {
        this.totalNetPrice = totalNetPrice;
    }

    public BigDecimal getTotalGrossPrice() {
        return totalGrossPrice;
    }

    public void setTotalGrossPrice(BigDecimal totalGrossPrice) {
        this.totalGrossPrice = totalGrossPrice;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public List<ExpensePosition> getExpenseServiceDtos() {
        return expenseServiceDtos;
    }

    public void setExpenseServiceDtos(List<ExpensePosition> expenseServiceDtos) {
        this.expenseServiceDtos = expenseServiceDtos;
    }
}
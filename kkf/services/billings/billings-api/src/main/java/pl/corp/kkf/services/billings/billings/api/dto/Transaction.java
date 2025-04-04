package pl.corp.kkf.services.billings.billings.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.corp.kkf.billings.billings.shared.types.TransactionType;
import pl.corp.kkf.commons.base.dto.BaseItemDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Transakcja")
public class Transaction extends BaseItemDto {

    @Schema(description = "Wskaźnk czy usunieto")
    private boolean deleted;

    @Schema(description = "Data sprzedaży")
    private LocalDateTime saleDate;

    @Schema(description = "Całkowita wartość transkacji netto")
    private BigDecimal totalNetPrice;

    @Schema(description = "Całkowita wartość transkacji brutto")
    private BigDecimal totalGrossPrice;

    @Schema(description = "Rodzaj transakcji")
    private TransactionType transactionType;

}

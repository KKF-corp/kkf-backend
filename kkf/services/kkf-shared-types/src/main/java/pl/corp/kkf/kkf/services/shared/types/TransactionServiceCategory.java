package pl.corp.kkf.kkf.services.shared.types;

import pl.corp.kkf.commons.base.shared.types.EnumSupport;

public enum TransactionServiceCategory implements EnumSupport {
    REVENUE("Przychód"),
    EXPENSE("Wydatek");

    private final String polish;

    TransactionServiceCategory(String polish) {
        this.polish = polish;
    }

    @Override
    public String toPolish() {
        return polish;
    }
}

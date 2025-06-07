package pl.corp.kkf.services.dictionaries.shared.types;

import pl.corp.kkf.commons.base.shared.types.EnumSupport;

public enum ContractorType implements EnumSupport {
    INTERNAL_CONTRACTOR("Kontrahent wewnętrzny"),
    EXTERNAL_CONTRACTOR("Kontrahent zewnętrzny");

    private final String polish;

    ContractorType(String polish) {
        this.polish = polish;
    }

    @Override
    public String toPolish() {
        return polish;
    }
}

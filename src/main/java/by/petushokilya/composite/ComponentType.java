package by.petushokilya.composite;

public enum ComponentType {
    TEXT(""),
    PARAGRAPH("\t\n"),
    SENTENCE(""),
    LEXEME("\u0020"),
    MATH_EXPRESSION(""),
    WORD("")
    ;

    private final String value;

    ComponentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

package by.petushokilya.composite;

import by.petushokilya.exception.TextParserException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Symbol implements TextComponent {
    public static final Logger logger = LogManager.getLogger(Symbol.class.getName());
    private SymbolType symbolType;
    private char symbol;

    public Symbol(SymbolType symbolType, char symbol) {
        this.symbolType = symbolType;
        this.symbol = symbol;
    }

    public SymbolType getType() {
        return symbolType;
    }

    @Override
    public boolean addComponent(TextComponent component) throws TextParserException {
        logger.error("Unsupported operation.You dont can to put symbol");
        throw new TextParserException("Unsupported operation.You dont can to put symbol");
    }

    @Override
    public boolean removeComponent(TextComponent component) throws TextParserException {
        logger.error("Unsupported operation.You dont can to remove symbol");
        throw new TextParserException("Unsupported operation.You dont can to remove symbol");
    }

    @Override
    public TextComponent getComponent(int number) throws TextParserException {
        logger.error("Unsupported operation.You dont get symbol");
        throw new TextParserException("Unsupported operation.You dont get symbol");
    }

    @Override
    public String toString() {
        return Character.toString(symbol);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Symbol that = (Symbol) obj;
        return symbolType == that.symbolType &&
                symbol == that.symbol;
    }

    @Override
    public int size() {
        return 1;
    }
}

package by.petushokilya.parser.impl;

import by.petushokilya.composite.Symbol;
import by.petushokilya.composite.SymbolType;
import by.petushokilya.composite.TextComponent;
import by.petushokilya.exception.TextParserException;
import by.petushokilya.parser.TextComponentParser;

public class SymbolParser implements TextComponentParser {
    @Override
    public TextComponent parse(String dataString) throws TextParserException {
        char symbol = dataString.charAt(0);
        SymbolType symbolType;
        if (Character.isDigit(symbol)) {
            symbolType = SymbolType.DIGIT;
        } else if (Character.isLetter(symbol)) {
            symbolType = SymbolType.LETTER;
        } else {
            symbolType = SymbolType.PUNCTUATION;
        }

        return new Symbol(symbolType,symbol);
    }
}

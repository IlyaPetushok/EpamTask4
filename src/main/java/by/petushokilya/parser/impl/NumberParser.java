package by.petushokilya.parser.impl;

import by.petushokilya.composite.ComponentType;
import by.petushokilya.composite.TextComponent;
import by.petushokilya.composite.TextComposite;
import by.petushokilya.exception.TextParserException;
import by.petushokilya.parser.TextComponentParser;

import javax.naming.Context;
import java.util.List;

public class NumberParser implements TextComponentParser {
    private final TextComponentParser nextParser=new SymbolParser();

    @Override
    public TextComponent parse(String dataString) throws TextParserException {
        TextComposite mathExpression = new TextComposite(ComponentType.MATH_EXPRESSION);
        dataString.chars().forEach(symbol -> {
            try {
                mathExpression.addComponent(nextParser.parse(Character.toString(symbol)));
            } catch (TextParserException e) {
                e.printStackTrace();
            }
        });
        return mathExpression;
    }
}

package by.petushokilya.parser.impl;

import by.petushokilya.composite.ComponentType;
import by.petushokilya.composite.TextComponent;
import by.petushokilya.composite.TextComposite;
import by.petushokilya.exception.TextParserException;
import by.petushokilya.parser.TextComponentParser;

public class WordParser implements TextComponentParser {
    private final TextComponentParser successor = new SymbolParser();

    @Override
    public TextComponent parse(String dataString) {
        TextComposite word = new TextComposite(ComponentType.WORD);
        dataString.chars().forEach(symbol -> {
            try {
                word.addComponent(successor.parse(Character.toString(symbol)));
            } catch (TextParserException e) {
                e.printStackTrace();
            }
        });
        return word;
    }

}

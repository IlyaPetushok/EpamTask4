package by.petushokilya.parser.impl;

import by.petushokilya.composite.ComponentType;
import by.petushokilya.composite.TextComponent;
import by.petushokilya.composite.TextComposite;
import by.petushokilya.exception.TextParserException;
import by.petushokilya.parser.TextComponentParser;

public class SentenceParser implements TextComponentParser {
    private static final String SPACE=" ";
    private final TextComponentParser lexemeParser=new LexemeParser();
    @Override
    public TextComponent parse(String dataString) throws TextParserException {
        TextComponent sentence=new TextComposite(ComponentType.SENTENCE);
        String[] lexemesString=dataString.split(SPACE);
        for (String lexemeStrings : lexemesString) {
            TextComponent lexeme = lexemeParser.parse(lexemeStrings);
            sentence.addComponent(lexeme);
        }
        return sentence;
    }
}

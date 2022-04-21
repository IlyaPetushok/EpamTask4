package by.petushokilya.parser.impl;

import by.petushokilya.composite.ComponentType;
import by.petushokilya.composite.TextComponent;
import by.petushokilya.composite.TextComposite;
import by.petushokilya.exception.TextParserException;
import by.petushokilya.parser.TextComponentParser;

public class ParagraphParser implements TextComponentParser {
    private static final String PARAGRAPH_REGEX="\\r\\n";
    private static final TextComponentParser sentence=new SentenceParser();

    @Override
    public TextComponent parse(String dataString) throws TextParserException {
        String[] paragraphs =dataString.split(PARAGRAPH_REGEX);
        TextComponent component =new TextComposite(ComponentType.PARAGRAPH);
        for(String paragraph :paragraphs){
            TextComponent paragraphComponent=sentence.parse(paragraph);
            component.addComponent(paragraphComponent);
        }
        return component;
    }
}

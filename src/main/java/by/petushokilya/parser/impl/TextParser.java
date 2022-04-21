package by.petushokilya.parser.impl;

import by.petushokilya.composite.ComponentType;
import by.petushokilya.composite.TextComponent;
import by.petushokilya.composite.TextComposite;
import by.petushokilya.exception.TextParserException;
import by.petushokilya.parser.TextComponentParser;

import java.util.List;

public class TextParser implements TextComponentParser {
    private static final String PARAGRAPH_DELIMITER_REGEX = "\\t";
    private final TextComponentParser nextParser = new ParagraphParser();

    @Override
    public TextComponent parse(String dataString) throws TextParserException {
        TextComposite text = new TextComposite(ComponentType.TEXT);
        List<String> paragraphStrings = List.of(dataString.split(PARAGRAPH_DELIMITER_REGEX));
        paragraphStrings.forEach(paragraph ->
        {
            if (!paragraph.isEmpty()) {
                try {
                    text.addComponent(nextParser.parse(paragraph));
                } catch (TextParserException e) {
                    e.printStackTrace();
                }
            }
        });
        return text;
    }
}


package by.petushokilya.parser;

import by.petushokilya.composite.TextComponent;
import by.petushokilya.exception.TextParserException;

public interface TextComponentParser {
    TextComponent parse(String dataString) throws TextParserException;
}

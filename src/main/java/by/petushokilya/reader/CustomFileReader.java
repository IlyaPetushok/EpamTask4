package by.petushokilya.reader;

import by.petushokilya.exception.TextParserException;

public interface CustomFileReader{
    String readFile(String path) throws TextParserException;
}

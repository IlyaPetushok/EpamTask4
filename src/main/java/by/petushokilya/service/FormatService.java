package by.petushokilya.service;

import by.petushokilya.composite.TextComposite;
import by.petushokilya.exception.TextParserException;

public interface FormatService {
    void remove(TextComposite text, int wordAmount) throws TextParserException;
}

package by.petushokilya.service.impl;

import by.petushokilya.composite.ComponentType;
import by.petushokilya.composite.TextComponent;
import by.petushokilya.composite.TextComposite;
import by.petushokilya.exception.TextParserException;
import by.petushokilya.service.FormatService;

public class FormatServiceImpl implements FormatService {
    @Override
    public void remove(TextComposite text, int wordAmount) throws TextParserException {
        if (text.getType() == ComponentType.TEXT) {
            for (int i = 0; i < text.size(); i++) {
                TextComponent paragraphComponent = text.getComponent(i);
                TextComposite paragraph = (TextComposite) paragraphComponent;
                for (int j = 0; j < paragraph.size(); j++) {
                    TextComposite sentence = (TextComposite) paragraph.getComponent(j);
                    if (sentence.size() < wordAmount) {
                        paragraph.removeComponent(sentence);
                        j--;
                    }
                }
            }
        }
    }
}

package by.petushokilya.service.impl;

import by.petushokilya.composite.ComponentType;
import by.petushokilya.composite.TextComponent;
import by.petushokilya.composite.TextComposite;
import by.petushokilya.service.SortService;

import java.util.Comparator;

public class SortServiceImpl implements SortService {
    @Override
    public void sort(TextComposite text, Comparator<TextComponent> comparator) {
        if (text.getType() == ComponentType.TEXT) {
            text.getComponents().sort(comparator);
        }
    }
}

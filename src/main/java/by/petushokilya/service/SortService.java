package by.petushokilya.service;

import by.petushokilya.composite.TextComponent;
import by.petushokilya.composite.TextComposite;

import java.util.Comparator;

public interface SortService {
    void sort(TextComposite text, Comparator<TextComponent> comparator);

}

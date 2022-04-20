package by.petushokilya.composite;

import by.petushokilya.exception.TextParserException;

import java.awt.*;

public interface TextComponent {
    boolean addComponent(TextComponent component) throws TextParserException;
    boolean removeComponent(TextComponent component) throws TextParserException;
    TextComponent getComponent(int number) throws TextParserException;
    int size();
}

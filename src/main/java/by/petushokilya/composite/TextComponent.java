package by.petushokilya.composite;

import java.awt.*;

public interface TextComponent {
    boolean addChild(Component child);
    boolean removeChild(Component child);
    @Override
    String toString();
}

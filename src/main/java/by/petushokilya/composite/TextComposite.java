package by.petushokilya.composite;

import by.petushokilya.exception.TextParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent{
    private static final Logger logger= LogManager.getLogger(TextComponent.class.getName());
    private final ComponentType type;
    private List<TextComponent> components;

    public TextComposite(ComponentType type) {
        this.type = type;
        components = new ArrayList<>();
    }


    @Override
    public boolean addComponent(TextComponent component) throws TextParserException {
        return components.add(component);
    }

    @Override
    public TextComponent getComponent(int number) throws TextParserException {
        return components.get(number);
    }

    @Override
    public boolean removeComponent(TextComponent component) throws TextParserException {
        return components.remove(component);
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        TextComposite that = (TextComposite) obj;
        return type == that.type &&
                components.equals(that.components);
    }

    @Override
    public String toString() {
        String result=type.getValue();
        for (TextComponent textComponent : components) {
            result = result.concat(textComponent.toString());
        }
        return result;
    }


}

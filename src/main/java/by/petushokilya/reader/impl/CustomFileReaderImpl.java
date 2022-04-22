package by.petushokilya.reader.impl;

import by.petushokilya.exception.TextParserException;
import by.petushokilya.reader.CustomFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomFileReaderImpl implements CustomFileReader {
    private static final Logger logger = LogManager.getLogger(CustomFileReaderImpl.class.getName());

    @Override
    public String readFile(String path) throws TextParserException {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            if (bufferedReader.ready()) {
                contentBuilder.append(bufferedReader.readLine());
            }
            while (bufferedReader.ready()) {
                contentBuilder.append('\n').
                        append(bufferedReader.readLine());
            }
        } catch (IOException exception) {
            logger.error("Mistake reading file", exception);
            throw new TextParserException("Mistake reading file", exception);
        }
        String content = contentBuilder.toString();
        return content;
    }
}

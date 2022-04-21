package by.petushokilya.parser.impl;

import by.petushokilya.composite.ComponentType;
import by.petushokilya.composite.TextComponent;
import by.petushokilya.composite.TextComposite;
import by.petushokilya.exception.TextParserException;
import by.petushokilya.parser.TextComponentParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser implements TextComponentParser {
    private static final String PUNCTUATION_REGEX = "\\p{Punct}";
    private static final String WORD_REGEX = "[\\w&&\\D]+";
    private static final String MATH_EXPRESSION_REGEX = "[\\d+\\-*/()]{3,}";
    private final TextComponentParser nextWordParser = new WordParser();
    private final TextComponentParser nextSymbolParser = new SymbolParser();
    private final TextComponentParser nextMathOperationParser = new NumberParser();
    @Override
    public TextComponent parse(String dataString) throws TextParserException {
            TextComposite lexeme = new TextComposite(ComponentType.LEXEME);
            Pattern matchOperation = Pattern.compile(MATH_EXPRESSION_REGEX);
            Matcher mathMatcher = matchOperation.matcher(dataString);
            if (mathMatcher.matches()) {
                lexeme.addComponent(nextMathOperationParser.parse(dataString));
            } else {
                Pattern wordPattern = Pattern.compile(WORD_REGEX);
                Pattern punctuationPattern = Pattern.compile(PUNCTUATION_REGEX);
                Matcher wordMatcher = wordPattern.matcher(dataString);
                Matcher punctuationMatcher = punctuationPattern.matcher(dataString);
                int i = 0;
                int j = 0;
                while (wordMatcher.find(i) && punctuationMatcher.find(j)) {
                    if (wordMatcher.start() < punctuationMatcher.start()) {
                        lexeme.addComponent(nextWordParser.parse(wordMatcher.group()));
                        i = wordMatcher.end();
                    } else {
                        lexeme.addComponent(nextSymbolParser.parse(punctuationMatcher.group()));
                        j = punctuationMatcher.end();
                    }
                }
                while (wordMatcher.find(i)) {
                    lexeme.addComponent(nextWordParser.parse(wordMatcher.group()));
                    i = wordMatcher.end();
                }

                while (punctuationMatcher.find(j)) {
                    lexeme.addComponent(nextSymbolParser.parse(punctuationMatcher.group()));
                    j = punctuationMatcher.end();
                }

            }

            return lexeme;
        }

}

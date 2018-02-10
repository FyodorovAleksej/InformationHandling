package by.fyodorov.informationhandling.parser;

import by.fyodorov.informationhandling.composite.TextCompositeComponent;
import by.fyodorov.informationhandling.composite.Compositely;
import by.fyodorov.informationhandling.composite.CompositeLeaf;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    private static final String PARAGRAPH_EXPRESSION = "\\t|\\s{4}";
    private static final String SENTENCE_EXPRESSION = "[A-Z].*?[\\.\\?\\!]{1}";
    private static final String LEXEME_EXPRESSION = "(\\?|\\!|\\,|\\.|^|\\s){1}.+?(\\s|\\.|\\!|\\?|\\,){1}";
    private static final String MATH_EXPRESSION = "[0-9]|[a-z]+[\\-+/*]{1,2}[0-9]|[a-z]+";

    public Compositely parse(String text) {
        Compositely textRoot = new TextCompositeComponent();
        LinkedList<String> paragraphs = parseParagraph(text);
        for (String i: paragraphs) {
            Compositely sentenceComponent = new TextCompositeComponent();
            textRoot.addChild(sentenceComponent);
            LinkedList<String> sentences = parseSentence(i);
            for (String j: sentences) {
                Compositely lexemeComponent = new TextCompositeComponent();
                sentenceComponent.addChild(lexemeComponent);
                LinkedList<String> lexemes = parseLexeme(j);
                for (String k : lexemes) {
                    for (int index = 0; index < k.length(); index++) {
                        if (k.matches(MATH_EXPRESSION)) {
                            /*INTERPRETATOR*/
                        }
                        lexemeComponent.addChild(new CompositeLeaf(k.charAt(index)));
                    }
                }
            }
        }
        return textRoot;
    }

    private LinkedList<String> parseParagraph(String text) {
        return parseRegular(text, PARAGRAPH_EXPRESSION);
    }

    private LinkedList<String> parseSentence(String text) {
        return parseRegular(text, SENTENCE_EXPRESSION);
    }

    private LinkedList<String> parseLexeme(String text) {
        return parseRegular(text, LEXEME_EXPRESSION);
    }

    private LinkedList<String> parseRegular(String text, String expression) {
        Pattern p = Pattern.compile(expression);
        Matcher m = p.matcher(text);
        LinkedList<String> list = new LinkedList<String>();
        while(m.find()) {
            list.add(text.substring(m.start(), m.end()));
            System.out.println(text.substring(m.start(), m.end()));
        }
        return list;
    }
}

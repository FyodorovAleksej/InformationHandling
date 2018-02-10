package by.fyodorov.informationhandling.reader;

import by.fyodorov.informationhandling.exception.TextException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TextReader {
    public String readText(String path) throws TextException {
        Stream<String> stream = null;

        try {
            stream = Files.lines(Paths.get(path));
            String[] strings = stream.toArray(String[]::new);
            StringBuilder builder = new StringBuilder();
            for (String i : strings) {
                builder.append(i).append("\n");
            }
            return builder.toString();
        } catch (IOException e) {
            throw new TextException("can't read file", e);
        }
        finally {
            if (stream != null) {
                stream.close();
            }
        }
    }
}

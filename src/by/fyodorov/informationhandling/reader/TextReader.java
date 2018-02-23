package by.fyodorov.informationhandling.reader;

import by.fyodorov.informationhandling.exception.TextException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * class for reading text form file
 */
public class TextReader {

    /**
     * read text from file with input path
     * @param path path of file for reading
     * @return readied text
     * @throws TextException in case, when file can't be opened
     */
    public String readText(String path) throws TextException {
        Stream<String> stream = null;
        try {
            stream = Files.lines(Paths.get(path));
            String[] strings = stream.toArray(String[]::new);
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < strings.length - 1; i++) {
                builder.append(strings[i]).append("\n");
            }
            builder.append(strings[strings.length - 1]);
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

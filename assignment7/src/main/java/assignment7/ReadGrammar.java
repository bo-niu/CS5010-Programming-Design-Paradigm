package assignment7;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * assignment7.ReadGrammar class handles reading grammar json files by using simple-json API.
 */
public class ReadGrammar {

    private String filePath;

    /**
     * assignment7.ReadGrammar class constructor.
     *
     * @param filePath a string representing the file path.
     */
    public ReadGrammar(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Returns this assignment7.ReadGrammar's filePath.
     *
     * @return filePath.
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Sets this assignment7.ReadGrammar's filePath to input string.
     *
     * @param filePath a string representing the file path.
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Reads the grammar json into a HashMap.
     *
     * @return a HashMap representing all rules in grammar file.
     * @throws IOException    Exception thrown for errors occur when invalid file path.
     * @throws ParseException Exception thrown for errors occur when parsing json file.
     */
    @SuppressWarnings("unchecked")
    public HashMap<String, List<String>> load() throws IOException, ParseException {
        HashMap<String, List<String>> grammarMap = new HashMap();
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(filePath)) {
            JSONObject grammar = (JSONObject) jsonParser.parse(reader);
            List<String> keys = new ArrayList<>(grammar.keySet());
            keys.removeAll(Arrays.asList("grammarTitle", "grammarDesc"));
            for (String definition : keys) {
                JSONArray production = (JSONArray) grammar.get(definition);
                grammarMap.put(definition.toLowerCase(), production);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return grammarMap;
    }

    /**
     * Overrides equals() in java.lang.Objects.
     *
     * @param o an object being compared.
     * @return true if and only if o equals this assignment7.ReadGrammar.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReadGrammar)) return false;
        ReadGrammar that = (ReadGrammar) o;
        return Objects.equals(filePath, that.filePath);
    }

    /**
     * Overrides hashcode() in java.lang.Objects.
     *
     * @return the hash code for this assignment7.ReadGrammar class.
     */
    @Override
    public int hashCode() {
        return Objects.hash(filePath);
    }
}

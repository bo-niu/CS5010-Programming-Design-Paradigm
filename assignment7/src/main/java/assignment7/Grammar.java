package assignment7;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * assignment7.Grammar class representing the Context in interpreter pattern.
 */
public class Grammar {

    private HashMap<String, List<String>> map;

    /**
     * assignment7.Grammar class constructor.
     *
     * @param map a HashMap contains all rules for this grammar.
     */
    public Grammar(HashMap<String, List<String>> map) {
        this.map = map;
    }

    /**
     * Get a random production with given definition.
     *
     * @param definition a string representing the key value in HashMap.
     * @return a randomly chosen string from the value list.
     * @throws UndefinedNonTerminalException error when given definition is not found in grammar.
     */
    public String getProduction(String definition) throws UndefinedNonTerminalException {
        if (map.containsKey(definition)) {
            List<String> productions = map.get(definition);
            int random = (int) (Math.random() * productions.size());
            return productions.get(random);
        }
        throw new UndefinedNonTerminalException(definition + " is undefined in grammar file.");
    }

    /**
     * Returns this assignment7.Grammar's map.
     *
     * @return map.
     */
    public HashMap<String, List<String>> getMap() {
        return map;
    }

    /**
     * Sets this assignment7.Grammar's map to given map.
     *
     * @param map a HashMap contains all rules for this grammar.
     */
    public void setMap(HashMap<String, List<String>> map) {
        this.map = map;
    }

    /**
     * Overrides equals() in java.lang.Objects.
     *
     * @param o an object being compared.
     * @return true if and only if this grammar equals o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grammar)) return false;
        Grammar grammar = (Grammar) o;
        return Objects.equals(map, grammar.map);
    }

    /**
     * Overrides hashcode() in java.lang.Objects.
     *
     * @return hash code for this assignment7.Grammar class.
     */
    @Override
    public int hashCode() {
        return Objects.hash(map);
    }
}

import java.util.Set;
import java.util.TreeSet;

/**
 * 08722 Homework 6. Word class.
 *
 * Andrew ID: xinw3
 * @author Xin Wang
 *
 */
public final class Word implements Comparable<Word> {
    /**
     * The word String.
     */
    private String word;
    /**
     * index to store line numbers of each word.
     */
    private Set<Integer> index;
    /**
     * frequency indicates the number of words.
     */
    private int frequency;

    /**
     * Constructor with a string parameter.
     * @param s String value of the word.
     */
    public Word(String s) {
        word = s;
    }

    // TODO implement methods below.
    /**
     * Setter of frequency.
     * @param freq int to be setted.
     */
    public void setFrequency(int freq) {
        frequency = freq;
    }
    /**
     * Setter of word.
     * @param s String value of word.
     */
    public void setWord(String s) {
        word = s;
    }
    /**
     * add the line number to index set.
     * @param line Integer line to add into index.
     */
    public void addToIndex(Integer line) {
        if (index == null) {
            index = new TreeSet<Integer>();
        }
        index.add(line);
    }

    /**
     * Method to get the index set.
     * @return Set<Integer> the index TreeSet.
     */
    public Set<Integer> getIndex() {
        Set<Integer> newIndex = new TreeSet<Integer>(index);
        return newIndex;
    }

    /**
     * Method to get the word.
     * @return String word.
     */
    public String getWord() {
        return this.word;
    }

    /**
     * Method to get frequency.
     * @return int frequency.
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * Method to change the Word to String.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(word);
        sb.append(" ");
        sb.append(frequency);
        sb.append(" ");
        sb.append(index);
        return sb.toString();
    }

    /**
     * compareTo method to sort word using frequency.
     * by desending order.
     */
    @Override
    public int compareTo(Word w) {
        return word.compareTo(w.getWord());
    }
}

import java.util.Comparator;
/**
 * The comparator class to sort ignoring case.
 * @author Xin Wang
 * Andrew ID: xinw3
 */
public class IgnoreCase implements Comparator<Word> {
    /**
     * Override compare method.
     * And sort word alphabetically ignoring case.
     */
    @Override
    public int compare(Word w1, Word w2) {
        return w1.getWord().compareToIgnoreCase(w2.getWord());
    }
}

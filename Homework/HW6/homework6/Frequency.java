import java.util.Comparator;
/**
 * 08722 Homework 6.
 * Frequency class.
 *
 * Andrew ID: xinw3
 * @author Xin Wang
 *
 */
public class Frequency implements Comparator<Word> {
    @Override
    public int compare(Word w1, Word w2) {
        return w2.getFrequency() - w1.getFrequency();
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 08722 homework 5.
 * Find similarity between 2 documents.
 * Andrew ID: xinw3
 * @author Xin Wang
 */
public class Similarity {
    /**
     * The HashMap to put the word vector of a string or a file.
     */
    private HashMap<String, BigInteger> wordMap = new HashMap<String, BigInteger>();
    /**
     * String array that Contains the splited words.
     */
    private String[] words;
    /**
     * Variables to record the number of words read in.
     */
    private BigInteger numOfWords = BigInteger.ZERO;
    /**
     * Variables to record the number of lines read in from a file.
     */
    private int numOfLines = 0;
    /**
     * Variables to record no duplicated words.
     */
    private int numOfWordsNoDups = 0;
    /**
     * Constructor to read a string.
     * @param string the string to be computed.
     */
    public Similarity(String string) {
        if (string != null && !string.trim().isEmpty()) {
            words = string.toLowerCase().split("\\W");
            for (String word : words) {
                if (word.matches("[a-zA-Z]+")) {
                    numOfWords = numOfWords.add(BigInteger.ONE);
                    BigInteger freq = wordMap.get(word);
                    if (freq == null) {
                        freq = BigInteger.ONE;
                        numOfWordsNoDups++;
                    } else {
                        freq = freq.add(BigInteger.ONE);
                    }
                    wordMap.put(word, freq);
                }
            }
        }
    }
    /**
     * Constructor to read a file.
     * @param file the file to be computed.
     */
    public Similarity(File file) {
        Scanner scanner = null;
        try {
            if (file != null) {
                scanner = new Scanner(file, "latin1");
                while (scanner.hasNextLine()) {
                    numOfLines++;
                    String line = scanner.nextLine();
                    if (line != null && !line.trim().isEmpty()) {
                        words = line.toLowerCase().split("\\W");
                        for (String word : words) {
                            if (word.matches("[a-zA-Z]+")) {
                                numOfWords = numOfWords.add(BigInteger.ONE);
                                BigInteger freq = wordMap.get(word);
                                if (freq == null) {
                                    freq = BigInteger.ONE;
                                    numOfWordsNoDups++;
                                } else {
                                    freq = freq.add(BigInteger.ONE);
                                }
                                wordMap.put(word, freq);
                            }
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
    /**
     * Method to return the number of lines.
     * @return int number of lines.
     */
    public int numOfLines() {
        return numOfLines;
    }
    /**
     * Method to return the number of words.
     * @return int number of words.
     */
    public BigInteger numOfWords() {
        return numOfWords;
    }
    /**
     * Method to return the number of non-duplicated words.
     * @return int number of no duplicated words.
     */
    public int numOfWordsNoDups() {
        return numOfWordsNoDups;
    }
    /**
     * Method to return the Euclidean Norm of the word vector.
     * @return double the Euclidean norm of a word vector.
     */
    public double euclideanNorm() {
        return Math.sqrt(dotProduct(this.wordMap));
    }
    /**
     * Method to return the dot product of map and this.wordMap.
     * @param map contains the word vector to compute.
     * @return double product of two word vector.
     */
    public double dotProduct(Map<String, BigInteger> map) {
        if (map != null) {
            BigInteger product = innerProduct(this.wordMap, map);
            return product.doubleValue();
        }
        return 0;
    }
    /**
     * Method to return the distance of two word vector.
     * @param map the word vector to be computed with this.wordMap
     * @return the distance between two word vector.
     */
    public double distance(Map<String, BigInteger> map) {
        if (this.wordMap == null || map == null) {
            return Math.PI / 2;
        }
        if (this.wordMap.size() == 0 || map.size() == 0) {
            return Math.PI / 2;
        }
        if (this.wordMap.equals(map)) {
            return 0;
        }
        BigInteger innerA = innerProduct(this.wordMap, this.wordMap);
        BigInteger innerB = innerProduct(map, map);
        BigInteger multiple = innerA.multiply(innerB);
        double denominator = Math.sqrt(multiple.doubleValue());
        if (denominator == 0) {
            return Math.PI / 2;
        }
        BigInteger dotP = innerProduct(this.wordMap, map);
        double dist = dotP.doubleValue() / denominator;
        return Math.acos(dist);
    }
    /**
     * Method to return the map that contains the word vector.
     * @return Map a new hashMap.
     */
    public Map<String, BigInteger> getMap() {
        Map<String, BigInteger> newWordMap = new HashMap<String, BigInteger>(wordMap);
        return newWordMap;
    }
    /**
     * Helper function to return the dot product of two word vector.
     * @param map1 one word vector.
     * @param map2 the other word vector.
     * @return the product of two word vector.
     */
    private BigInteger innerProduct(Map<String, BigInteger> map1, Map<String, BigInteger> map2) {
        BigInteger product = BigInteger.ZERO;
        if (map1 != null && map2 != null) {
            for (String word : map1.keySet()) {
                if (map2.containsKey(word)) {
                    product = product.add(map1.get(word).multiply(map2.get(word)));
                }
            }
        }
        return product;
    }
}

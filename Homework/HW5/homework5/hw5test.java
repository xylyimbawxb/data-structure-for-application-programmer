
public class hw5test {

    public static void main(String[] args) {
        Similarity text1 = new Similarity("hello there nice to meet you you look nice");
        printOutput(text1);

        Similarity text2 = new Similarity("hello there nice to meet you you look nice");
        printOutput(text2);

        System.out.println(text1.dotProduct(text2.getMap()) + " dot product.");
        System.out.println(text1.distance(text2.getMap()) + " distance.");
    }

    /**
     * Prints some values of Similarity object.
     * @param sim Similarity object to deal with
     */
    private static void printOutput(Similarity sim) {
        System.out.println(sim.numOfWords() + " words.");
        System.out.println(sim.numOfWordsNoDups() + " distinct words.");
        System.out.println(sim.euclideanNorm() + " Euclidean norm.\n");
    }

}

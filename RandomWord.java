import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        String champ = StdIn.readString();
        int i = 2;
        while (!StdIn.isEmpty()) {
            String challenger = StdIn.readString();
            if (StdRandom.bernoulli(1.0 / (double) i)) {
                champ = challenger;
            }
            i++;
        }
        System.out.println(champ);
    }
}

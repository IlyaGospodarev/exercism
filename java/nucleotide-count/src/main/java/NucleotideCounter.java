import java.util.HashMap;
import java.util.Map;

public class NucleotideCounter {
    private String dna;

    public NucleotideCounter(String dna) throws IllegalArgumentException {
        if (!dna.matches("[ATGC]*")) {
            throw new IllegalArgumentException();
        }

        this.dna = dna;
    }


    public Map<Character, Integer> nucleotideCounts() {
        char[] dnaArray = dna.toCharArray();
        Map<Character, Integer> nucleotideCount = new HashMap<>(Map.of('A', 0, 'C', 0, 'G', 0, 'T', 0));

        for(char dna : dnaArray) {
            nucleotideCount.merge(dna, 1, Integer::sum);
        }

        return nucleotideCount;
    }
}

import java.util.*;

public class Anagram {
    private String word;

    public Anagram(String word) {
        this.word = word;
    }

    public List<String> match(List<String> candidates) {
        List<String> anagrams = new ArrayList<>();
        Map<String, Integer> anagramWord = new HashMap<>();
        Map<String, Integer> candidateWord = new HashMap<>();

        for (String letter : word.toLowerCase().split("")) {
            anagramWord.merge(letter, 1, Integer::sum);
        }

         for (String candidate : candidates) {
            for (String letter : candidate.toLowerCase().split("")) {
                candidateWord.merge(letter, 1, Integer::sum);
            }

            if (candidateWord.equals(anagramWord) && !candidate.equalsIgnoreCase(word)) {
                anagrams.add(candidate);
            }
             
            candidateWord.clear();
        }
        return anagrams;
    }
}

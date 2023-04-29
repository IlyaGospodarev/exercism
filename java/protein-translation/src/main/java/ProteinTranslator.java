import java.util.*;

class ProteinTranslator {

     LinkedHashMap<String, List<String>> proteinMap() {
        LinkedHashMap<String, List<String>> proteins = new LinkedHashMap<>();
        proteins.put("Methionine", List.of("AUG"));
        proteins.put("Phenylalanine", List.of("UUU", "UUC"));
        proteins.put("Leucine", List.of("UUA", "UUG"));
        proteins.put("Serine", List.of("UCU", "UCC", "UCA", "UCG"));
        proteins.put("Tyrosine", List.of("UAU", "UAC"));
        proteins.put("Cysteine", List.of("UGU", "UGC"));
        proteins.put("Tryptophan", List.of("UGG"));

        return proteins;
    }

    List<String> translate(String rnaSequence) {

        String[] rna = rnaSequence.split("(?<=\\G.{3})");
        List<String> key = new LinkedList<>();

        List<String> stop = List.of("UAA", "UAG", "UGA");

        for (String r : rna) {
            if (stop.contains(r)) {
                break;
            }
            for (String k : proteinMap().keySet()) {
                if (proteinMap().get(k).contains(r)) {
                    key.add(k);
                }
            }
        }
        return key;
    }
}

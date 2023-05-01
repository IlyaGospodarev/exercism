import java.util.Arrays;

class RnaTranscription {
    public static void main(String[] args) {
        RnaTranscription rna = new RnaTranscription();
        System.out.println(rna.transcribe("GCTA"));
    }

    String transcribe(String dnaStrand) {

        return Arrays
                .stream(dnaStrand.split(""))
                .map(dna -> switch (dna) {
                    case "G" -> "C";
                    case "C" -> "G";
                    case "T" -> "A";
                    case "A" -> "U";
                    default -> "";
                })
                .reduce((s, s2) -> s + s2)
                .get();
    }
}

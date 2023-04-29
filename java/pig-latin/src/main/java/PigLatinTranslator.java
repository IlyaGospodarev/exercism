
public class PigLatinTranslator {
    public String translate(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder pigLatinSentence = new StringBuilder();
        
        for (String word : words) {
            String pigLatinWord = translateWordToPigLatin(word);
            pigLatinSentence.append(pigLatinWord).append(" ");
        }
        
        return pigLatinSentence.toString().trim();
    }
    
    public String translateWordToPigLatin(String word) {
        if (word.matches("[aeiouAEIOU].*|xr.*|yt.*")) {
            return word + "ay";
        } else if (word.matches(".*qu.*")) {
            int index = word.indexOf("qu") + 2;
            return word.substring(index) + word.substring(0, index) + "ay";
        } else if (word.startsWith("y")) {
            int index = word.indexOf("y") + 1;
            return word.substring(index) + word.substring(0, index) + "ay";
        } else {
            int index = findIndexOfFirstVowelSound(word);
            return word.substring(index) + word.substring(0, index) + "ay";
        }
    }

    public int findIndexOfFirstVowelSound(String word) {
        
        for (String w : word.split("")) {
            if (w.matches("[aeiouyAEIOUY]")) {
                return word.indexOf(w);
            }
        }
        
        return -1;
    }
}



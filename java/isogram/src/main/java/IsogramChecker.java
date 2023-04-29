import java.util.*;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        Map<String, Integer> phraseCheck = new HashMap<>();

        for (String s : phrase.replaceAll("\\W","").toLowerCase().split("")) {
            if(phraseCheck.merge(s, 1, Integer::sum) > 1) {
                return false;
            }
        }
 
        return true;
    }
}

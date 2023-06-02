import java.util.*;

class Etl {
    Map<String, Integer> transform(Map<Integer, List<String>> old) {
        HashMap<String, Integer> transformMap = new HashMap<>();

        for (Map.Entry<Integer, List<String>> entry : old.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                transformMap.put(entry.getValue().get(i).toLowerCase(), entry.getKey());
            }
        }

        return transformMap;
    }
}

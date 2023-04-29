import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

class ResistorColor {

    
    Map<String, Integer> creatingMap() {
        LinkedHashMap<String, Integer> resistor = new LinkedHashMap<>();
        resistor.put("black", 0);
        resistor.put("brown", 1);
        resistor.put("red", 2);
        resistor.put("orange", 3);
        resistor.put("yellow", 4);
        resistor.put("green", 5);
        resistor.put("blue", 6);
        resistor.put("violet", 7);
        resistor.put("grey", 8);
        resistor.put("white", 9);
        
        return resistor;
    }

    int colorCode(String color) {
        return creatingMap().get(color);
    }

    String[] colors() {
        return creatingMap().keySet().toArray(new String[0]);
    }
}

import java.util.*;

public class Flattener {
 
    public List<Object> flatten(List<Object> array) {
        List<Object> flatten = new ArrayList<>();

        for (Object element : array) {
            if (element instanceof List) {
                flatten.addAll(flatten((List<Object>) element));
            } else if (element != null) {
                flatten.add(element);
            }
        }

        return flatten;
    }
}



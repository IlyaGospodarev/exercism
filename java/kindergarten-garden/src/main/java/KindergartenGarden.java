import java.util.Arrays;
import java.util.List;

class KindergartenGarden {
    private final String garden;

    KindergartenGarden(String garden) {
        this.garden = garden;
    }

    List<Plant> getPlantsOfStudent(String student) {
        return Arrays.stream(garden.split("\\n")).flatMap(s -> getPlantName(splitIntoTwo(student, s)).stream()).toList();
    }

    private static String splitIntoTwo(String student, String split) {
        return split.split("(?<=\\G.{2})")[student.charAt(0) - 'A'];
    }

    private static List<Plant> getPlantName(String row) {
        return row.chars().mapToObj(i -> Plant.getPlant((char) i)).toList();
    }
}






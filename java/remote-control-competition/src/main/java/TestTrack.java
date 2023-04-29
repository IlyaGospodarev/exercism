import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class TestTrack {

    public static void race(RemoteControlCar car) {
        car.drive();
    }
    public static List<ProductionRemoteControlCar> getRankedCars(List<ProductionRemoteControlCar> rankCars) {
        Collections.sort(rankCars);
        return rankCars;
    }
}

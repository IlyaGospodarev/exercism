public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        double res = 0;
        if (speed <= 4) return res = speed * 221;
        if (speed >= 5 && speed <= 8) return res = (221 * speed) * 90 / 100.0;
        if (speed == 9) return res = (221 * speed) * 80 / 100.0;
        if (speed == 10) return res = (221 * speed) * 77 / 100.0;
        return res;
    }

    public int workingItemsPerMinute(int speed) {
        return (int) productionRatePerHour(speed) / 60;
    }
}

import java.util.Arrays;

class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return birdsPerDay;
    }

    public int getToday() {
        if(birdsPerDay.length == 0) return 0;
        return birdsPerDay[birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length - 1] += 1;
    }

    public boolean hasDayWithoutBirds() {
        return Arrays.stream(birdsPerDay)
                .anyMatch(e -> e == 0);
    }

    public int getCountForFirstDays(int numberOfDays) {
       return Arrays.stream(birdsPerDay)
                .limit(Math.min(numberOfDays, birdsPerDay.length))
                .sum();
    }

    public int getBusyDays() {
        return (int) Arrays.stream(birdsPerDay)
                .filter(e -> e >= 5)
                .count();
    }
}

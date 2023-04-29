class Darts {
    int score(double xOfDart, double yOfDart) {
        double res = Math.sqrt((xOfDart * xOfDart) + (yOfDart * yOfDart));
        
        return res > 10 ? 0 : res > 5 ? 1 : res > 1 ? 5 : 10;
    }
}

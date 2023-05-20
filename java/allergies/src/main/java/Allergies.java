import java.util.List;

public class Allergies {
    private int allergiesScore;

    public Allergies(int allergiesScore) {
        this.allergiesScore = allergiesScore;
    }

    public boolean isAllergicTo(Allergen allergen) {
        return false;
    }

    public List<Allergen> getList() {
        return null;
    }
}

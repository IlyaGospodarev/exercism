public class Twofer {
    public String twofer(String name) {
        name = name == null || name.isBlank() ? "you" : name;
        return String.format("One for %s, one for me.", name);
    }
}

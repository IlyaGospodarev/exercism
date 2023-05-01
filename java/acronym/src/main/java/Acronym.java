class Acronym {
    public static void main(String[] args) {
        Acronym acronym = new Acronym("First In, First Out");
        System.out.println(acronym.get());
    }

    private String phrase;

    Acronym(String phrase) {
        this.phrase = phrase;
    }

    String get() {
        StringBuilder acronym = new StringBuilder();
        for (String word : phrase.toUpperCase().split("[\\s-_,]+")) {
            acronym.append(word.charAt(0));
        }
        return acronym.toString();
    }
}

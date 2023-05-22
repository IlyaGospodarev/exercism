class WordProblemSolver {
    public static void main(String[] args) {
        WordProblemSolver wordProblemSolver = new WordProblemSolver();
        System.out.println(wordProblemSolver.solve("What is -1 plus -10?"));
    }

    int solve(final String wordProblem) {
        String[] split = wordProblem.split(" ");

        for (String s : split) {

            System.out.println(s);

        }

        return 0;
    }
}

public class PascalsTriangleGenerator {
    public int[][] generateTriangle(int num) {
        int[][] triangle = new int[num][];

        for (int i = 0; i < num; i++) {
            triangle[i] = new int[i + 1];
            triangle[i][0] = 1;

            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }

            if (i > 0) {
                triangle[i][i] = 1;
            }
        }

        return triangle;
    }
}
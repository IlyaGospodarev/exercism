import java.util.*;

class Matrix {
    private final List<List<Integer>> matrix;

    Matrix(List<List<Integer>> matrix) {
        this.matrix = matrix;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> saddlePoints = new HashSet<>();

        for (int i = 0; i < matrix.size(); i++) {
            List<Integer> row = matrix.get(i);
            int rowMax = Collections.max(row);
            
            for (int j = 0; j < row.size(); j++) {
                int value = row.get(j);
                
                if (value == rowMax) {
                    int columnMin = Integer.MAX_VALUE;
                    
                    for (int k = 0; k < matrix.size(); k++) {
                        List<Integer> line = matrix.get(k);
                        
                        if (line.size() > j) {
                            columnMin = Math.min(columnMin, line.get(j));
                        }
                    }
                    
                    if (value <= columnMin) {
                        saddlePoints.add(new MatrixCoordinate(i+1, j+1));
                    }
                }
            }    
        }
        return saddlePoints;
    }
}
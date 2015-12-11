public class AlgorithmGauss implements AlgorithmFindDeterminand {

    @Override
    public double findDeterminand(Matrix matrix) {
        Matrix triangularMatrix = null;

        try {
            triangularMatrix = matrix.clone();
        }
        catch (CloneNotSupportedException e) {
            e.getStackTrace();
        }
        makeStraightPassage(triangularMatrix);

        double determinant = 1;

        for (int i = 0; i < triangularMatrix.sizeColumn(); ++i) {
            determinant *= triangularMatrix.getItem(i, i);
        }
        return  determinant;
    }

    private void ChangeLine(int indexFirstLine, int indexSecondLine, Matrix matrix) {
        double temp = 0;

        for (int i = 0; i < matrix.sizeColumn(); ++i) {
            temp = matrix.getItem(indexFirstLine, i);
            matrix.setItem(indexFirstLine, i, matrix.getItem(indexSecondLine, i));
            matrix.setItem(indexSecondLine, i, temp);
        }
    }

    private void makeStraightPassage(Matrix matrix) {
        for (int i = 0; i < matrix.sizeColumn() - 1; ++i) {

            if (matrix.getItem(i, i) == 0) {
                if (!replaceZeroInMainDiagonal(i, matrix)) {
                    continue;
                }
            }
            transformedLineCoefficient(i, matrix);
        }
    }

    private void transformedLineCoefficient(int indexMainLine, Matrix matrix) {
        double coefficient = 0;

        for (int j = indexMainLine + 1; j < matrix.sizeRow(); ++j) {
            coefficient = matrix.getItem(j, indexMainLine) /
                    matrix.getItem(indexMainLine, indexMainLine);

            for (int k = indexMainLine; k < matrix.sizeColumn(); ++k) {
                matrix.setItem(j, k,
                        matrix.getItem(j, k) - matrix.getItem(indexMainLine, k) * coefficient);
            }
        }
    }

    private boolean replaceZeroInMainDiagonal(int indexColumn, Matrix matrix) {
        int indexStartingLine = indexColumn;

        for (int i = 0; i < matrix.sizeRow(); ++i) {

            if (matrix.getItem(i, indexColumn) != 0) {
                ChangeLine(indexStartingLine, i, matrix);
                return true;
            }
        }
        return false;
    }
}

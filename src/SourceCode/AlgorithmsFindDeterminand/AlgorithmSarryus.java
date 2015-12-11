public class AlgorithmSarryus implements AlgorithmFindDeterminand {

    @Override
    public double findDeterminand(Matrix matrix) {
        double determinant = 0;
        Matrix newMatrix = addTwoFirstColumns(matrix);
        int valueThreeParams = 0;

        for (int i = 0; i < 3; ++i) {
            for (int j = 0, shift = 0; j < 3; ++j, ++shift) {
                valueThreeParams *= newMatrix.getItem(j, i + shift);
            }
            determinant += valueThreeParams;
        }
        for (int i = 0; i < 3; ++i) {
            for (int j = 2, shift = 0; j >= 0; --j, ++shift) {
                valueThreeParams *= newMatrix.getItem(j, i + shift);
            }
            determinant -= valueThreeParams;
        }
        return determinant;
    }

    private Matrix addTwoFirstColumns(Matrix matrix) {
        Matrix newMatrix = new Matrix(matrix.sizeRow(), matrix.sizeColumn() + 2);

        for (int i = 0; i < matrix.sizeRow(); ++i) {
            for (int j = 0; j < matrix.sizeColumn(); ++j) {

                newMatrix.setItem(i, j, matrix.getItem(i, j));
            }
        }
        for (int i = matrix.sizeRow(); i < newMatrix.sizeRow(); ++i) {
            for (int j = 0; j < newMatrix.sizeColumn(); ++j) {

                newMatrix.setItem(i, j, matrix.getItem(i - 3, j));
            }
        }
        return newMatrix;
    }
}

public class AlgorithmSarryus implements AlgorithmFindDeterminand {

    @Override
    public double findDeterminand(Matrix matrix) { // сделать копирование
        double determinant = 0;

        Matrix newMatrix = addTwoFirstColumns(matrix);
        int valueThreeParams = 1;

        for (int i = 0; i < 3; ++i) {
            for (int j = 0, shift = 0; j < 3; ++j, ++shift) {
                valueThreeParams *= newMatrix.getItem(j, i + shift);
            }
            determinant += valueThreeParams;
            valueThreeParams = 1;
        }
        for (int i = 0; i < 3; ++i) {
            for (int j = 2, shift = 0; j >= 0; --j, ++shift) {
                valueThreeParams *= newMatrix.getItem(j, i + shift);
            }
            determinant -= valueThreeParams;
            valueThreeParams = 1;
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
        for (int i = matrix.sizeColumn(); i < newMatrix.sizeColumn(); ++i) {
            for (int j = 0; j < newMatrix.sizeRow(); ++j) {

                newMatrix.setItem(j, i, matrix.getItem(j, i - 3));
            }
        }
        return newMatrix;
    }
}

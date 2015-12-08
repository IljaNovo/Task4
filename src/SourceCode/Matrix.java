public class Matrix implements Cloneable {

    int[][] matrix;

    // добавить условие в констуктор при null в агрументе

    public Matrix(int rows, int columns) {

        this.matrix = new int[rows][columns];
    }

    public Matrix(int[][] matrix) {

        this.matrix = matrix;
    }

    public int sizeRow() {

        return this.matrix[0].length;
    }

    public int sizeColumn() {

        return this.matrix.length;
    }

    public Matrix clone() throws CloneNotSupportedException {
        return (Matrix)super.clone();
    }

    public void setItem(int indexRow, int indexColumn, int value) {

        this.matrix[indexRow][indexColumn] = value;
    }

    public int getItem(int indexRow, int indexColumn) {

        return this.matrix[indexRow][indexColumn];
    }

    public static Matrix adding(Matrix left, Matrix right) {

        if (left == null || right == null) {

            return new Matrix(0, 0);
        }

        Matrix answer = new Matrix(left.sizeRow(), left.sizeColumn());

        for (int i = 0; i < answer.sizeRow(); ++i) {
            for (int j = 0; j < answer.sizeColumn(); ++j) {

                answer.setItem(i, j, left.getItem(i, j) + right.getItem(i, j));
            }
        }

        return answer;
    }

    public static Matrix multiply(Matrix left, Matrix right) {

        if ((left.sizeColumn() != right.sizeRow())) {
            return new Matrix(0, 0);
        }

        if (left == null || right == null) {

            return new Matrix(0, 0);
        }

        Matrix answer = new Matrix(left.sizeRow(), left.sizeColumn());

        int newItems = 0;

        for (int i = 0; i < left.sizeRow(); ++i) {
            for (int j = 0; j < right.sizeColumn(); ++j) {
                for (int k = 0; k < left.sizeColumn(); ++k) {

                    newItems += left.getItem(i, k) * right.getItem(k, j);
                }

                answer.setItem(i, j, newItems);
                newItems = 0;
            }
        }

        return answer;
    }

    public int findDeterminant(Matrix matrix) {

        if (matrix == null || matrix.sizeRow() == 0) {
            return 0;
        }

        else if (matrix.sizeRow() == 1) {
            return matrix.getItem(0, 0);
        }

        else if (matrix.sizeRow() == 2) {
            return (matrix.getItem(0, 0) * matrix.getItem(1, 1)) -
                    (matrix.getItem(0, 1) * matrix.getItem(1, 0));
        }

        else if (matrix.sizeRow() == 3) {
            return matrix.findDeterminantSarryus();
        }

        else  {
            return  matrix.findDeterminantGauss();
        }
    }

    private Matrix addTwoFirstColumns() {

        Matrix newMatrix = new Matrix(this.matrix.length, this.matrix.length + 2);

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {

                newMatrix.setItem(i, j, matrix[i][j]);
            }
        }

        for (int i = matrix.length; i < newMatrix.sizeRow(); ++i) {
            for (int j = 0; j < newMatrix.sizeColumn(); ++j) {

                newMatrix.setItem(i, j, matrix[i - 3][j]);
            }
        }

        return newMatrix;
    }

    private int findDeterminantSarryus() {

        int determinant = 0;

        Matrix newMatrix = this.addTwoFirstColumns();

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

    private void ChangeLine(int indexFirstLine, int indexSecondLine) {

        int temp = 0;

        for (int i = 0; i < this.matrix[0].length; ++i) {
            temp = this.matrix[indexFirstLine][i];
            this.matrix[indexFirstLine][i] = this.matrix[indexSecondLine][i];
            this.matrix[indexSecondLine][i] = temp;
        }
    }

    private boolean replaceZeroInMainDiagonal(int indexColumn) {

        int indexStartingLine = indexColumn;
        Matrix matrix = this;

        for (int i = 0; i < matrix.sizeRow(); ++i) {

            if (matrix.getItem(i, indexColumn) != 0) {
                matrix.ChangeLine(indexStartingLine, i);
                return true;
            }
        }

        return false;
    }

    private int findDeterminantGauss() {

        Matrix triangularMatrix = null;

        try {
            triangularMatrix = this.clone();
        }
        catch (CloneNotSupportedException e) {
            e.getStackTrace();
        }

        triangularMatrix.makeStraightpPassage();

        int determinant = 0;

        for (int i = 0; i < triangularMatrix.sizeColumn(); ++i) {
            determinant += triangularMatrix.getItem(i, i);
        }

        return  determinant;
    }

    private void makeStraightpPassage() {

        Matrix triangularMatrix = this;

        for (int i = 0; i < triangularMatrix.sizeColumn() - 1; ++i) {

            if (triangularMatrix.getItem(i, i) == 0) {
                if (!triangularMatrix.replaceZeroInMainDiagonal(i)) {
                    continue;
                }
            }

            triangularMatrix.transformedLineCoefficient(i);
        }

    }

    private void transformedLineCoefficient(int indexMainLine) {

        Matrix triangularMatrix = this;

        int coefficient = 0;

        for (int j = indexMainLine + 1; j < triangularMatrix.sizeRow(); ++j) {

            coefficient = triangularMatrix.getItem(j, indexMainLine) /
                    triangularMatrix.getItem(indexMainLine, indexMainLine);

            for (int k = indexMainLine; j < triangularMatrix.sizeColumn(); ++k) {
                triangularMatrix.setItem(j, k,
                        triangularMatrix.getItem(j, k) - triangularMatrix.getItem(indexMainLine, k) * coefficient);
            }
        }
    }

}

public class Matrix {

    int[][] matrix;

    public Matrix(int rows, int columns) {

        this.matrix = new int[rows][columns];
    }

    public int sizeRow() {

        return this.matrix.length;
    }

    public int sizeColumn() {

        return this.matrix[0].length;
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
}

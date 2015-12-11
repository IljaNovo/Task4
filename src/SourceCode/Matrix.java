public class Matrix implements Cloneable {

    private double[][] matrix;

    public Matrix(int rows, int columns){
        if (rows < 0 || columns < 0) {
            throw new NegativeIndexOfMatrixExeption("Used negative indexs.");
        }
        this.matrix = new double[rows][columns];
    }

    public Matrix(double[][] matrix) {
        if (matrix == null) {
            this.matrix = new double[1][1];
            return;
        }
        this.matrix = new double[matrix.length][matrix[0].length];

        for (int i = 0; i < this.matrix.length; ++i) {
            this.matrix[i] = matrix[i].clone();
        }
    }

    public int sizeRow() {
        return this.matrix.length;
    }

    public int sizeColumn() {
        return this.matrix[0].length;
    }

    public Matrix clone() throws CloneNotSupportedException {
        Matrix clone = (Matrix)super.clone();
        clone.matrix = new double[matrix.length][matrix[0].length];

        for (int i = 0; i < clone.sizeRow(); ++i) {
            clone.matrix[i] = this.matrix[i].clone();
        }
        return clone;
    }

    public void setItem(int indexRow, int indexColumn, double value) {
        if (indexRow < 0 || indexColumn < 0) {
            throw new NegativeIndexOfMatrixExeption("Used negative Indexs.");
        }
        if (indexRow > this.sizeRow() || indexColumn > this.sizeColumn()) {
            throw new MatrixOfBoundExeption("Iindex outside the Matrix.");
        }
        this.matrix[indexRow][indexColumn] = value;
    }

    public double getItem(int indexRow, int indexColumn) {
        if (indexRow < 0 || indexColumn < 0) {
            throw new NegativeIndexOfMatrixExeption("Used negative Indexs.");
        }
        if (indexRow > this.sizeRow() || indexColumn > this.sizeColumn()) {
            throw  new  MatrixOfBoundExeption("Iindex outside the Matrix.");
        }
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
        if ((left.sizeColumn() != right.sizeRow())) {
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

    public double findDeterminant() {
        double determinant = 0;

        switch (this.sizeRow()) {
            case 0:
                determinant = 0;
                break;
            case 1:
                determinant = this.getItem(0, 0);
                break;
            case 2:
                determinant = (this.getItem(0, 0) * this.getItem(1, 1)) -
                        (this.getItem(0, 1) * this.getItem(1, 0));
                break;
            case 3:
                AlgorithmFindDeterminand algFindDetermSarryus = new AlgorithmSarryus();
                determinant = algFindDetermSarryus.findDeterminand(this);
                break;
            default:
                AlgorithmFindDeterminand algFindDetermGauss = new AlgorithmGauss();
                determinant = algFindDetermGauss.findDeterminand(this);
                break;
        }
        return determinant;
    }
}

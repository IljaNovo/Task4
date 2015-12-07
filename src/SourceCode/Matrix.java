public class Matrix {

    int[][] matrix;

    public Matrix(int rows, int columns) {

        this.matrix = new int[rows][columns];
    }

    public void setItem(int indexRow, int indexColumn, int value) {

        this.matrix[indexRow][indexColumn] = value;
    }

    public int getItem(int indexRow, int indexColumn) {

        return this.matrix[indexRow][indexColumn];
    }

    
}

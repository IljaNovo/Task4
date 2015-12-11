import org.junit.Test;
import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void testMultiplyParamNull() throws Exception {
        Matrix answer = Matrix.multiply(null, null);

        assertTrue(answer.sizeRow() == 0);
    }

    @Test
    public void testAddingParamNull() throws Exception {
        Matrix answer = Matrix.adding(null, null);

        assertTrue(answer.sizeRow() == 0);
    }

    @Test
    public void testSizeRow() throws Exception {
        Matrix matrix = new Matrix(5, 4);
        assertEquals(matrix.sizeRow(), 5);
    }

    @Test
    public void testSizeColumn() throws Exception {
        Matrix matrix = new Matrix(4, 5);
        assertEquals(matrix.sizeColumn(), 5);
    }

    @Test
    public void testSetItem() throws Exception {
        Matrix matrix = new Matrix(4, 5);
        matrix.setItem(0, 0, 10.0);
        assertTrue(Math.abs(matrix.getItem(0, 0) - 10.0) < 0.00001);
    }

    @Test
    public void testGetItem() throws Exception {
        Matrix matrix = new Matrix(4, 5);
        assertTrue(Math.abs(matrix.getItem(0, 0) - 0.0) < 0.00001);
    }

    @Test
    public void testAdding() throws Exception {
        Matrix first = new Matrix(2 ,2);
        Matrix second = new Matrix(2 ,2);

        for (int i = 0; i < first.sizeRow(); ++i){
            for (int j = 0; j < first.sizeColumn(); ++j) {
                first.setItem(i, j, 1);
                second.setItem(i, j, 1);
            }
        }

        Matrix answer = Matrix.adding(first, second);
        boolean arraysEqual = true;

        for (int i = 0; i < answer.sizeRow(); ++i){
            for (int j = 0; j < answer.sizeColumn(); ++j) {
                if (answer.getItem(i, j) != 2) {
                    arraysEqual = false;
                }
            }
        }

        assertTrue(arraysEqual);
    }

    @Test
    public void testMultiply() throws Exception {
        double[][] matrix = {{1, 2},
                             {3, 4}};
        Matrix first = new Matrix(matrix.clone());
        Matrix second = new Matrix(matrix.clone());
        double[][] patternAnswer = {{7, 10},
                                    {15, 22}};
        Matrix answer = Matrix.multiply(first, second);
        boolean arraysEqual = true;

        for (int i = 0; i < answer.sizeRow(); ++i){
            for (int j = 0; j < answer.sizeColumn(); ++j) {
                if (answer.getItem(i, j) != patternAnswer[i][j]) {
                    arraysEqual = false;
                }
            }
        }
        assertTrue(arraysEqual);
    }

    @Test
    public void testFindDeterminantSizeOne() throws Exception {
        Matrix matrix = new Matrix(1, 1);
        matrix.setItem(0, 0, 4);

        assertTrue(Math.abs(matrix.findDeterminant() - matrix.getItem(0, 0)) < 0.00001);
    }

    @Test
    public void testFindDeterminantSizeTwo() throws Exception {
        double[][] initialData = {{1, 2},
                                  {3, 4}};
        Matrix matrix = new Matrix(initialData.clone());

        assertTrue(Math.abs(matrix.findDeterminant() - (-2.0)) < 0.00001);
    }

    @Test
    public void testFindDeterminantSizeThree() throws Exception {
        double[][] initialData = {{5, 2, 3},
                                  {4, 6, 6},
                                  {-7, 8, 9}};
        Matrix matrix = new Matrix(initialData.clone());
        double d = matrix.findDeterminant();

        assertTrue(Math.abs(matrix.findDeterminant() - 96.0) < 0.00001);
    }

    @Test
    public void testFindDeterminantSizeFour() throws Exception {
        double[][] initialData = {{3, -3, -5, 8},
                                  {-3, 2, 4, -6},
                                  {2, -5, -7, 5},
                                  {-4, 3, 5, -6}};
        Matrix matrix = new Matrix(initialData.clone());
        double det = matrix.findDeterminant();

        assertTrue(Math.abs(det - 18.0) < 0.1);
    }
}
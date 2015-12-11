public class main {

    public static void main(String[] args) {
        Matrix matrixFirst = new Matrix(2, 2);

        matrixFirst.setItem(0, 0, 1);
        matrixFirst.setItem(0, 1, 2);
        matrixFirst.setItem(1, 0, 3);
        matrixFirst.setItem(1, 1, 4);

        Matrix matrixSecond = null;

        try {
            matrixSecond = matrixFirst.clone();
        }
        catch (CloneNotSupportedException e) {
            e.getStackTrace();
        }

        matrixSecond.setItem(0, 0, 11);

        int i = 0;
    }
}

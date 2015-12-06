import java.util.Random;

public class ArrayUntil {

    public static int[] reduceNumberElemsTo(int[] arrayElems, int count) {

        if (arrayElems == null) {
            return new int[0];
        }
        if (count < 0 || arrayElems.length <= count) {
            return arrayElems;
        }

        int[] newArrayElems = new int[count];

        copyValues(newArrayElems, arrayElems, count);

        return newArrayElems;
    }

    public static int[] extensionNumberElemsTo(int[] arrayElems, int count) {

        if (arrayElems == null) {
            return new int[0];
        }
        if (count < 0 || arrayElems.length >= count) {
            return arrayElems;
        }

        int[] newArrayElems = new int[count];

        copyValues(newArrayElems, arrayElems, arrayElems.length);

        return newArrayElems;
    }

    private static void copyValues(int[] arrayFirst, int[] arraySecond, int count) {

        if (arrayFirst == null || arraySecond == null || count < 0) {
            return;
        }

        if (arrayFirst.length < arraySecond.length) {
            return;
        }

        for (int i = 0; i < count && i < arraySecond.length; ++i) {

            arrayFirst[i] = arraySecond[i];
        }
    }

    public static boolean compareArrays(int[] arrayFirst, int[] arraySecond) {

        if (arrayFirst == null || arraySecond == null) {
            return false;
        }
        if (arrayFirst.length != arraySecond.length) {
            return false;
        }

        return compare(arrayFirst, arraySecond);
    }

    private static boolean compare(int[] arrayFirst, int[] arraySecond) {

        boolean[] viewedItems = new boolean[arraySecond.length];

        int countSimilarItems = 0;

        for(int i = 0; i < arrayFirst.length; ++i) {
            for (int j = 0; j < arraySecond.length; ++j) {

                if (!viewedItems[j] && arrayFirst[i] == arraySecond[j]) {
                    viewedItems[j] = true;
                    ++countSimilarItems;
                    break;
                }
            }
        }

        if (countSimilarItems == arrayFirst.length) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void shuffleElems(int[] array) {

        if (array == null) {
            return;
        }

        Random r = new Random();
        int countMixings = 100;
        int temp = 0;
        int indexFirstItem = 0;
        int indexSecondItem = 0;

        for (int i = 0; i < countMixings; ++i) {

            indexFirstItem = r.nextInt(array.length - 1);
            indexSecondItem = r.nextInt(array.length - 1);

            temp = array[indexFirstItem];
            array[indexFirstItem] = array[indexSecondItem];
            array[indexSecondItem] = temp;
        }
    }
}
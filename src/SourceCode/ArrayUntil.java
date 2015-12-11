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

                if ( (!viewedItems[j]) && (arrayFirst[i] == arraySecond[j]) ) {
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

    public static int[] shuffleElems(int[] array, int countMixings) {
        if (array == null) {
            return new int[0];
        }
        int[] mixingsArray = array.clone();
        Random r = new Random();
        int temp = 0;
        int indexFirstItem = 0;
        int indexSecondItem = 0;

        for (int i = 0; i < countMixings; ++i) {
            indexFirstItem = r.nextInt(mixingsArray.length - 1);
            indexSecondItem = r.nextInt(mixingsArray.length - 1);

            temp = mixingsArray[indexFirstItem];
            mixingsArray[indexFirstItem] = mixingsArray[indexSecondItem];
            mixingsArray[indexSecondItem] = temp;
        }
        return mixingsArray;
    }

    public static String print(int[] array) {
        String answer = "";

        for (int i = 0; i < array.length - 1; ++i) {
            answer += String.format("array[%d] = %d;%n", i, array[i]);
        }
        answer += String.format("array[%d] = %d.", array.length - 1, array[array.length - 1]);

        return answer;
    }
}
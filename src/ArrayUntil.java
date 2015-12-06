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
}
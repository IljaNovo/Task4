import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUntilTest {

    @Test
    public void testReduceNumberElems() throws Exception {

        int[] array = new int[10];

        int[] newArray = ArrayUntil.reduceNumberElemsTo(array, 5);

        assertTrue(array.length > newArray.length);
    }

    @Test
    public void testNullInParamsReduce() throws Exception {

        int[] array = null;

        int[] newArray = ArrayUntil.reduceNumberElemsTo(array, 5);

        assertTrue(newArray.length == 0);
    }

    @Test
    public void testEnterWrongReduction() throws Exception {

        int[] array = new int[5];

        int[] newArray = ArrayUntil.reduceNumberElemsTo(array, 10);

        assertTrue(newArray.length == 5);
    }

    @Test
    public void testEnterMinusReduction() throws Exception {

        int[] array = new int[5];

        int[] newArray = ArrayUntil.reduceNumberElemsTo(array, -10);

        assertTrue(newArray.length == 5);
    }

    ///////////////////////////////////////////////////////////////////////////

    @Test
    public void testExtensionNumberElems() throws Exception {

        int[] array = new int[10];

        int[] newArray = ArrayUntil.extensionNumberElemsTo(array, 15);

        assertTrue(array.length < newArray.length);
    }

    @Test
    public void testNullInParamsExtension() throws Exception {

        int[] array = null;

        int[] newArray = ArrayUntil.extensionNumberElemsTo(array, 5);

        assertTrue(newArray.length == 0);
    }

    @Test
    public void testEnterWrongExtension() throws Exception {

        int[] array = new int[5];

        int[] newArray = ArrayUntil.extensionNumberElemsTo(array, 3);

        assertTrue(newArray.length == 5);
    }

    @Test
    public void testEnterMinusExtension() throws Exception {

        int[] array = new int[5];

        int[] newArray = ArrayUntil.extensionNumberElemsTo(array, -10);

        assertTrue(newArray.length == 5);
    }

    ////////////////////////////////////////////////////////////////////

    @Test
    public void testCompareNotIdenticalArrays() throws Exception {

        int[] arrayFirst = {1, 2, 3, 4, 6};

        int[] arraySecond = {2, 4, 5, 3, 1};

        assertFalse(ArrayUntil.compareArrays(arrayFirst, arraySecond));
    }

    @Test
    public void testNullInParamsCompare() throws Exception {

        int[] arrayFirst = null;

        int[] arraySecond = null;

        assertFalse(ArrayUntil.compareArrays(arrayFirst, arraySecond));
    }

    ////////////////////////////////////////////////////////////////////

    @Test
    public void testShuffleArray() throws Exception {

        // Я не смог придумать тест в котором не было бы 100%-го совпадения после премешки.
        // Поэтому я взял больше чисел в массиве и увеличил количество перемешиваний.

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        int[] newArray = array.clone();

        newArray = ArrayUntil.shuffleElems(newArray, 100);

        assertTrue(ArrayUntil.compareArrays(array, newArray));
    }

    @Test
    public void testNullInArray() throws Exception {

        int[] array = null;

        int[] mixingsArray = ArrayUntil.shuffleElems(array, 2);

        assertTrue(mixingsArray.length == 0);
    }


}
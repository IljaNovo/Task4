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


}
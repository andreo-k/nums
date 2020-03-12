package andrey.co;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.math.BigDecimal;

public class NumsTest extends TestCase {

    public NumsTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( NumsTest.class );
    }

    public void testNoEmits() {

        Nums nums = new Nums();

        assertNull(nums.getAvg());
        assertNull(nums.getMin());
        assertNull(nums.getMax());
    }

    public void testOneEmit() {
        Nums nums = new Nums();

        nums.emit(1);

        assertTrue(nums.getAvg().compareTo(BigDecimal.ONE) == 0);
        assertTrue(nums.getMin().compareTo(BigDecimal.ONE) == 0);
        assertTrue(nums.getMax().compareTo(BigDecimal.ONE) == 0);
    }

    public void testBigNum() {
        Nums nums = new Nums();
        String sNum = "12345678901234567890123456789012345678901234567890";
        BigDecimal expected = new BigDecimal(sNum);

        nums.emit(sNum);

        assertTrue(nums.getAvg().compareTo(expected) == 0);
        assertTrue(nums.getMin().compareTo(expected) == 0);
        assertTrue(nums.getMax().compareTo(expected) == 0);
    }

    public void testWrongString() {
        Nums nums = new Nums();
        try {
            nums.emit("xyz");
            fail("expected exception");
        } catch(NumberFormatException e) {
        }
    }

    public void testSmallNums() {
        Nums nums = new Nums();

        nums.emit(1);
        nums.emit(2);
        nums.emit(3);
        nums.emit(4);
        nums.emit(5);

        assertTrue(nums.getAvg().compareTo(new BigDecimal(3)) == 0);
        assertTrue(nums.getMin().compareTo(BigDecimal.ONE) == 0);
        assertTrue(nums.getMax().compareTo(BigDecimal.valueOf(5)) == 0);
    }

    public void testSmallNegative() {
        Nums nums = new Nums();

        nums.emit(1);
        nums.emit(2);
        nums.emit(3);
        nums.emit(4);
        nums.emit(-5);

        assertTrue(nums.getAvg().compareTo(new BigDecimal(1)) == 0);
        assertTrue(nums.getMin().compareTo(BigDecimal.valueOf(-5)) == 0);
        assertTrue(nums.getMax().compareTo(BigDecimal.valueOf(4)) == 0);
    }


    public void testHugeNumbers() {
        Nums nums = new Nums();

        nums.emit("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
        nums.emit("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
        nums.emit("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
        nums.emit("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
        nums.emit("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
        nums.emit("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
        nums.emit("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");


        assertTrue(nums.getAvg().compareTo(new BigDecimal("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999")) == 0);
        assertTrue(nums.getMin().compareTo(new BigDecimal("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999")) == 0);
        assertTrue(nums.getMax().compareTo(new BigDecimal("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999")) == 0);
    }

    public void testSpecial() {
        Nums nums = new Nums();

        try {
            nums.emit(Double.NEGATIVE_INFINITY);
            nums.emit(Double.POSITIVE_INFINITY);
            fail("expected number format exception");
        } catch (NumberFormatException e) {
        }
    }

}

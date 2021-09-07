import exeption.ConstructorException;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleFractionTest {
    SimpleFraction f = new SimpleFraction(4, 5);

    public SimpleFractionTest() throws ConstructorException {
    }

    @Test
    public void testFractionConstructionSimple() throws Exception {
        assertArrayEquals(new SimpleFraction(4, 5).getAB(), new int[]{4, 5});
        assertArrayEquals(new SimpleFraction(5, 4).getAB(), new int[]{5, 4});
        assertArrayEquals(new SimpleFraction(0, 4).getAB(), new int[]{0, 4});
    }

    @Test
    public void testFractionConstructionSimplify() throws Exception {
        assertArrayEquals(new SimpleFraction(10, 35).getAB(), new int[]{2, 7});
        assertArrayEquals(new SimpleFraction(35, 10).getAB(), new int[]{7, 2});
    }

    @Test
    public void testFractionConstructionString() throws Exception {
        assertArrayEquals(new SimpleFraction("4/5").getAB(), new int[]{4, 5});
        assertArrayEquals(new SimpleFraction("10/35").getAB(), new int[]{2, 7});
    }

    @Test(expected = ConstructorException.class)
    public void testCreateTempFile() throws ConstructorException {
        new SimpleFraction("4/0");
        new SimpleFraction(4, 0);
    }

    @Test
    public void testFractionCopy() {
        assertEquals(f, f.copy());
    }

    @Test
    public void testFractionAddition() throws Exception {
        assertEquals(f.addition(new SimpleFraction(6, 10)), new SimpleFraction(7, 5));
    }

    @Test
    public void testFractionSubtraction() throws Exception {
        assertEquals(f.subtraction(new SimpleFraction(6, 10)), new SimpleFraction(1, 5));
    }

    @Test
    public void testFractionMultiplication() throws Exception {
        assertEquals(f.multiplication(new SimpleFraction(6, 10)), new SimpleFraction(12, 25));
    }

    @Test
    public void testFractionDivision() throws Exception {
        assertEquals(f.division(new SimpleFraction(6, 10)), new SimpleFraction(40, 30));
    }

    @Test
    public void testFractionSquare() throws Exception {
        assertEquals(f.square(), new SimpleFraction(16, 5));
    }

    @Test
    public void testFractionInverse() throws Exception {
        assertEquals(f.inverse(), new SimpleFraction(5, 4));
    }

    @Test
    public void testFractionMinus() throws Exception {
        assertEquals(f.minus(), new SimpleFraction(-4, 5));
    }

    @Test
    public void testGetA() {
        assertEquals(f.getA(), 4);
    }

    @Test
    public void testGetB() {
        assertEquals(f.getB(), 5);
    }

    @Test
    public void testGetStringA() {
        assertEquals(f.getStringA(), "4");
    }

    @Test
    public void testGetStringB() {
        assertEquals(f.getStringB(), "5");
    }

    @Test
    public void testGetStringFraction() {
        assertEquals(f.getStringFraction(), "4/5");
    }

    @Test
    public void testFractionCompare() throws Exception {
        assertFalse(f.compare(new SimpleFraction(10, 6)));
        assertFalse(f.compare(new SimpleFraction(4, 5)));
        assertTrue(f.compare(new SimpleFraction(-10, 6)));
    }
}
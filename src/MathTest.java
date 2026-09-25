import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static java.lang.Math.negateExact;
import static java.lang.Math.pow;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class MathTest {

    @ParameterizedTest
    @CsvSource({
            "6, 5",
            "1.5, 3.7",
            "-3.4, -5.2",
            "-2, -4",
            "5, -6",
            "3.5, -4.3",
            "-4, 6",
            "-6.4, 5.98",
            "0, 0",
            "0, -1.4",
            "0, -4",
            "0, 1.4",
            "0, 4",
            "1, 0",
            "1, -1.4",
            "1, -4",
            "1, 1.4",
            "1, 4",
            "-1, 0",
            "-1, -1.4",
            "-1, -4",
            "-1, 1.4",
            "-1, 4",
            "0, 1",
            "-1.4, 1",
            "-4, 1",
            "1.4, 1",
            "4, 1"
    })
    public void testReciprocal(double base, double exponent) {
        Assertions.assertEquals(1 / pow(base, exponent),
                pow(base, (exponent * -1)
                ), "base to the power of -a is equal to 1/base to the power of a");
    }
    // need to make exponent negative


    @ParameterizedTest
    @CsvSource({
            "6, 5, 17",
            "5, 2, -3",
            "3, -3, -4",
            "-7, 2, 4",
            "-4, -5, 2",
            "-7, -8, -9",
            "6.3, 5.5, 17.3",
            "5.25, 2.4, -3.2",
            "3.4, -3.3, -4.2",
            "-7.5, 2.2, 4.6",
            "-4.3, -5.2, 2.1",
            "-7.4, -8.3, -9.2"
    })
    public void testMultiplying(double base, double a, double b) {
        Assertions.assertEquals(pow(base, a + b),
                pow(base, a) * pow(base, b), 0.00000001,
                "base to the power of a times base to te power of b should equal 8");
    }


    @ParameterizedTest
    @CsvSource({
            "6, 5, 17",
            "5, 2, -3",
            "3, -3, -4",
            "-7, 2, 4",
            "-4, -5, 2",
            "-7, -8, -9",
            "6.3, 5.5, 17.3",
            "5.25, 2.4, -3.2",
            "3.4, -3.3, -4.2",
            "-7.5, 2.2, 4.6",
            "-4.3, -5.2, 2.1",
            "-7.4, -8.3, -9.2"
    })
    public void testDividing(double base, double a, double b) {
        Assertions.assertEquals(pow(base, a - b),
                pow(base, a) / pow(base, b),
                "base to the power of a divided by base to the power of b is equal to base to the power of a-b");
    }


    @ParameterizedTest
    @CsvSource({
            "6, 5, 17",
            "5, 2, -3",
            "3, -3, -4",
            "-7, 2, 4",
            "-4, -5, 2",
            "-7, -8, -9",
            "6.3, 5.5, 17.3",
            "5.25, 2.4, -3.2",
            "3.4, -3.3, -4.2",
            "-7.5, 2.2, 4.6",
            "-4.3, -5.2, 2.1",
            "-7.4, -8.3, -9.2"
    })
    public void testNestedPowers(double base, double a, double b) {
        double hi = pow(base, a);
        Assertions.assertEquals(pow(base, a * b),
                pow(hi, b),
                "base to the power of a to the power of b is equal to x to the power of a*b");


    }


    @ParameterizedTest
    @ValueSource(doubles = {1, 5.0, 3.7, -1, -4.0, -4.9})
    public void testZeroPower(double base) {
        Assertions.assertEquals(1,
                pow(base, 0),
                "base to the power of 0 is equal to 1");

    }


    @ParameterizedTest
    @ValueSource(doubles = {1, 5.0, 3.7, -1, -4.0, -4.9})
    public void testOnePower(double base) {
        Assertions.assertEquals(base,
                pow(base, 1),
                "Base to the power of 1 is equal to base");
    }


    @ParameterizedTest
    @ValueSource(doubles = {1, 5.0, 3.7, -1, -4.0, -4.9})
    public void testZeroBase(double exponent) {
        if (exponent < 0) {
            Assertions.assertEquals(1.0 / 0, pow(0, exponent),
                    "0 raised to the power by a negative exponent and becomes infinity");
        } else {
            Assertions.assertEquals(0,
                    pow(0, exponent),
                    "0 to the power of the exponent is equal to zero");
        }
    }
}
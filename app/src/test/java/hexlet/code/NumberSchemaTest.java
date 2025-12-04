package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberSchemaTest {
    private static final int FIVE = 5;
    private static final int TEN = 10;
    private static final int NEGATIVE_FIVE = -5;
    private static final int ONE_HUNDRED = 100;

    @Test
    public void testRequired() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        assertTrue(schema.isValid(FIVE));
        assertTrue(schema.isValid(null));
        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(FIVE));
    }
    @Test
    public void testPositive() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        assertTrue(schema.isValid(FIVE));
        assertTrue(schema.isValid(NEGATIVE_FIVE));
        schema.positive();
        assertTrue(schema.isValid(FIVE));
        assertFalse(schema.isValid(NEGATIVE_FIVE));
    }
    @Test
    public void testRange() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        assertTrue(schema.isValid(FIVE));
        schema.range(FIVE, TEN);
        assertTrue(schema.isValid(FIVE));
        assertFalse(schema.isValid(ONE_HUNDRED));
    }
    @Test
    public void testCombined() {
        Validator v = new Validator();
        NumberSchema schema = v.number().required().positive().range(FIVE, ONE_HUNDRED);
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(FIVE));
        assertFalse(schema.isValid(NEGATIVE_FIVE));
    }
}

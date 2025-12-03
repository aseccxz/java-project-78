package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberSchemaTest {
    @Test
    public void testRequired() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(null));
        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(5));
    }
    @Test
    public void testPositive() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(-5));
        schema.positive();
        assertTrue(schema.isValid(5));
        assertFalse(schema.isValid(-5));
    }
    @Test
    public void testRange() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        assertTrue(schema.isValid(5));
        schema.range(5, 10);
        assertTrue(schema.isValid(5));
        assertFalse(schema.isValid(100));
    }
    @Test
    public void testCombined() {
        Validator v = new Validator();
        NumberSchema schema = v.number().required().positive().range(5, 10);
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(5));
        assertFalse(schema.isValid(-5));
    }
}

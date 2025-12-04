package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringSchemaTest {
    private static final int FIVE = 5;
    private static final int ONE = 1;
    private static final int ONE_HUNDRED = 100;
    @Test
    public void testRequired() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));
        schema.required();
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid("what does the fox say"));
    }
    @Test
    public void testContains() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        assertTrue(schema.contains("what").isValid("what does the fox say"));
        assertFalse(schema.contains("what").isValid("Hello"));
        assertFalse(schema.contains("what").isValid(null));
    }
    @Test
    public void testMinLength() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        assertTrue(schema.minLength(FIVE).isValid("what does the fox say"));
        assertFalse(schema.minLength(ONE_HUNDRED).isValid("Hello"));
        assertFalse(schema.minLength(ONE).isValid(null));
    }
    @Test
    public void testCombined() {
        Validator v = new Validator();
        StringSchema schema = v.string().required().minLength(FIVE).contains("hex");
        assertTrue(schema.isValid("hexagon"));
        assertFalse(schema.isValid("dragon"));
        assertFalse(schema.isValid("hex"));
    }
}

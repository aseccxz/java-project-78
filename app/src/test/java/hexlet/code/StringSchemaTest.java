package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringSchemaTest {

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
        assertTrue(schema.minLength(5).isValid("what does the fox say"));
        assertFalse(schema.minLength(100).isValid("Hello"));
        assertFalse(schema.minLength(1).isValid(null));
    }
    @Test
    public void testCombined() {
        Validator v = new Validator();
        StringSchema schema = v.string().required().minLength(5).contains("hex");
        assertTrue(schema.isValid("hexagon"));
        assertFalse(schema.isValid("dragon"));
        assertFalse(schema.isValid("hex"));
    }
}

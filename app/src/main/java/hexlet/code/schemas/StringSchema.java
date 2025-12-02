package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema<String> {

    @Override
    public StringSchema required() {
        Predicate<String> rule = value -> value != null && !value.isEmpty();
        rules.put("required", rule);
        return this;
    }
    public StringSchema minLength(int length) {
        Predicate<String> rule = value -> {
            if (value == null) {
                return false;
            }
            return value.length() >= length;
        };
        rules.put("minLength", rule);
        return this;
    }
    public StringSchema contains(String substring) {
        Predicate<String> rule = value -> {
            if (value == null) {
                return false;
            }
            return value.contains(substring);
        };
        rules.put("contains", rule);
        return this;
    }
}

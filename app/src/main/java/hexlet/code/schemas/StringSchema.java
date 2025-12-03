package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<String> {

    @Override
    public StringSchema required() {
        Predicate<String> rule = value -> value != null && !value.isEmpty();
        super.addRule("range", rule);
        return this;
    }
    public StringSchema minLength(int length) {
        Predicate<String> rule = value -> {
            if (value == null) {
                return false;
            }
            return value.length() >= length;
        };
        super.addRule("minLength", rule);
        return this;
    }
    public StringSchema contains(String substring) {
        Predicate<String> rule = value -> {
            if (value == null) {
                return false;
            }
            return value.contains(substring);
        };
        super.addRule("contains", rule);
        return this;
    }
}

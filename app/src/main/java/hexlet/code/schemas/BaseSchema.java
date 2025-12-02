package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class BaseSchema <T> {
    protected Map<String, Predicate<T>> rules = new HashMap<>();

    public BaseSchema<T> required() {
        Predicate<T> rule = Objects::nonNull;
        rules.put("required", rule);
        return this;
    }

    public boolean isValid(T value) {
        for (Predicate<T> rule : rules.values()) {
            if(!rule.test(value)) {
                return false;
            }
        }
        return true;
    }
}

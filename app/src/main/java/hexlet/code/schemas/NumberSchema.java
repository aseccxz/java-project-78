package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema<Integer> {
    @Override
    public NumberSchema required() {
        super.required();
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> rule = value -> value != null && value > 0;
        rules.put("positive", rule);
        return this;
    }
    public NumberSchema range (int min, int max) {
        Predicate<Integer> rule = value -> value != null && value >= min && value <= max;
        rules.put("range", rule);
        return this;
    }
}

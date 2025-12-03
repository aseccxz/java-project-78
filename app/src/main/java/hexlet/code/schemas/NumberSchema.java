package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema<Integer> {
    @Override
    public NumberSchema required() {
        super.required();
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> rule = value -> value != null && value > 0;
        super.addRule("positive", rule);
        return this;
    }
    public NumberSchema range(int min, int max) {
        Predicate<Integer> rule = value -> value != null && value >= min && value <= max;
        super.addRule("range", rule);
        return this;
    }
}

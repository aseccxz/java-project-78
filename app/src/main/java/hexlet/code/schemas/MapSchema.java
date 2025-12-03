package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema<Map<?, ?>> {

    @Override
    public MapSchema required() {
        super.required();
        return this;
    }

    public MapSchema sizeof(int size) {
        Predicate<Map<?, ?>> rule = value -> value.size() == size;
        super.addRule("sizeof", rule);
        return this;
    }

}

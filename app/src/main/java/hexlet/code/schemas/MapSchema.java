package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema<Map<?, ?>> {

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
    public <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {
        Predicate<Map<?, ?>> rule = value -> {
            for (var key : value.keySet()) {
                if (!schemas.get(key).isValid((T) value.get(key))) {
                    return false;
                }
            }
            return true;
        };
        super.addRule("shape", rule);
        return this;
    }
}

package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Базовый класс для всех схем валидации.
 * @param <T> тип значения для валидации
 */
public class BaseSchema<T> {
    private Map<String, Predicate<T>> rules = new HashMap<>();

    public Map<String, Predicate<T>> getRules() {
        return rules;
    }

    /**
     * Метод для добавления правила валидации в коллекцию Map.
     * @param key ключ-имя правила
     * @param rule правило валидации
     */
    public void addRule(String key, Predicate<T> rule) {
        this.rules.put(key, rule);
    }

    /**
     * Помечает поле как обязательное для заполнения.
     * @return this для поддержки fluent interface
     */
    public BaseSchema<T> required() {
        Predicate<T> rule = Objects::nonNull;
        this.addRule("required", rule);
        return this;
    }

    /**
     * Метод для проверки значения на соответствие правилам валидации.
     * @param value значение проверяемое на валидность
     * @return true если все правила выполнены false если нет
     */
    public boolean isValid(T value) {
        for (Predicate<T> rule : rules.values()) {
            if (!rule.test(value)) {
                return false;
            }
        }
        return true;
    }
}

### Hexlet tests and linter status:
[![Actions Status](https://github.com/aseccxz/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/aseccxz/java-project-78/actions)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=aseccxz_java-project-78&metric=coverage)](https://sonarcloud.io/summary/new_code?id=aseccxz_java-project-78)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=aseccxz_java-project-78&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=aseccxz_java-project-78)
## Валидатор данных ##
Этот проект – библиотека, с помощью которой можно проверять корректность данных.  
Возможности библиотека:  
* Поддержка основных форматов данных: int и String  
* Работа с коллекцией Map и возможностью задавать разные параметры валидации для разных ключей проверяемой коллекции
Для запуска утилиты требуется передать два обязательных параметра - относительные или абсолютные пути для файлов и один необязательный - -f или --format  
Пример:   
```/import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.BaseSchema;

Validator v = new Validator();

// Строки
StringSchema schema = v.string().required();

schema.isValid("what does the fox say"); // true
schema.isValid(""); // false

// Числа
NumberSchema schema = v.number().required().positive();

schema.isValid(-10); // false
schema.isValid(10); // true

// Объект Map с поддержкой проверки структуры
Map<String, BaseSchema<String>> schemas = new HashMap<>();
schemas.put("firstName", v.string().required());
schemas.put("lastName", v.string().required().minLength(2));

MapSchema schema = v.map().sizeof(2).shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("firstName", "John");
human1.put("lastName", "Smith");
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("firstName", "Anna");
human2.put("lastName", "B");
schema.isValid(human2); // false```

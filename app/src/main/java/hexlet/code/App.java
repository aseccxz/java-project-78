package hexlet.code;

import hexlet.code.schemas.StringSchema;

public class App {
    public static void main (String[] args) {
        Validator v = new Validator();
        StringSchema schema = v.string();
        schema.required();
        schema.contains("wghfd");
        System.out.println(
                schema.isValid("what does the fox say") // true
        );
        var schema1 = v.string();
        System.out.println(
                schema1.minLength(10).isValid("Hexlet")
        );

    }

}

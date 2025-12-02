package hexlet.code;

import hexlet.code.schemas.StringSchema;

public class App {
    public static void main (String[] args) {
        Validator v = new Validator();
        StringSchema schema = v.string();
        //schema.required();
        System.out.println(
                schema.isValid(null) // true
        );
    }

}

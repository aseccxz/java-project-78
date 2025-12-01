package hexlet.code.schemas;

public class StringSchema {
    private boolean required = false;
    private int minLength = 0;
    private String mustContain = null;

    public StringSchema required() {
        this.required = true;
        return this;
    }
    public StringSchema minLength(int length) {
        this.minLength = length;
        return this;
    }
    public StringSchema contains(String substring) {
        this.mustContain = substring;
        return this;
    }
    public boolean isValid(String line) {
        boolean notNull = true;
        boolean validLength = true;
        boolean containsSubstring = true;
        if (required) {
            notNull = line != null && !line.isEmpty();
        }
        if(line != null) {
            validLength =  line.length() >= minLength;
        }
        if (mustContain != null) {
            containsSubstring = line.contains(mustContain);
        }
        return notNull && validLength && containsSubstring;
    }
}

package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public abstract class Tag {
    protected String name;
    protected Map<String, String> attributes;

    public Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    protected String renderAttributes() {
        if (attributes.isEmpty()) {
            return "";
        }
        StringBuilder attrs = new StringBuilder();
        attributes.forEach((key, value) -> attrs.append(String.format(" %s=\"%s\"", key, value)));
        return attrs.toString();
    }

    @Override
    public abstract String toString();
}
// END

package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String body;
    private List<Tag> children;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder childTags = new StringBuilder();
        for (Tag child : children) {
            childTags.append(child.toString());
        }
        return String.format("<%s%s>%s%s</%s>", name, renderAttributes(), body, childTags, name);
    }
}
// END

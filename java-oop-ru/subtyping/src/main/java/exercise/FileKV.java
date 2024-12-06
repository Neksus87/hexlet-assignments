package exercise;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class FileKV implements KeyValueStorage {
    private final Path filePath;
    private Map<String, String> data;

    public FileKV(String filePath, Map<String, String> initialData) {
        this.filePath = Path.of(filePath);
        this.data = new HashMap<>(initialData);
        writeToDisk();
    }

    private void writeToDisk() {
        try {
            Files.writeString(filePath, Utils.serialize(data));
        } catch (Exception e) {
            throw new RuntimeException("Failed to write to file", e);
        }
    }

    @Override
    public void set(String key, String value) {
        data.put(key, value);
        writeToDisk();
    }

    @Override
    public void unset(String key) {
        data.remove(key);
        writeToDisk();
    }

    @Override
    public String get(String key, String defaultValue) {
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(data);
    }

    @Override
    public void clear() {
        data.clear();
        writeToDisk();
    }
}

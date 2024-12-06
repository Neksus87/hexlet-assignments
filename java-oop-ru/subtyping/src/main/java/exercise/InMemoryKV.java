package exercise;

import java.util.HashMap;
import java.util.Map;

public final class InMemoryKV implements KeyValueStorage {
    private final Map<String, String> storage;

    public InMemoryKV(Map<String, String> initialStorage) {
        this.storage = new HashMap<>(initialStorage);
    }

    @Override
    public void set(String key, String value) {
        storage.put(key, value);
    }

    @Override
    public void unset(String key) {
        storage.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(storage);
    }

    @Override
    public void clear() {
        storage.clear();
    }
}

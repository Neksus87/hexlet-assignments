package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private final Map<String, String> storage;

    // Конструктор принимает начальный словарь
    public InMemoryKV(Map<String, String> initialData) {
        this.storage = new HashMap<>(initialData);
    }

    @Override
    public void set(String key, String value) {
        storage.put(key, value); // Добавляет или обновляет значение по ключу
    }

    @Override
    public void unset(String key) {
        storage.remove(key); // Удаляет значение по ключу
    }

    @Override
    public String get(String key, String defaultValue) {
        return storage.getOrDefault(key, defaultValue); // Возвращает значение по ключу или значение по умолчанию
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(storage); // Возвращает копию хранилища
    }
}
// END

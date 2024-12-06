package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
class InMemoryKV implements KeyValueStorage {
    private final Map<String, String> storage;

    private InMemoryKV(Map<String, String> initialStorage) {
        // Создаем новый HashMap для хранения данных
        this.storage = new HashMap<>(initialStorage);
    }

    @Override
    public void set(String key, String value) {
        storage.put(key, value); // Добавляем или обновляем значение по ключу
    }

    @Override
    public void unset(String key) {
        storage.remove(key); // Удаляем значение по ключу
    }

    @Override
    public String get(String key, String defaultValue) {
        return storage.getOrDefault(key, defaultValue); // Возвращаем значение по ключу или значение по умолчанию
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(storage); // Возвращаем копию текущего состояния хранилища
    }
}
// END

package exercise;

// BEGIN
import java.util.Map;
import java.util.HashMap;
import java.util.Map;

public class FileKV implements KeyValueStorage {
    private final String filePath;
    private Map<String, String> storage;

    public FileKV(String filePath, Map<String, String> initialData) {
        this.filePath = filePath;
        this.storage = new HashMap<>(initialData);
        load(); // Загружаем данные из файла
    }

    private void load() {
        String json = Utils.readFile(filePath);
        if (json != null) {
            storage = Utils.deserialize(json);
        }
    }

    @Override
    public void set(String key, String value) {
        storage.put(key, value);
        save();
    }

    @Override
    public void unset(String key) {
        storage.remove(key); // Удаляет запись по ключу
        save(); // Сохраняет изменения после удаления
    }

    @Override
    public void unsetAll() {
        storage.clear();
        save();
    }

    @Override
    public String get(String key, String defaultValue) {
        return storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(storage); // Возвращает копию
    }

    private void save() {
        String json = Utils.serialize(storage);
        Utils.writeFile(filePath, json);
    }
}
// END

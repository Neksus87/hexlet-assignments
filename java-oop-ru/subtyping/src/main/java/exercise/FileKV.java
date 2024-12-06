package exercise;

// BEGIN
import java.util.Map;

public class FileKV implements KeyValueStorage {
    private final String filePath;
    private Map<String, String> storage;

    public FileKV(String filePath, Map<String, String> initialData) {
        this.filePath = filePath;
        this.storage = initialData;
        // Здесь будет логика загрузки данных из файла
        load();
    }

    private void load() {
        // Здесь вы загружаете данные из файла
        String json = Utils.readFile(filePath);
        if (json != null) {
            storage = Utils.deserialize(json); // Десериализация данных
        }
    }

    @Override
    public void set(String key, String value) {
        storage.put(key, value);
        save(); // Сохраняем данные после изменения
    }

    @Override
    public void unset(String key) {
        storage.remove(key);
        save(); // Сохраняем данные после изменения
    }

    @Override
    public String get(String key, String defaultValue) {
        return storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return storage; // Возвращает копию хранилища
    }

    private void save() {
        String json = Utils.serialize(storage); // Сериализация данных
        Utils.writeFile(filePath, json); // Запись в файл
    }
}
// END

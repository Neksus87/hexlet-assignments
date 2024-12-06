package exercise;

// BEGIN
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

class FileKV implements KeyValueStorage {
    private final Path filePath;
    private Map<String, String> data;

    public FileKV(String filePath, Map<String, String> initialData) {
        this.filePath = Path.of(filePath);
        this.data = new HashMap<>(initialData);
        // Сохраняем начальные данные в файл
        Utils.writeFile(filePath, Utils.serialize(data));
    }

    @Override
    public void set(String key, String value) {
        data.put(key, value);
        // Сохраняем изменения в файл
        Utils.writeFile(filePath.toString(), Utils.serialize(data));
    }

    @Override
    public void unset(String key) {
        data.remove(key);
        // Обновляем файл после удаления
        Utils.writeFile(filePath.toString(), Utils.serialize(data));
    }

    @Override
    public String get(String key, String defaultValue) {
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(data); // Возвращаем копию текущего состояния хранилища
    }
}
// END

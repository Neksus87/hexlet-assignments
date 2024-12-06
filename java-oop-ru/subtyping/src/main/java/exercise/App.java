package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> data = storage.toMap();
        Map<String, String> swappedData = new HashMap<>();

        // Меняем местами ключи и значения
        for (Map.Entry<String, String> entry : data.entrySet()) {
            swappedData.put(entry.getValue(), entry.getKey());
        }

        // Очищаем текущее хранилище и добавляем перевернутые пары
        for (String key : data.keySet()) {
            storage.unset(key);
        }
        for (Map.Entry<String, String> entry : swappedData.entrySet()) {
            storage.set(entry.getKey(), entry.getValue());
        }
    }
}
// END

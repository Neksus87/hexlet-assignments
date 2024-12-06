package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
import java.util.HashMap;

public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> currentData = storage.toMap();
        Map<String, String> swappedData = new HashMap<>();

        for (Map.Entry<String, String> entry : currentData.entrySet()) {
            swappedData.put(entry.getValue(), entry.getKey()); // Меняем местами ключи и значения
        }

        storage.unsetAll(); // Удаляем все существующие записи
        for (Map.Entry<String, String> entry : swappedData.entrySet()) {
            storage.set(entry.getKey(), entry.getValue()); // Добавляем новое значение
        }
    }
}
// END

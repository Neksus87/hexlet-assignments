package exercise;

import java.util.HashMap;
import java.util.Map;

class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> data = storage.toMap();
        Map<String, String> swappedData = new HashMap<>();

        // Меняем местами ключи и значения
        for (Map.Entry<String, String> entry : data.entrySet()) {
            swappedData.put(entry.getValue(), entry.getKey());
        }

        // Очищаем текущее хранилище и добавляем перевернутые пары
        storage.clear();
        for (Map.Entry<String, String> entry : swappedData.entrySet()) {
            storage.set(entry.getKey(), entry.getValue());
        }
    }
}

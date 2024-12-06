package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
// BEGIN
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals; // Импортируем assertEquals
import java.util.Map;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // BEGIN
    @Test
    public void testFileKV() throws Exception {
        String filePath = "testFile.json"; // путь к временному файлу

        // Создание нового хранилища с начальными данными
        KeyValueStorage storage = new FileKV(filePath, Map.of("key", "value"));

        // Проверка получения значения
        assertEquals("value", storage.get("key", "default"));
        assertEquals("default", storage.get("unknown", "default"));

        // Установка нового значения
        storage.set("new_key", "new_value");
        assertEquals("new_value", storage.get("new_key", "default"));

        // Удаление ключа
        storage.unset("new_key");
        assertEquals("default", storage.get("new_key", "default"));

        // Проверка, что данные сохраняются в файл
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        Map<String, String> loadedData = Utils.deserialize(content);
        assertEquals("value", loadedData.get("key"));

        // Удаляем временный файл после теста
        Files.delete(Paths.get(filePath));
    }
    // END
}

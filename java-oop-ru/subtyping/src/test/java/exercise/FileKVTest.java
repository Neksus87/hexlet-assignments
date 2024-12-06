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
import static org.assertj.core.api.Assertions.assertThat;
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
    void testGetAndSet() throws Exception {
        KeyValueStorage storage = new FileKV(FILE_PATH, Map.of("key", "value"));
        assertThat(storage.get("key", "default")).isEqualTo("value");

        storage.set("key2", "value2");
        assertThat(storage.get("key2", "default")).isEqualTo("value2");

        storage.unset("key");
        assertThat(storage.get("key", "default")).isEqualTo("default");
    }

    @Test
    void testPersistence() throws Exception {
        KeyValueStorage storage = new FileKV(FILE_PATH, Map.of("key", "value"));

        // Убедимся, что данные сохраняются в файл
        KeyValueStorage newStorage = new FileKV(FILE_PATH, Map.of()); // Пустая инициализация, данные должны загружаться из файла
        assertThat(newStorage.get("key", "default")).isEqualTo("value");
    }

    @Test
    void testOverwrite() throws Exception {
        KeyValueStorage storage = new FileKV(FILE_PATH, Map.of("key", "value"));

        storage.set("key", "newValue");
        assertThat(storage.get("key", "default")).isEqualTo("newValue");
    }

    @Test
    void testMultipleKeys() throws Exception {
        KeyValueStorage storage = new FileKV(FILE_PATH, Map.of("key1", "value1", "key2", "value2"));
        assertThat(storage.get("key1", "default")).isEqualTo("value1");
        assertThat(storage.get("key2", "default")).isEqualTo("value2");
    }
    // END
}

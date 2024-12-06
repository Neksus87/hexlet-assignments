package exercise;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FileKVTest {
    private static final String FILE_PATH = "testfile.txt";

    @Test
    void testFileKV() throws Exception {
        Files.deleteIfExists(Path.of(FILE_PATH)); // Удаляем файл, если существует
        KeyValueStorage storage = new FileKV(FILE_PATH, Map.of("key", "value"));
        assertEquals("value", storage.get("key", "default"));
    }

    @Test
    void testFileKVUnset() throws Exception {
        Files.deleteIfExists(Path.of(FILE_PATH));
        KeyValueStorage storage = new FileKV(FILE_PATH, Map.of("key", "value"));
        storage.unset("key");
        assertEquals("default", storage.get("key", "default"));
    }

    @Test
    void testFileKVGetDefault() throws Exception {
        Files.deleteIfExists(Path.of(FILE_PATH));
        KeyValueStorage storage = new FileKV(FILE_PATH, Map.of());
        assertEquals("default", storage.get("key", "default"));
    }

    @Test
    void testFileKVUpdateValue() throws Exception {
        Files.deleteIfExists(Path.of(FILE_PATH));
        KeyValueStorage storage = new FileKV(FILE_PATH, Map.of("key", "value"));
        storage.set("key", "newValue");
        assertEquals("newValue", storage.get("key", "default"));
    }

    @Test
    void testFileKVMultipleEntries() throws Exception {
        Files.deleteIfExists(Path.of(FILE_PATH));
        KeyValueStorage storage = new FileKV(FILE_PATH, Map.of("key1", "value1", "key2", "value2"));
        assertEquals("value1", storage.get("key1", "default"));
        assertEquals("value2", storage.get("key2", "default"));
    }

    @Test
    void testFileKVClear() throws Exception {
        Files.deleteIfExists(Path.of(FILE_PATH));
        KeyValueStorage storage = new FileKV(FILE_PATH, Map.of("key1", "value1"));
        storage.clear();
        assertEquals("default", storage.get("key1", "default"));
    }
}

import org.junit.jupiter.api.AfterEach;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

abstract class ClassFileCleanup {

    @AfterEach
    void deleteClassFilesAfterEachTest() throws IOException {
        Path srcRoot = Path.of("src");
        if (!Files.exists(srcRoot)) {
            return;
        }

        try (var paths = Files.walk(srcRoot)) {
            paths.filter(path -> path.toString().endsWith(".class"))
                .sorted(Comparator.reverseOrder())
                .forEach(path -> {
                    try {
                        Files.deleteIfExists(path);
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to delete class file: " + path, e);
                    }
                });
        }
    }
}

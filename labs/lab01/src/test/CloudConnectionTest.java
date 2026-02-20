import org.junit.jupiter.api.Test;
import singleton.CloudConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class CloudConnectionTest extends ClassFileCleanup {

    @Test
    void shouldReturnSameInstance() {
        CloudConnection first = CloudConnection.getInstance("A", "url-1");
        CloudConnection second = CloudConnection.getInstance("B", "url-2");
        assertSame(first, second);
    }

    @Test
    void shouldBeThreadSafeAndCreateOneInstance() throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Callable<CloudConnection>> tasks = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            tasks.add(() -> CloudConnection.getInstance("THREAD", "thread-url"));
        }

        List<Future<CloudConnection>> results = pool.invokeAll(tasks);
        pool.shutdown();

        Set<CloudConnection> unique = new HashSet<>();
        for (Future<CloudConnection> result : results) {
            unique.add(result.get());
        }
        assertEquals(1, unique.size());
    }
}

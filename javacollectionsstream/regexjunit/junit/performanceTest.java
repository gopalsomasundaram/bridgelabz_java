/**
 * This Program implements a performance monitoring simulation and its unit tests
 * using JUnit 5. It demonstrates how to use timeout constraints to ensure that
 * long-running tasks do not exceed a predefined execution window.
 *
 * @author gopal
 */
package regexjunit.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;

/**
 * This class simulates a resource-intensive or time-consuming operation.
 * It uses thread sleeping to mimic the latency typically found in network
 * requests or heavy data processing tasks.
 */
class HeavyTask{
    // Method that simulates a task taking 3 seconds to complete
    public void longRunningTask(){
        try {
            // Pausing the current thread for the specified duration
            Thread.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            // Printing stack trace if the sleep is interrupted
            e.printStackTrace();
        }
    }
}

/**
 * This class provides performance-based unit tests for HeavyTask.
 * It utilizes the @Timeout annotation to enforce strict execution limits,
 * identifying methods that are performing too slowly for system requirements.
 */
public class performanceTest {
    // Instance of the task to be monitored
    private HeavyTask obj;

    /**
     * Initialization method that runs before each test.
     * Sets up the heavy task object for timing analysis.
     */
    @BeforeEach
    void init(){
        obj = new HeavyTask();
    }

    /**
     * Tests the execution speed of the longRunningTask.
     * This test is expected to fail because the task duration (3s)
     * exceeds the annotated timeout limit (2s).
     */
    @Test
    @Timeout(2)
    void testTimeout(){
        // Executing the task to trigger the timeout failure
        obj.longRunningTask();
    }
}
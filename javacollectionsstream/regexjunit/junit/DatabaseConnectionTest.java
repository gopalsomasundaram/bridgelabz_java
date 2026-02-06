/**
 * This Program implements a simulated database connection lifecycle and its
 * corresponding tests using JUnit 5. It demonstrates the use of setup and
 * teardown procedures to manage resources effectively during a testing cycle.
 *
 * @author gopal
 */
package regexjunit.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class simulates a database connection.
 * It provides methods to open and close a connection while tracking
 * the current status of the database availability.
 */
class DatabaseConnection{
    // Tracks whether the database is currently connected
    private boolean connectionStatus;

    // Constructor initializes the connection as closed
    DatabaseConnection(){
        connectionStatus = false;
    }

    // Opens the simulated connection
    public void connect(){
        System.out.println("Connected to database");
        connectionStatus = true;
    }

    // Returns the current state of the connection
    public boolean getConnectionStatus(){
        return connectionStatus;
    }

    // Closes the simulated connection
    public void disconnect(){
        System.out.println("Disconnected from database");
        connectionStatus = false;
    }
}

/**
 * This class provides lifecycle tests for the DatabaseConnection.
 * It utilizes @BeforeEach and @AfterEach to ensure the connection
 * is properly managed before and after every test execution.
 */
public class DatabaseConnectionTest {
    // Instance of the simulated database
    DatabaseConnection db;

    /**
     * Set up method that runs before every test.
     * Initializes the database object and establishes a connection.
     */
    @BeforeEach
    void setUp(){
        db = new DatabaseConnection();
        db.connect();
    }

    /**
     * Teardown method that runs after every test.
     * Ensures the database connection is closed regardless of test outcome.
     */
    @AfterEach
    void tearDown(){
        db.disconnect();
    }

    /**
     * Tests that the database is successfully connected after the setup phase.
     */
    @Test
    void testConnection(){
        Assertions.assertTrue(db.getConnectionStatus());
    }
}
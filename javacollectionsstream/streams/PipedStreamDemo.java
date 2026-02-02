/**
 * This program demonstrates inter-thread communication using Piped Streams.
 * A PipedOutputStream from one thread is connected to a PipedInputStream
 * in another thread, allowing data to flow directly between them.
 *
 * @author gopal;
 */
package streams;

import java.io.*;

public class PipedStreamDemo {
    public static void main(String[] args) {
        try {
            // 1. Create and connect the pipes
            // The output pipe must be connected to an input pipe to function.
            final PipedOutputStream output = new PipedOutputStream();
            final PipedInputStream input = new PipedInputStream(output);

            // 2. Producer Thread: Writes data into the output pipe
            Thread producer = new Thread(() -> {
                try {
                    String[] messages = {"Hello", "from", "the", "Producer", "Thread!"};
                    for (String msg : messages) {
                        // Convert string to bytes for the byte-oriented stream
                        output.write(msg.getBytes());
                        output.write(' '); // Delimiter to separate words
                        System.out.println("Producer sent: " + msg);

                        // Sleep to simulate processing time and observe stream blocking
                        Thread.sleep(500);
                    }
                    // Closing the output stream signals EOF (-1) to the input stream
                    output.close();
                } catch (IOException | InterruptedException e) {
                    System.err.println("Producer Error: " + e.getMessage());
                }
            });

            // 3. Consumer Thread: Reads data from the input pipe
            Thread consumer = new Thread(() -> {
                try {
                    int data;
                    System.out.print("Consumer received: ");

                    // read() is a blocking call; it waits until the producer writes data
                    // or the stream is closed (returning -1).
                    while ((data = input.read()) != -1) {
                        System.out.print((char) data);
                    }

                    System.out.println("\nConsumer: Pipe closed, exiting.");
                    input.close();
                } catch (IOException e) {
                    System.err.println("Consumer Error: " + e.getMessage());
                }
            });

            // Piped communication REQUIRES separate threads.
            // Using a single thread for both would cause a Deadlock.
            producer.start();
            consumer.start();

        } catch (IOException e) {
            System.err.println("Pipe Connection Error: " + e.getMessage());
        }
    }
}
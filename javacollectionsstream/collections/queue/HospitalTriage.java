/**
 * This program simulates a hospital triage system using a PriorityQueue.
 * Patients are processed based on their severity level (higher number
 * equals higher priority) rather than their arrival time.
 *
 * @author gopal
 */
package collections.queue;

import java.util.PriorityQueue;
import java.util.Comparator;

class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriage {

    public static void main(String[] args) {
        // PriorityQueue with a custom comparator for descending severity
        PriorityQueue<Patient> triage = new PriorityQueue<>((p1, p2) -> p2.severity - p1.severity);

        triage.add(new Patient("John", 3));
        triage.add(new Patient("Alice", 5));
        triage.add(new Patient("Bob", 2));

        System.out.println("Treatment Order:");
        while (!triage.isEmpty()) {
            System.out.println(triage.poll());
        }
    }
}
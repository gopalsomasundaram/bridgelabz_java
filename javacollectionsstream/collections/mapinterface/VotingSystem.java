/**
 * This program implements a Voting System using various Map implementations.
 * It demonstrates efficient vote counting, preservation of candidate
 * registration order, and alphabetical result sorting.
 *
 * @author gopal
 */
package collections.mapinterface;

import java.util.*;

public class VotingSystem {

    // HashMap for O(1) efficiency in updating and counting votes
    private Map<String, Integer> voteTally = new HashMap<>();

    // LinkedHashMap to remember the order in which candidates were first voted for
    private Map<String, Integer> discoveryOrder = new LinkedHashMap<>();

    // TreeMap to keep candidate names sorted alphabetically for the final report
    private Map<String, Integer> alphabeticalResults = new TreeMap<>();

    /**
     * Records a vote for a specific candidate across all map types.
     *
     * @param candidate Name of the person receiving the vote.
     */
    public void castVote(String candidate) {
        // Standardize name to ensure "Alice" and "alice" are treated as the same
        String name = candidate.trim().toUpperCase();

        // 1. Update the main tally (HashMap)
        int currentVotes = voteTally.getOrDefault(name, 0) + 1;
        voteTally.put(name, currentVotes);

        // 2. Update discovery order (LinkedHashMap)
        // LinkedHashMap keeps the order of the first time 'put' was called for a key
        discoveryOrder.put(name, currentVotes);

        // 3. Update alphabetical report (TreeMap)
        alphabeticalResults.put(name, currentVotes);
    }

    /**
     * Displays results in the order the candidates received their first vote.
     */
    public void displayDiscoveryOrder() {
        System.out.println("\n--- Candidates in Order of First Vote Received ---");
        for (Map.Entry<String, Integer> entry : discoveryOrder.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    /**
     * Displays results sorted alphabetically by candidate name.
     */
    public void displayAlphabeticalResults() {
        System.out.println("\n--- Results Sorted Alphabetically (TreeMap) ---");
        for (Map.Entry<String, Integer> entry : alphabeticalResults.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    /**
     * Displays the current winner (Candidate with highest votes).
     */
    public void displayWinner() {
        String winner = null;
        int maxVotes = -1;

        for (Map.Entry<String, Integer> entry : voteTally.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }
        System.out.println("\nCURRENT LEADER: " + winner + " with " + maxVotes + " votes.");
    }

    public static void main(String[] args) {
        VotingSystem election = new VotingSystem();

        // Simulating votes
        election.castVote("Charlie");
        election.castVote("Alice");
        election.castVote("Bob");
        election.castVote("Alice");
        election.castVote("Charlie");
        election.castVote("Alice");

        // Displaying different views of the data
        election.displayDiscoveryOrder();
        election.displayAlphabeticalResults();
        election.displayWinner();
    }
}
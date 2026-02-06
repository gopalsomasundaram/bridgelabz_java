/**
 * This Program scans transactions for fraudulent activity.
 * It aggregates fraud data by policy and flags accounts exceeding safety thresholds.
 * * @author gopal
 */
package functional;

import java.util.*;
import java.util.stream.Collectors;

class Transaction {
    String transactionId;
    String policyNumber;
    double amount;
    boolean isFraudulent;

    Transaction(String tid, String pn, double amt, boolean fraud) {
        this.transactionId = tid; this.policyNumber = pn;
        this.amount = amt; this.isFraudulent = fraud;
    }
}

public class FraudDetectionSystem {
    public static void main(String[] args) {
        List<Transaction> txns = Arrays.asList(
                new Transaction("T1", "POL-99", 12000, true),
                new Transaction("T2", "POL-99", 15000, true),
                new Transaction("T3", "POL-88", 60000, true),
                new Transaction("T4", "POL-99", 500, false)
        );

        // 1 & 2: Filter fraudulent > 10,000 and group by policy
        Map<String, List<Transaction>> fraudByPolicy = txns.stream()
                .filter(t -> t.isFraudulent && t.amount > 10000)
                .collect(Collectors.groupingBy(t -> t.policyNumber));

        // 3 & 4: Aggregate and Alert
        System.out.println("--- Fraud Alerts ---");
        fraudByPolicy.forEach((policy, fraudList) -> {
            long count = fraudList.size();
            double totalFraudAmount = fraudList.stream().mapToDouble(t -> t.amount).sum();

            System.out.printf("Policy: %s | Count: %d | Total Fraud: $%.2f%n",
                    policy, count, totalFraudAmount);

            if (count > 5 || totalFraudAmount > 50000) {
                System.err.println(">>> CRITICAL ALERT: Suspicious activity detected for " + policy);
            }
        });
    }
}
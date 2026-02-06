/**
 * This Program analyzes insurance claims to identify high-payout policies.
 * It groups approved claims and calculates summary statistics per policy.
 * * @author gopal
 */
package functional;

import java.util.*;
import java.util.stream.Collectors;

class Claim {
    int claimId;
    String policyNumber;
    double claimAmount;
    String status;

    Claim(int id, String pn, double amt, String st) {
        this.claimId = id; this.policyNumber = pn;
        this.claimAmount = amt; this.status = st;
    }
}

public class ClaimsAnalysis {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim(101, "POL-A", 6000, "Approved"),
                new Claim(102, "POL-B", 7500, "Approved"),
                new Claim(103, "POL-A", 5500, "Approved"),
                new Claim(104, "POL-C", 12000, "Approved"),
                new Claim(105, "POL-B", 2000, "Pending")
        );

        // 1, 2 & 3: Filter Approved > 5000 and Group by Policy with stats
        Map<String, DoubleSummaryStatistics> policyStats = claims.stream()
                .filter(c -> "Approved".equals(c.status) && c.claimAmount > 5000)
                .collect(Collectors.groupingBy(
                        c -> c.policyNumber,
                        Collectors.summarizingDouble(c -> c.claimAmount)
                ));

        // 4. Identify top 3 policies with highest total claim amounts
        System.out.println("Top 3 Policies by Total Claim Amount:");
        policyStats.entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue().getSum(), e1.getValue().getSum()))
                .limit(3)
                .forEach(entry -> System.out.printf("Policy: %s | Total: $%.2f | Avg: $%.2f%n",
                        entry.getKey(), entry.getValue().getSum(), entry.getValue().getAverage()));
    }
}
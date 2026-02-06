/**
 * This Program performs risk assessment on policy holders.
 * It calculates a risk score based on premium-to-age ratio and categorizes users.
 * * @author gopal
 */
package functional;

import java.util.*;
import java.util.stream.Collectors;

class PolicyHolder {
    int holderId;
    String name;
    int age;
    String policyType;
    double premiumAmount;

    PolicyHolder(int id, String n, int a, String pt, double pa) {
        this.holderId = id; this.name = n; this.age = a;
        this.policyType = pt; this.premiumAmount = pa;
    }
}

class RiskAssessment {
    int holderId;
    String name;
    double riskScore;

    RiskAssessment(int id, String n, double rs) {
        this.holderId = id; this.name = n; this.riskScore = rs;
    }
    @Override
    public String toString() { return name + " (Score: " + String.format("%.2f", riskScore) + ")"; }
}

public class RiskAssessmentSystem {
    public static void main(String[] args) {
        List<PolicyHolder> holders = Arrays.asList(
                new PolicyHolder(1, "John", 65, "Life", 5000),
                new PolicyHolder(2, "Sarah", 70, "Life", 2000),
                new PolicyHolder(3, "Mike", 62, "Life", 8000),
                new PolicyHolder(4, "Anna", 45, "Health", 3000)
        );

        // 1, 2 & 3: Filter Life > 60, Transform to Risk score, and Sort
        List<RiskAssessment> assessments = holders.stream()
                .filter(h -> "Life".equals(h.policyType) && h.age > 60)
                .map(h -> new RiskAssessment(h.holderId, h.name, h.premiumAmount / h.age))
                .sorted(Comparator.comparingDouble((RiskAssessment r) -> r.riskScore).reversed())
                .collect(Collectors.toList());

        // 4. Categorize into High/Low Risk groups
        Map<String, List<RiskAssessment>> riskGroups = assessments.stream()
                .collect(Collectors.groupingBy(r -> r.riskScore > 0.5 ? "High Risk" : "Low Risk"));

        System.out.println("Risk Categories:");
        riskGroups.forEach((category, members) -> System.out.println(category + ": " + members));
    }
}
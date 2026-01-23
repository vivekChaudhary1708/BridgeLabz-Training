import java.time.LocalDate;
import java.util.*;

public class InsurancePolicyManagementSystem {

    // Policy class
    static class Policy {
        int policyNumber;
        String policyHolderName;
        LocalDate expiryDate;

        Policy(int policyNumber, String policyHolderName, LocalDate expiryDate) {
            this.policyNumber = policyNumber;
            this.policyHolderName = policyHolderName;
            this.expiryDate = expiryDate;
        }

        @Override
        public String toString() {
            return "PolicyNumber=" + policyNumber +
                   ", Name=" + policyHolderName +
                   ", ExpiryDate=" + expiryDate;
        }
    }

    HashMap<Integer, Policy> policyMap = new HashMap<>();
    LinkedHashMap<Integer, Policy> linkedPolicyMap = new LinkedHashMap<>();
    TreeMap<LocalDate, List<Policy>> expiryMap = new TreeMap<>();

    // Add policy
    void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        linkedPolicyMap.put(policy.policyNumber, policy);

        expiryMap
            .computeIfAbsent(policy.expiryDate, k -> new ArrayList<>())
            .add(policy);
    }

    // Retrieve policy by number
    Policy getPolicyByNumber(int policyNumber) {
        return policyMap.get(policyNumber);
    }

    // List policies expiring in next 30 days
    void policiesExpiringIn30Days() {
        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        for (Map.Entry<LocalDate, List<Policy>> entry : expiryMap.entrySet()) {
            if (!entry.getKey().isBefore(today) && !entry.getKey().isAfter(next30Days)) {
                for (Policy p : entry.getValue()) {
                    System.out.println(p);
                }
            }
        }
    }

    // List policies by policy holder name
    void policiesByHolderName(String name) {
        for (Policy p : policyMap.values()) {
            if (p.policyHolderName.equalsIgnoreCase(name)) {
                System.out.println(p);
            }
        }
    }

    // Remove expired policies
    void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();

        Iterator<Map.Entry<Integer, Policy>> iterator = policyMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Policy> entry = iterator.next();
            if (entry.getValue().expiryDate.isBefore(today)) {
                iterator.remove();
                linkedPolicyMap.remove(entry.getKey());
            }
        }
    }

    // Main method
    public static void main(String[] args) {

        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();

        system.addPolicy(new Policy(101, "Rahul", LocalDate.now().plusDays(10)));
        system.addPolicy(new Policy(102, "Amit", LocalDate.now().plusDays(40)));
        system.addPolicy(new Policy(103, "Rahul", LocalDate.now().minusDays(5)));
        system.addPolicy(new Policy(104, "Neha", LocalDate.now().plusDays(25)));

        System.out.println("Get Policy By Number:");
        System.out.println(system.getPolicyByNumber(101));

        System.out.println("\nPolicies Expiring in Next 30 Days:");
        system.policiesExpiringIn30Days();

        System.out.println("\nPolicies for Rahul:");
        system.policiesByHolderName("Rahul");

        System.out.println("\nRemoving Expired Policies...");
        system.removeExpiredPolicies();

        System.out.println("\nAll Policies After Removal:");
        for (Policy p : system.policyMap.values()) {
            System.out.println(p);
        }
    }
}

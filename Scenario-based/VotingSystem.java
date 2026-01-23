import java.util.*;

public class VotingSystem {

    // HashMap: Candidate -> Votes
    HashMap<String, Integer> voteMap = new HashMap<>();

    // LinkedHashMap: maintains vote insertion order
    LinkedHashMap<String, Integer> voteOrderMap = new LinkedHashMap<>();

    // Add vote for a candidate
    void addVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrderMap.put(candidate, voteMap.get(candidate));
    }

    // Display votes in insertion order
    void displayVoteOrder() {
        for (Map.Entry<String, Integer> entry : voteOrderMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Display results in sorted order using TreeMap
    void displaySortedResults() {
        TreeMap<String, Integer> sortedMap = new TreeMap<>(voteMap);

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Main method
    public static void main(String[] args) {

        VotingSystem system = new VotingSystem();

        system.addVote("Rahul");
        system.addVote("Amit");
        system.addVote("Neha");
        system.addVote("Rahul");
        system.addVote("Amit");
        system.addVote("Rahul");

        System.out.println("Vote Order (LinkedHashMap):");
        system.displayVoteOrder();

        System.out.println("\nSorted Results (TreeMap):");
        system.displaySortedResults();
    }
}

import java.util.*;

class DuplicateVoteException extends Exception {
    public DuplicateVoteException(String msg) {
        super(msg);
    }
}

abstract class ElectionService {
    public abstract void registerVoter(Voter v);
    public abstract void addCandidate(Candidate c);
    public abstract void castVote(Voter v, Candidate c) throws DuplicateVoteException;
    public abstract void showResult();
}

class Voter {
    int id;
    String name;
    boolean hasVoted = false;

    public Voter(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Candidate {
    int id;
    String name;
    int votes = 0;

    public Candidate(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Election extends ElectionService {
    List<Voter> voters = new ArrayList<>();
    List<Candidate> candidates = new ArrayList<>();

    public void registerVoter(Voter v) {
        voters.add(v);
    }

    public void addCandidate(Candidate c) {
        candidates.add(c);
    }

    public void castVote(Voter v, Candidate c) throws DuplicateVoteException {
        if (v.hasVoted) {
            throw new DuplicateVoteException("Vote already cast");
        }
        c.votes++;
        v.hasVoted = true;
    }

    public void showResult() {
        for (Candidate c : candidates) {
            System.out.println(c.name + " " + c.votes);
        }
    }
}

public class VotingApp {
    public static void main(String[] args) {
        Election e = new Election();

        Voter v1 = new Voter(1, "Vivek");
        Voter v2 = new Voter(2, "Rahul");

        Candidate c1 = new Candidate(1, "Amit");
        Candidate c2 = new Candidate(2, "Rohit");

        e.registerVoter(v1);
        e.registerVoter(v2);

        e.addCandidate(c1);
        e.addCandidate(c2);

        try {
            e.castVote(v1, c1);
            e.castVote(v2, c2);
            e.castVote(v1, c2);
        } catch (DuplicateVoteException ex) {
            System.out.println(ex.getMessage());
        }

        e.showResult();
    }
}

import java.util.*;

class User {
    int id;
    String name;
    List<Integer> friends = new ArrayList<>();
    User next;

    User(int i, String n) {
        id = i; name = n;
    }
}

public class SocialMedia {
    static User head;

    static void addUser(User u) {
        u.next = head;
        head = u;
    }

    static User find(int id) {
        for (User t = head; t != null; t = t.next)
            if (t.id == id) return t;
        return null;
    }

    static void addFriend(int a, int b) {
        find(a).friends.add(b);
        find(b).friends.add(a);
    }

    static void mutual(int a, int b) {
        for (int x : find(a).friends)
            if (find(b).friends.contains(x))
                System.out.println(x);
    }

    public static void main(String[] args) {
        addUser(new User(1,"A"));
        addUser(new User(2,"B"));
        addUser(new User(3,"C"));
        addFriend(1,2);
        addFriend(1,3);
        addFriend(2,3);
        mutual(1,2);
    }
}

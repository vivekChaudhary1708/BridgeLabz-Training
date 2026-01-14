class State {
    String text;
    State next, prev;
    State(String t){ text = t; }
}

public class UndoRedo {
    static State head, cur;

    static void add(String t) {
        State s = new State(t);
        if (cur != null) cur.next = null;
        if (head == null) head = s;
        s.prev = cur;
        cur = s;
    }

    static void undo() {
        if (cur.prev != null) cur = cur.prev;
    }

    static void redo() {
        if (cur.next != null) cur = cur.next;
    }

    static void show() {
        System.out.println(cur.text);
    }

    public static void main(String[] args) {
        add("Hi");
        add("Hi Vivek");
        undo();
        show();
        redo();
        show();
    }
}

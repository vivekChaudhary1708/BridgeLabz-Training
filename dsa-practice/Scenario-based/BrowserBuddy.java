import java.util.Stack;

public class BrowserBuddy {

   
    private class PageNode {
        String url;
        PageNode prev;
        PageNode next;

        PageNode(String url) {
            this.url = url;
        }
    }

    private PageNode current;

   
    private Stack<PageNode> closedTabs = new Stack<>();

   
    public void visit(String url) {
        PageNode newPage = new PageNode(url);

        if (current != null) {
            current.next = newPage;
            newPage.prev = current;
        }
        current = newPage;

        System.out.println("Visited: " + url);
    }

    
    public void back() {
        if (current == null || current.prev == null) {
            System.out.println("No page to go back!");
            return;
        }
        current = current.prev;
        System.out.println("Back to: " + current.url);
    }

   
    public void forward() {
        if (current == null || current.next == null) {
            System.out.println("No page to go forward!");
            return;
        }
        current = current.next;
        System.out.println("Forward to: " + current.url);
    }

    public void closeTab() {
        if (current == null) {
            System.out.println("No tab to close!");
            return;
        }

        closedTabs.push(current);
        System.out.println("Closed tab: " + current.url);

        if (current.prev != null) {
            current.prev.next = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
            current = current.next;
        } else {
            current = current.prev;
        }
    }

    
    public void restoreTab() {
        if (closedTabs.isEmpty()) {
            System.out.println("No closed tabs to restore!");
            return;
        }

        PageNode restored = closedTabs.pop();
        System.out.println("Restored tab: " + restored.url);

        if (current != null) {
            restored.prev = current;
            restored.next = current.next;
            if (current.next != null) {
                current.next.prev = restored;
            }
            current.next = restored;
        }
        current = restored;
    }

    
    public void printCurrentPage() {
        if (current == null) {
            System.out.println("No active tab");
        } else {
            System.out.println("Current Page: " + current.url);
        }
    }

   
    public static void main(String[] args) {

        BrowserBuddy browser = new BrowserBuddy();

        browser.visit("google.com");
        browser.visit("github.com");
        browser.visit("stackoverflow.com");

        browser.back();
        browser.forward();

        browser.closeTab();
        browser.printCurrentPage();

        browser.restoreTab();
        browser.printCurrentPage();
    }
}

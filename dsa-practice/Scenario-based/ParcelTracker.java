public class ParcelTracker {

    
    private class StageNode {
        String stage;
        StageNode next;

        StageNode(String stage) {
            this.stage = stage;
        }
    }

  
    private StageNode head;

    
    public ParcelTracker() {
        head = new StageNode("Packed");
        head.next = new StageNode("Shipped");
        head.next.next = new StageNode("In Transit");
        head.next.next.next = new StageNode("Delivered");
    }

    
    public void trackParcel() {
        if (head == null) {
            System.out.println("Parcel is missing! No tracking data available.");
            return;
        }

        StageNode temp = head;
        System.out.print("Parcel Journey: ");
        while (temp != null) {
            System.out.print(temp.stage + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    
    public void addCheckpoint(String afterStage, String newStage) {
        StageNode temp = head;

        while (temp != null && !temp.stage.equals(afterStage)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Stage not found! Cannot add checkpoint.");
            return;
        }

        StageNode newNode = new StageNode(newStage);
        newNode.next = temp.next;
        temp.next = newNode;

        System.out.println("Checkpoint added: " + newStage + " after " + afterStage);
    }

   
    public void markParcelLost() {
        head = null;
        System.out.println("Parcel marked as LOST! Tracking stopped.");
    }

    
    public static void main(String[] args) {

        ParcelTracker tracker = new ParcelTracker();

        tracker.trackParcel();

        tracker.addCheckpoint("Shipped", "Customs Clearance");
        tracker.trackParcel();

        tracker.markParcelLost();
        tracker.trackParcel();
    }
}

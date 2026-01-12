class Ticket {
    int id;
    String name, movie;
    Ticket next;

    Ticket(int i,String n,String m){
        id=i;name=n;movie=m;
    }
}

public class TicketSystem {
    static Ticket head=null,tail=null;

    static void book(Ticket t){
        if(head==null){
            head=tail=t;
            t.next=head;
        }else{
            tail.next=t;
            tail=t;
            tail.next=head;
        }
    }

    static void show(){
        if(head==null)return;
        Ticket t=head;
        do{
            System.out.println(t.id+" "+t.name+" "+t.movie);
            t=t.next;
        }while(t!=head);
    }

    public static void main(String[] args){
        book(new Ticket(1,"Vivek","Avatar"));
        book(new Ticket(2,"Rahul","Jawan"));
        show();
    }
}

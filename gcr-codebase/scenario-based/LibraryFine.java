import java.util.Scanner;

class LibraryFine {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int finePerDay = 5;

        for (int i = 1; i <= 5; i++) {
            System.out.println("Book " + i);

            System.out.print("Enter due date: ");
            int due = sc.nextInt();

            System.out.print("Enter return date: ");
            int ret = sc.nextInt();

            if (ret > due) {
                int fine = (ret - due) * finePerDay;
                System.out.println("Fine: ₹" + fine);
            } else {
                System.out.println("No fine 🎉");
            }
        }

        sc.close();
    }
}

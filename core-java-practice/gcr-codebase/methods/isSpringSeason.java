public class SpringSeason {

    // Method to check spring season
    static boolean isSpringSeason(int month, int day) {

        if (month == 3 && day >= 20) {
            return true;
        } else if (month == 4 || month == 5) {
            return true;
        } else if (month == 6 && day <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        int givenMonth = Integer.parseInt(args[0]);
        int givenDay = Integer.parseInt(args[1]);

        boolean springCheck = isSpringSeason(givenMonth, givenDay);

        if (springCheck) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}

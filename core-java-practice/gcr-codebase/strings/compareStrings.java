// Write a program to compare two strings using the charAt() method and check the result with the built-in String equals() method
// Hint => 
// Take user input using the  Scanner next() method for 2 String variables
// Write a method to compare two strings using the charAt() method and return a boolean result
// Use the String Built-In method to check if the results are the same and display the result 

import java.util.Scanner;

public class CompareStrings {

    // compare strings using charAt()
    public static boolean checkStrings(String pehlaNaam, String dusraNaam) {

        if (pehlaNaam.length() != dusraNaam.length()) {
            return false;
        }

        for (int index = 0; index < pehlaNaam.length(); index++) {
            if (pehlaNaam.charAt(index) != dusraNaam.charAt(index)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Pehla string daalo: ");
        String aadmi = input.next();

        System.out.print("Dusra string daalo: ");
        String insaan = input.next();

        boolean charAtSeCheck = checkStrings(aadmi, insaan);
        boolean equalsSeCheck = aadmi.equals(insaan);

        System.out.println("charAt() se result: " + charAtSeCheck);
        System.out.println("equals() se result: " + equalsSeCheck);

        if (charAtSeCheck == equalsSeCheck) {
            System.out.println("Dono method ka result same hai");
        } else {
            System.out.println("Dono method ka result same nahi hai");
        }

        input.close();
    }
}

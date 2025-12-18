// Write a program that takes the base and height in cm to find the area of a triangle in square inches and square centimeters 
// Hint => Area of a Triangle is ½ * base * height and 1 in = 2.54 cm
// I/P => base, height
// O/P => The Area of the triangle in sq in is ___ and sq cm is ___

import java.util.Scanner;
public class Area_of_Triangle {   
    public static void main(String[] args) {
        // Create Scanner object to take user input
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the base of the triangle in centimeters: ");
        double baseCm = input.nextDouble();
        
        System.out.print("Enter the height of the triangle in centimeters: ");
        double heightCm = input.nextDouble();
        
        // Calculate area in square centimeters
        double areaSqCm = 0.5 * baseCm * heightCm;
        
        // Convert area to square inches (1 in = 2.54 cm, so 1 sq in = 2.54 * 2.54 sq cm)
        double areaSqIn = areaSqCm / (2.54 * 2.54);

        System.out.println("The Area of the triangle in sq in is " + areaSqIn + " and sq cm is " + areaSqCm);
        
        // Close the scanner
        input.close();
    }
}
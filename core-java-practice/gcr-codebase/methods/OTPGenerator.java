public class OTPGenerator {

    // Method to generate a 6-digit OTP
    public static int generateOTP() {
        // Generates number between 100000 and 999999
        return (int) (Math.random() * 900000) + 100000;
    }

    // Method to check if all OTPs are unique
    public static boolean areOTPsUnique(int[] otps) {

        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[] otpArray = new int[10];

        // Generate 10 OTPs
        for (int i = 0; i < otpArray.length; i++) {
            otpArray[i] = generateOTP();
        }

        System.out.println("Generated OTPs:");
        for (int otp : otpArray) {
            System.out.print(otp + " ");
        }

        // Check uniqueness
        boolean uniqueCheck = areOTPsUnique(otpArray);

        System.out.println("\n\nAre all OTPs unique? " + uniqueCheck);
    }
}

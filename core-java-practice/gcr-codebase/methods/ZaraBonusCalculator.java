public class ZaraBonusCalculator {

    // Generate salary and years of service
    // col 0 = salary, col 1 = years
    public static double[][] generateEmployeeData(int size) {

        double[][] data = new double[size][2];

        for (int i = 0; i < size; i++) {
            data[i][0] = (int) (Math.random() * 90000) + 10000; // 5-digit salary
            data[i][1] = (int) (Math.random() * 10) + 1;       // years of service
        }

        return data;
    }

    // Calculate bonus and new salary
    // col 0 = old salary, col 1 = bonus, col 2 = new salary
    public static double[][] calculateBonus(double[][] data) {

        double[][] result = new double[data.length][3];

        for (int i = 0; i < data.length; i++) {

            double oldSalary = data[i][0];
            double years = data[i][1];

            double bonus;
            if (years > 5) {
                bonus = oldSalary * 0.05;
            } else {
                bonus = oldSalary * 0.02;
            }

            result[i][0] = oldSalary;
            result[i][1] = bonus;
            result[i][2] = oldSalary + bonus;
        }

        return result;
    }

    // Display salary details and totals
    public static void displayReport(double[][] data, double[][] result) {

        double totalOld = 0;
        double totalBonus = 0;
        double totalNew = 0;

        System.out.println("Emp OldSalary Years Bonus NewSalary");

        for (int i = 0; i < data.length; i++) {

            totalOld += result[i][0];
            totalBonus += result[i][1];
            totalNew += result[i][2];

            System.out.printf(
                "%d   %.0f     %.0f    %.2f   %.2f%n",
                (i + 1),
                data[i][0],
                data[i][1],
                result[i][1],
                result[i][2]
            );
        }

        System.out.println("Total Old Salary : " + totalOld);
        System.out.println("Total Bonus     : " + totalBonus);
        System.out.println("Total New Salary: " + totalNew);
    }

    // MAIN METHOD
    public static void main(String[] args) {

        int employees = 10;

        double[][] employeeData = generateEmployeeData(employees);
        double[][] salaryResult = calculateBonus(employeeData);

        displayReport(employeeData, salaryResult);
    }
}

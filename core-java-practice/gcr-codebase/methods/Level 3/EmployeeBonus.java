class EmployeeBonus {

    public static double[][] generateData() {

        double[][] employeeData =
                new double[10][2];

        for (int i = 0; i < 10; i++) {

            employeeData[i][0] =
                    (int)(Math.random()
                            * 90000)
                            + 10000;

            employeeData[i][1] =
                    (int)(Math.random()
                            * 10)
                            + 1;
        }

        return employeeData;
    }

    public static double[][] calculateBonus(
            double[][] employeeData) {

        double[][] updated =
                new double[10][4];

        for (int i = 0; i < 10; i++) {

            double salary =
                    employeeData[i][0];

            double years =
                    employeeData[i][1];

            double bonusPercent =
                    years > 5 ? 0.05 : 0.02;

            double bonus =
                    salary * bonusPercent;

            double newSalary =
                    salary + bonus;

            updated[i][0] = salary;
            updated[i][1] = years;
            updated[i][2] = bonus;
            updated[i][3] = newSalary;
        }

        return updated;
    }

    public static void display(
            double[][] data) {

        double oldTotal = 0;
        double newTotal = 0;
        double bonusTotal = 0;

        System.out.println(
                "OldSalary\tYears\tBonus\tNewSalary");

        for (double[] employee : data) {

            System.out.printf(
                    "%.2f\t%.0f\t%.2f\t%.2f\n",
                    employee[0],
                    employee[1],
                    employee[2],
                    employee[3]);

            oldTotal += employee[0];
            bonusTotal += employee[2];
            newTotal += employee[3];
        }

        System.out.println(
                "\nTotal Old Salary: "
                        + oldTotal);

        System.out.println(
                "Total Bonus: "
                        + bonusTotal);

        System.out.println(
                "Total New Salary: "
                        + newTotal);
    }

    public static void main(String[] args) {

        double[][] employeeData =
                generateData();

        double[][] updatedData =
                calculateBonus(
                        employeeData);

        display(updatedData);
    }
}
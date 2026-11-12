
package com.factory.robot;

import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    public static double calculateHazardRisk(
            double armPrecision,
            int workerDensity,
            String machineryState) throws RobotSafetyException {

        // Validate Arm Precision
        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException(
                    "Invalid Arm Precision! Enter a value between 0.0 and 1.0.");
        }

        // Validate Worker Density
        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException(
                    "Invalid Worker Density! Enter a value between 1 and 20.");
        }

        // Calculate Machinery Risk Factor
        double machineRiskFactor = 0.0;

        if (machineryState.equals("Worn")) {
            machineRiskFactor = 1.3;
        } else if (machineryState.equals("Faulty")) {
            machineRiskFactor = 2.0;
        } else if (machineryState.equals("Critical")) {
            machineRiskFactor = 3.0;
        }

        // Calculate Hazard Risk
        double risk = ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineRiskFactor);

        return risk;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Arm Precision (0.0 - 1.0):");
        double armPrecision = sc.nextDouble();

        System.out.println("Enter Worker Density (1 - 20):");
        int workerDensity = sc.nextInt();

        sc.nextLine();

        System.out.println("Enter Machinery State (Worn/Faulty/Critical):");
        String machineryState = sc.nextLine();

        try {
            double risk = calculateHazardRisk(
                    armPrecision, workerDensity, machineryState);

            System.out.println("Arm Precision: " + armPrecision);
            System.out.println("Worker Density: " + workerDensity);
            System.out.println("Machinery State: " + machineryState);
            System.out.println("Robot Hazard Risk Score: " + risk);

        } catch (RobotSafetyException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}

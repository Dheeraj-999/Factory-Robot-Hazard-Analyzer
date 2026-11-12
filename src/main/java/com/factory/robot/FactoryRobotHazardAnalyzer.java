
package com.factory.robot;

import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    // UC3: Calculate hazard risk
    public static double calculateHazardRisk(
            double armPrecision,
            int workerDensity,
            String machineryState) {

        double machineRiskFactor = 0.0;

        if (machineryState.equals("Worn")) {
            machineRiskFactor = 1.3;
        } else if (machineryState.equals("Faulty")) {
            machineRiskFactor = 2.0;
        } else if (machineryState.equals("Critical")) {
            machineRiskFactor = 3.0;
        }

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

        // UC4: Validate inputs using conditional statements

        if (armPrecision < 0.0 || armPrecision > 1.0) {
            System.out.println("Error: Invalid Arm Precision!");
            sc.close();
            return;
        } else if (workerDensity < 1 || workerDensity > 20) {
            System.out.println("Error: Invalid Worker Density!");
            sc.close();
            return;
        }

        // Display valid inputs
        System.out.println("Arm Precision: " + armPrecision);
        System.out.println("Worker Density: " + workerDensity);
        System.out.println("Machinery State: " + machineryState);

        // Calculate risk
        double risk = calculateHazardRisk(
                armPrecision,
                workerDensity,
                machineryState
        );

        System.out.println("Robot Hazard Risk Score: " + risk);

        sc.close();
    }
}

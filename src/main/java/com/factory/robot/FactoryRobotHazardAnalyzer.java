
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

        // UC1 + UC2: Display accepted inputs
        System.out.println("Arm Precision: " + armPrecision);
        System.out.println("Worker Density: " + workerDensity);
        System.out.println("Machinery State: " + machineryState);

        // UC3: Calculate hazard risk
        double risk = calculateHazardRisk(
                armPrecision,
                workerDensity,
                machineryState
        );

        System.out.println("Robot Hazard Risk Score: " + risk);

        sc.close();
    }
}

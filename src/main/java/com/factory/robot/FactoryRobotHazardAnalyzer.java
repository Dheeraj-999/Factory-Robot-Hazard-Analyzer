
package com.factory.robot;

import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Collect user inputs
        System.out.println("Enter Arm Precision (0.0 - 1.0):");
        double armPrecision = sc.nextDouble();

        System.out.println("Enter Worker Density (1 - 20):");
        int workerDensity = sc.nextInt();

        sc.nextLine();

        System.out.println("Enter Machinery State (Worn/Faulty/Critical):");
        String machineryState = sc.nextLine();

        // Create auditor object
        RobotHazardAuditor auditor = new RobotHazardAuditor();

        try {
            // Call business logic
            double risk = auditor.calculateHazardRisk(
                    armPrecision, workerDensity, machineryState);

            // Display result
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

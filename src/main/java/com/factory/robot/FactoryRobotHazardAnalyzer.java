package com.factory.robot;

import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Display application name
        System.out.println("Factory Robot Hazard Analyzer");

        // Accept arm precision
        System.out.println("Enter Arm Precision (0.0 - 1.0):");
        double armPrecision = sc.nextDouble();

        // Accept worker density
        System.out.println("Enter Worker Density (1 - 20):");
        int workerDensity = sc.nextInt();

        sc.nextLine(); // Consume leftover newline

        // Accept machinery state
        System.out.println("Enter Machinery State (Worn/Faulty/Critical):");
        String machineryState = sc.nextLine();

        // Display entered inputs
        System.out.println("Arm Precision: " + armPrecision);
        System.out.println("Worker Density: " + workerDensity);
        System.out.println("Machinery State: " + machineryState);

        sc.close();
    }
}

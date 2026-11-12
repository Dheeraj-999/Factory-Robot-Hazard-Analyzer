
package com.factory.robot;

public class RobotHazardAuditor {

    // Validate inputs and calculate hazard risk
    public double calculateHazardRisk(
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

        // Get Machinery Risk Factor
        double machineRiskFactor = getMachineryRiskFactor(machineryState);

        // Calculate Hazard Risk
        return ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineRiskFactor);
    }

    // Map machinery state to risk factor
    private double getMachineryRiskFactor(
            String machineryState) throws RobotSafetyException {

        if (machineryState.equals("Worn")) {
            return 1.3;
        } else if (machineryState.equals("Faulty")) {
            return 2.0;
        } else if (machineryState.equals("Critical")) {
            return 3.0;
        } else {
            throw new RobotSafetyException(
                    "Invalid Machinery State! Use Worn, Faulty, or Critical.");
        }
    }
}

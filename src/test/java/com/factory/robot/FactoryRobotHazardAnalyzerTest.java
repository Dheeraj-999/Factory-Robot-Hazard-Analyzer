
package com.factory.robot;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class FactoryRobotHazardAnalyzerTest {

    @Test
    void shouldAcceptAndDisplayRobotInputs() {
        String simulatedInput = "0.5\n10\nCritical\n";

        InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
            System.setOut(new PrintStream(output));

            FactoryRobotHazardAnalyzer.main(new String[]{});
        } finally {
            System.setIn(originalInput);
            System.setOut(originalOutput);
        }

        String result = output.toString();

        assertTrue(result.contains("Arm Precision: 0.5"));
        assertTrue(result.contains("Worker Density: 10"));
        assertTrue(result.contains("Machinery State: Critical"));
        assertTrue(result.contains("Robot Hazard Risk Score: 37.5"));
    }

    @Test
    void shouldCalculateCorrectHazardRisk() throws RobotSafetyException {
        double result = FactoryRobotHazardAnalyzer
                .calculateHazardRisk(0.5, 10, "Critical");

        assertEquals(37.5, result, 0.001);
    }

    @Test
    void shouldCalculateRiskForWornMachinery() throws RobotSafetyException {
        double result = FactoryRobotHazardAnalyzer
                .calculateHazardRisk(0.5, 10, "Worn");

        assertEquals(20.5, result, 0.001);
    }

    @Test
    void shouldCalculateRiskForFaultyMachinery() throws RobotSafetyException {
        double result = FactoryRobotHazardAnalyzer
                .calculateHazardRisk(0.5, 10, "Faulty");

        assertEquals(27.5, result, 0.001);
    }

    @Test
    void shouldThrowExceptionForInvalidArmPrecision() {
        assertThrows(RobotSafetyException.class, () ->
                FactoryRobotHazardAnalyzer
                        .calculateHazardRisk(1.5, 10, "Critical"));
    }

    @Test
    void shouldThrowExceptionForInvalidWorkerDensity() {
        assertThrows(RobotSafetyException.class, () ->
                FactoryRobotHazardAnalyzer
                        .calculateHazardRisk(0.5, 25, "Critical"));
    }

    @Test
    void shouldThrowExceptionForUnsupportedMachineryState() {
        RobotSafetyException exception = assertThrows(
                RobotSafetyException.class,
                () -> FactoryRobotHazardAnalyzer
                        .calculateHazardRisk(0.5, 10, "Normal")
        );

        assertEquals(
                "Invalid Machinery State! Use Worn, Faulty, or Critical.",
                exception.getMessage()
        );
    }

    @Test
    void shouldRejectLowercaseMachineryState() {
        assertThrows(RobotSafetyException.class, () ->
                FactoryRobotHazardAnalyzer
                        .calculateHazardRisk(0.5, 10, "worn"));
    }
}

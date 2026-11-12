
package com.factory.robot;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class FactoryRobotHazardAnalyzerTest {

    // UC1 + UC2: Test input acceptance and display
    @Test
    void shouldAcceptAndDisplayRobotInputs() {

        String simulatedInput = "0.5\n10\nCritical\n";

        InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setIn(new ByteArrayInputStream(
                    simulatedInput.getBytes()
            ));

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
    }

    // UC3: Test Critical machinery
    @Test
    void shouldCalculateCorrectHazardRisk() {

        double result =
                FactoryRobotHazardAnalyzer.calculateHazardRisk(
                        0.5, 10, "Critical"
                );

        assertEquals(37.5, result, 0.001);
    }

    // UC3: Test Worn machinery
    @Test
    void shouldCalculateRiskForWornMachinery() {

        double result =
                FactoryRobotHazardAnalyzer.calculateHazardRisk(
                        0.5, 10, "Worn"
                );

        assertEquals(20.5, result, 0.001);
    }

    // UC3: Test Faulty machinery
    @Test
    void shouldCalculateRiskForFaultyMachinery() {

        double result =
                FactoryRobotHazardAnalyzer.calculateHazardRisk(
                        0.5, 10, "Faulty"
                );

        assertEquals(27.5, result, 0.001);
    }

    // UC4: Test invalid arm precision
    @Test
    void shouldRejectInvalidArmPrecision() {

        String simulatedInput = "1.5\n10\nCritical\n";

        InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setIn(new ByteArrayInputStream(
                    simulatedInput.getBytes()
            ));

            System.setOut(new PrintStream(output));

            FactoryRobotHazardAnalyzer.main(new String[]{});

        } finally {
            System.setIn(originalInput);
            System.setOut(originalOutput);
        }

        String result = output.toString();

        assertTrue(result.contains("Error: Invalid Arm Precision!"));
        assertFalse(result.contains("Robot Hazard Risk Score:"));
    }
}

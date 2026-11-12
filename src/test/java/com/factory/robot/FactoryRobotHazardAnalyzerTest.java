
package com.factory.robot;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FactoryRobotHazardAnalyzerTest {

    @Test
    void shouldAcceptAndDisplayRobotInputs() {

        String simulatedInput = "0.5\n10\nCritical\n";

        InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;

        ByteArrayOutputStream output =
                new ByteArrayOutputStream();

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
}

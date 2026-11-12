
package com.factory.robot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactoryRobotHazardAnalyzerTest {

    @Test
    void shouldDisplayStaticHazardMessage() {

        // Capture console output
        ByteArrayOutputStream output =
                new ByteArrayOutputStream();

        PrintStream originalOutput = System.out;

        try {
            System.setOut(new PrintStream(output));

            // Execute main method
            FactoryRobotHazardAnalyzer.main(new String[]{});

        } finally {
            System.setOut(originalOutput);
        }

        // Verify expected output
        assertEquals(
                "Factory Robot Hazard Analyzer"
                        + System.lineSeparator(),
                output.toString()
        );
    }
}

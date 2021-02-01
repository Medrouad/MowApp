package com.mrouad.mowitnow;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import com.mrouad.mowitnow.instructions.InstructionsScanner;
import org.junit.Assert;
import org.junit.Test;

public class TestInputExampleInstructionsFromTextInput {

    @Test
    public void testInstructions() {

        // set the line separator to avoid running into platform-specific issues
        System.setProperty("line.separator", "\n");

        // prepare the input
        String instructions = "5 5\n" + "1 2 N\n" + "GAGAGAGAA\n" + "3 3 E\n" + "AADAADADDA";
        InputStream in = new ByteArrayInputStream(instructions.getBytes());

        // prepare the output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printOut = new PrintStream(out);

        // apply the input into the output
        InstructionsScanner scanner = new InstructionsScanner();
        scanner.processIOStream(in, printOut);

        // check the output
        String actual = out.toString();
        Assert.assertEquals("1 3 N\r\n" + "5 1 E\r\n", actual);

    }

}

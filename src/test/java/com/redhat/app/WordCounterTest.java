package com.redhat.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for WordCounter App.
 */
public class WordCounterTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * I disabled the System.err because it's annoying (cred: https://stackoverflow.com/questions/5936562/disable-system-err)
     *
     * @param testName name of the test case
     */
    public WordCounterTest( String testName )
    {
        super( testName );

        System.setErr(new PrintStream(new OutputStream() {
            public void write(int b) {
            }
        }));
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( WordCounterTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testBadFile() {
        Map<String, Integer> m = WordCounter.processFiles(new String[]{"bad_file.txt"});

        assertTrue(m.isEmpty());
    }

    public void testSimpleFile() {
        Map<String, Integer> m = WordCounter.processFiles(new String[]{"src/test/resources/words_only.txt"});

        Map<String, Integer> expected = new HashMap<>();
        expected.put("big", 1);
        expected.put("tru", 1);
        expected.put("redhat", 2);
        expected.put("panda", 1);

        assertEquals(expected, m);
    }

    public void testMultipleFiles() {
        Map<String, Integer> m = WordCounter.processFiles(new String[]{"src/test/resources/words_only.txt", "src/test/resources/more_words.txt"});

        Map<String, Integer> expected = new HashMap<>();
        expected.put("big", 1);
        expected.put("tru", 1);
        expected.put("redhat", 2);
        expected.put("unicorn", 3);
        expected.put("panda", 3);
        expected.put("eclipse", 1);

        assertEquals(expected, m);
    }
    public void testEmptyFile() {
        Map<String, Integer> m = WordCounter.processFiles(new String[]{"src/test/resources/empty.txt"});

        assertTrue(m.isEmpty());
    }
}

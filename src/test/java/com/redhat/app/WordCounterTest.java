package com.redhat.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for WordCounter App.
 */
public class WordCounterTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public WordCounterTest( String testName )
    {
        super( testName );
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
    public void testWordCounter()
    {
        //Implement a test here
        assertTrue( true );
    }
}

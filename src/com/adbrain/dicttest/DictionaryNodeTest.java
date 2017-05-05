package com.adbrain.dicttest;

import static org.junit.Assert.*;
import com.adbrain.dict.DictionaryNode;
import org.junit.Before;
import org.junit.Test;


// -------------------------------------------------------------------------
/**
 *  Tests the DictionaryNode class.
 *
 *  @author Varun Sharma
 *  @version May 5, 2017
 */
public class DictionaryNodeTest
{

    /**
     * Test instance for dictionaryNode.
     */
    DictionaryNode testDictNode;


    // ----------------------------------------------------------
    /**
     * Sets up a test instance of DictionaryNode class.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        testDictNode = new DictionaryNode();
    }


    // ----------------------------------------------------------
    /**
     * Tests the getter and setter methods of the DictionaryNode class.
     */
    @Test
    public void testDictionaryNode() {
        assertNull(testDictNode.getTerm());
        testDictNode.setTerm("test");
        assertEquals("test", testDictNode.getTerm());
    }

}

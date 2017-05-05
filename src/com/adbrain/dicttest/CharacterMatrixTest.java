package com.adbrain.dicttest;

import static org.junit.Assert.*;
import com.adbrain.dict.CharacterMatrix;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;


// -------------------------------------------------------------------------
/**
 *  Tests for CharacterMatrix class.
 *
 *  @author Varun Sharma
 *  @version May 5, 2017
 */
public class CharacterMatrixTest
{

    /**
     * Test instance for CharacterMatrix class.
     */
    CharacterMatrix testInstance;


    // ----------------------------------------------------------
    /**
     * Sets up CharacterMatrix instance.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {

        testInstance = new CharacterMatrix();
    }


    // ----------------------------------------------------------
    /**
     * A sunny day scenario with a dictionary and character matrix defined.
     */
    @Test
    public void testSunnyDay() {

        String[] dict = {"add", "ago", "age", "red", "burn", "peg", "ten", "fur"};
        char[][] charMatrix = {{'A', 'G', 'O', 'I', 'C'},
                               {'D', 'E', 'R', 'U', 'F'},
                               {'M', 'P', 'N', 'B', 'H'},
                               {'S', 'T', 'E', 'F', 'W'}};

        List<String> expectedList = Arrays.asList(dict);
        Collections.sort(expectedList); // Sorts list alphabetically.

        List<String> actualList = testInstance.findValidWords(charMatrix, dict);
        Collections.sort(actualList);

        assertEquals(expectedList, actualList);

    }


    // ----------------------------------------------------------
    /**
     * Tests for an empty dictionary, should return a null list.
     */
    @Test
    public void testEmptyDictionary() {

        String[] dict = {};
        char[][] charMatrix = {{'A', 'G', 'O', 'I', 'C'},
                               {'D', 'E', 'R', 'U', 'F'},
                               {'M', 'P', 'N', 'B', 'H'},
                               {'S', 'T', 'E', 'F', 'W'}};

        assertNull(testInstance.findValidWords(charMatrix, dict));
    }


    // ----------------------------------------------------------
    /**
     * Test for an invalid character matrix ('#' present in the matrix), should
     * return null.
     */
    @Test
    public void testInvalidCharMatrix() {

        String[] dict = {"add", "ago", "age", "red", "burn", "peg", "ten", "fur"};
        char[][] charMatrix = {{'A', 'G', 'O', 'I', 'C'},
                               {'D', 'E', 'R', 'U', 'F'},
                               {'M', 'P', '#', 'B', 'H'},
                               {'S', 'T', 'E', 'F', 'W'}};

        assertNull(testInstance.findValidWords(charMatrix, dict));
    }


    // ----------------------------------------------------------
    /**
     * Tests a small dictionary of words.
     */
    @Test
    public void testSmallDictionary() {

        String[] dict = {"Add", "Red", "Peg"};
        char[][] charMatrix = {{'A', 'G', 'O', 'I', 'C'},
                               {'D', 'E', 'R', 'U', 'F'},
                               {'M', 'P', 'N', 'B', 'H'},
                               {'S', 'T', 'E', 'F', 'W'}};

        List<String> expectedList = Arrays.asList(dict);
        Collections.sort(expectedList); // Sorts list alphabetically.

        List<String> actualList = testInstance.findValidWords(charMatrix, dict);
        Collections.sort(actualList);

        assertEquals(expectedList, actualList);

    }


    // ----------------------------------------------------------
    /**
     * Tests a dictionary which contains repeated characters.
     */
    @Test
    public void testDictionaryWithRepeats() {

        String[] dict = {"add", "buff", "feet", "peer", "teen"};
        char[][] charMatrix = {{'A', 'G', 'O', 'I', 'C'},
                               {'D', 'E', 'R', 'U', 'F'},
                               {'M', 'P', 'N', 'B', 'H'},
                               {'S', 'T', 'E', 'F', 'W'}};

        List<String> expectedList = Arrays.asList(dict);
        Collections.sort(expectedList); // Sorts list alphabetically.

        List<String> actualList = testInstance.findValidWords(charMatrix, dict);
        Collections.sort(actualList);

        assertEquals(expectedList, actualList);

    }


    // ----------------------------------------------------------
    /**
     * Tests a huge dictionary of words. Some words in the dictionary are made
     * up just for testing scenario.
     */
    @Test
    public void testBigDictionary() {

        String[] dict = { "add", "ago", "age", "red", "burn", "peg", "ten",
            "fur", "buff", "feet", "peer", "teen", "peru", "addms", "geepts",
            "orepts", "oregad", "buic", "fubnp", "whbnpm", "tefbui"};
        char[][] charMatrix = {{'A', 'G', 'O', 'I', 'C'},
                               {'D', 'E', 'R', 'U', 'F'},
                               {'M', 'P', 'N', 'B', 'H'},
                               {'S', 'T', 'E', 'F', 'W'}};

        List<String> expectedList = Arrays.asList(dict);
        Collections.sort(expectedList); // Sorts list alphabetically.

        List<String> actualList = testInstance.findValidWords(charMatrix, dict);
        Collections.sort(actualList);

        assertEquals(expectedList, actualList);

    }

}

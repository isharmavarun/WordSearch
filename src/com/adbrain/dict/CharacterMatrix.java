package com.adbrain.dict;

import java.util.ArrayList;
import java.util.List;


// -------------------------------------------------------------------------
/**
 *  CharacterMatrix class constructs a Trie data structure out of the dictionary
 *  words and then looks up valid words inside a character matrix using depth-
 *  first search on the matrix.
 *
 *  @author Varun Sharma
 *  @version May 5, 2017
 */
public class CharacterMatrix
{

    // ----------------------------------------------------------
    /**
     * Builds the Trie structure for a dictionary of words.
     * Example:
     *
     *                      ___Root___
     *                     /          \
     *                    a      ...   t   ...
     *                  /  \            \
     *                 d    g      ...   e  ...
     *                /    / \            \
     *               d    e   o      ...   n  ...
     *             (Add)(Age)(Ago)       (Ten)
     *
     * @param dict
     * @return root of dictionary containing all the dictionary words.
     */
    public DictionaryNode buildDictionary(String[] dict) {
        DictionaryNode root = new DictionaryNode();

        // Traverse the dictionary of words.
        for(String word: dict) {
            DictionaryNode temp = root;

            // Traverse the word and construct references in the trie.
            for(char c : word.toLowerCase().toCharArray()) {
                int k = this.getCharIndex(c);

                if(temp.references[k] == null)
                    temp.references[k] = new DictionaryNode();

                temp = temp.references[k];
            }

            // Save the word if Trie leaf is reached.
            // Store only lower case words in the Trie.
            temp.setTerm(word);
        }

        return root;
    }


    // ----------------------------------------------------------
    /**
     * Returns the index of a char (ASCII) , a value between 0 and 25.
     * Returns -1 if char is invalid and does not fall between the range.
     *
     * @param c
     * @return the index of the char in the field references
     */
    public int getCharIndex(char c)
    {
        int temp = c;
        int temp_integer = 97; // for lower case
        if (temp <= 122 & temp >= 97)
            return temp - temp_integer;
        return -1;
    }


    // ----------------------------------------------------------
    /**
     * Checks if the given character matrix contains any invalid characters.
     *
     * @param charMatrix
     * @return false if matrix contains any invalid characters else true.
     */
    public boolean isValidMatrix(char[][] charMatrix) {

        boolean flag = true;
        for(int i = 0; i < charMatrix.length; i++) {
            for(int j = 0; j < charMatrix[0].length; j++) {
                if(getCharIndex(Character.toLowerCase(charMatrix[i][j])) == -1)
                    return false;
            }
        }
        return flag;
    }


    // ----------------------------------------------------------
    /**
     * Returns a list of valid words from the matrix present in the dictionary.
     * Also, a wrapper method.
     *
     * @param charMatrix
     * @param dictionaryWords
     * @return the final list of valid words
     *
     */
    public List<String> findValidWords(char[][] charMatrix, String[] dictionaryWords) {

        List<String> result = new ArrayList<String>();

        // Error checking: empty dictionary or invalid characters in matrix.
        if(dictionaryWords.length == 0 || !isValidMatrix(charMatrix))
            return null;

        // Construct the Dictionary Trie.
        DictionaryNode dictionaryRoot = buildDictionary(dictionaryWords);

        // Iterate over all characters in the matrix.
        for(int i = 0; i < charMatrix.length; i++) {
            for(int j = 0; j < charMatrix[0].length; j++) {
                this.findValidWords(charMatrix, i, j, dictionaryRoot, result);
            }
        }

        return result;
    }


    // ----------------------------------------------------------
    /**
     * Recursive method which takes care of performing the depth-first search
     * on the dictionary root node.
     *
     * @param charMatrix
     * @param i
     * @param j
     * @param node
     * @param result
     */
    public void findValidWords(char[][] charMatrix, int i, int j, DictionaryNode node, List<String> result) {
        char origChar = charMatrix[i][j];
        char c = Character.toLowerCase(charMatrix[i][j]);

        // Base Condition: If node already visited or reference at that char
        // is null.
        if(c == '*' || node.references[this.getCharIndex(c)] == null)
            return;

        // Move to next reference.
        DictionaryNode nextNode = node.references[this.getCharIndex(c)];

        // Store the word in the final result.
        if(nextNode.getTerm() != null) {
            result.add(nextNode.getTerm());
            nextNode.setTerm(null);
        }

        // Handle repeats of characters if they exist.
        this.findValidWords(charMatrix, i, j, nextNode, result);

        // Mark visited.
        charMatrix[i][j] = '*';

        // Traverse adjacent characters.
        if(i > 0)
            this.findValidWords(charMatrix, i - 1, j, nextNode, result);

        if(j > 0)
            this.findValidWords(charMatrix, i, j - 1, nextNode, result);

        if(i < charMatrix.length - 1)
            this.findValidWords(charMatrix, i + 1, j, nextNode, result);

        if(j < charMatrix[0].length - 1)
            this.findValidWords(charMatrix, i, j + 1, nextNode, result);

        // Reset visited char.
        charMatrix[i][j] = origChar;
    }

}

package com.adbrain.dict;


// -------------------------------------------------------------------------
/**
 *  A DictionaryNode holds all references to other characters and term if leaf
 *  node. It represents a Trie data structure.
 *
 *  @author Varun Sharma
 *  @version May 5, 2017
 */
public class DictionaryNode {

    /**
     * Internal references to all other characters of a word.
     */
    protected DictionaryNode[] references;

    /**
     * Term of the node.
     * Holds the word if leaf node else holds null.
     */
    private String term;


    // ----------------------------------------------------------
    /**
     * Creates a new DictionaryNode object and initializes all the character
     * references.
     */
    public DictionaryNode() {
        this.term = null;
        this.references = new DictionaryNode[26];
        for (int i = 0; i < 26; i++) {
            this.references[i] = null;
        }
    }


    // ----------------------------------------------------------
    /**
     * Retrieves the term held by the node.
     *
     * @return term associated to the reference node.
     */
    public String getTerm() {
        return this.term;
    }


    // ----------------------------------------------------------
    /**
     * Sets the term value of a node.
     *
     * @param term
     */
    public void setTerm(String term) {
        this.term = term;
    }
}

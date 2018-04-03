package com.example.rohat.rohatgianishaassignment42;


public class WordPair
{
    int id;
    String originalWord, antonymWord, searchWord;

    public void setID(int id)
    {
        this.id = id;
    }

    public int getID()
    {
        return this.id;
    }

    public void setSearchWord (String searchWord)
    {
        this.searchWord = searchWord;
    }

    public String getSearchWord ()
    {
        return this.searchWord;
    }


    public void setOriginalWord (String originalWord)
    {
        this.originalWord = originalWord;
    }

    public String getOriginalWord ()
    {
        return this.originalWord;
    }

    public void setAntonymWord (String antonymWord)
    {
        this.antonymWord = antonymWord;
    }

    public String getAntonymWord ()
    {
        return this.antonymWord;
    }
}

package spelling;

import java.util.LinkedList;

/**
 * A class that implements the Dictionary interface using a LinkedList
 *
 */
public class DictionaryLL implements Dictionary 
{

	private LinkedList<String> dict;
	public DictionaryLL()
	{
       dict=new LinkedList<String>();
	}
    // TODO: Add a constructor


    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	
   
    	if(dict.contains(word.toLowerCase()))
    	{
    		return true;
    	}
    	else
    	{
    		dict.add(word.toLowerCase());
    		return true;
    	}
    	// TODO: Implement this method
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
        // TODO: Implement this method
        return dict.size();
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
    	if(dict.contains(s.toLowerCase()))
    		return true;
        //TODO: Implement this method
        return false;
    }

    
}

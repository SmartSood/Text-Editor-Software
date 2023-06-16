package spelling;

import java.util.List;

import java.util.Set;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/** 
 * An trie data structure that implements the Dictionary and the AutoComplete ADT
 * @author Smarth Sood
 *
 */
public class AutoCompleteDictionaryTrie implements  Dictionary, AutoComplete {

    private TrieNode root;
    private int size;
    

    public AutoCompleteDictionaryTrie()
	{
		root = new TrieNode();
		size=0;
	}
	
	
	/** Insert a word into the trie.
	 * For the basic part of the assignment (part 2), you should convert the 
	 * string to all lower case before you insert it. 
	 * 
	 * This method adds a word by creating and linking the necessary trie nodes 
	 * into the trie, as described outlined in the videos for this week. It 
	 * should appropriately use existing nodes in the trie, only creating new 
	 * nodes when necessary. E.g. If the word "no" is already in the trie, 
	 * then adding the word "now" would add only one additional node 
	 * (for the 'w').
	 * 
	 * @return true if the word was successfully added or false if it already exists
	 * in the dictionary.
	 */
	public boolean addWord(String word)
	{
		//word=word.toLowerCase();
		TrieNode ref=root;
		int j=0;
		String ref2=word;
		
		for(int i=0;i<word.length();i++)
         {
        	 char ch=word.charAt(i);
        	 if(ref.getChild(ch)!=null)
        	 ref=ref.getChild(ch);
        	 else
        	 {
        		 if(i!=word.length()-1)
        		 {
        			 ref.insert(ch);
        		 ref=ref.getChild(ch);
        		 }
        		 else
        		 j++;
        	 }
         }
         if(j==1)
         {
        	 ref.insert(word.charAt(word.length()-1));
        	 ref.getChild(word.charAt(word.length()-1)).setEndsWord(true);
        	 size++;
        	 ref=ref.getChild(word.charAt(word.length()-1));
        	 return true;
         }
         //if(ref2.equals(ref.getText())==false)
        	 //size++;
	    //TODO: Implement this method.
	    return false;
	
	}
	
	/** 
	 * Return the number of words in the dictionary.  This is NOT necessarily the same
	 * as the number of TrieNodes in the trie.
	 */
	public int size()
	{
	    //TODO: Implement this method
	    return size;
	}
	
	
	/** Returns whether the string is a word in the trie, using the algorithm
	 * described in the videos for this week. */
	@Override
	public boolean isWord(String s) 
	{
		//s=s.toLowerCase();
		TrieNode curr=root;
		for(int i=0;i<(s.length());i++)
		{
			if((curr.getChild(s.charAt(i))!=null))
			curr=curr.getChild(s.charAt(i));
		
			else
			{
        		 return false;
				
			}
		}
			if(curr.endsWord())
			return true;
			else
				return false;
	}
		
	    // TODO: Implement this method
		

	/** 
     * Return a list, in order of increasing (non-decreasing) word length,
     * containing the numCompletions shortest legal completions 
     * of the prefix string. All legal completions must be valid words in the 
     * dictionary. If the prefix itself is a valid word, it is included 
     * in the list of returned words. 
     * 
     * The list of completions must contain 
     * all of the shortest completions, but when there are ties, it may break 
     * them in any order. For example, if there the prefix string is "ste" and 
     * only the words "step", "stem", "stew", "steer" and "steep" are in the 
     * dictionary, when the user asks for 4 completions, the list must include 
     * "step", "stem" and "stew", but may include either the word 
     * "steer" or "steep".
     * 
     * If this string prefix is not in the trie, it returns an empty list.
     * 
     * @param prefix The text to use at the word stem
     * @param numCompletions The maximum number of predictions desired.
     * @return A list containing the up to numCompletions best predictions
     */@Override
     public List<String> predictCompletions(String prefix, int numCompletions) 
     {
    	 /*List<String> completions=new LinkedList<String>();
    	 
    	 prefix=prefix.toLowerCase();
    	 TrieNode curr=root;
    	 // TODO: Implement this method
    	 List<String> queue =new LinkedList<String>();    	 // This method should implement the following algorithm:3
    	 for(int i=0;i<prefix.length()-1;i++)
    	 {
    		 char ch=prefix.charAt(i);
    		 if(curr.getChild(ch)!=null)
    		 curr=curr.getChild(ch);
    		 else
    		return queue;
    		 
    	 }
    	 
        Set<Character> ch=curr.getValidNextCharacters();
        for(char ch1:ch)
        {
        	queue.add(prefix+Character.toString(ch1));
        }
         queue.add(prefix);
    	 
    	 int i=0;
    	 while(queue.isEmpty()==false&&i<numCompletions)
    	 {
    		 
    		 String s=queue.get(0);
    		 queue.remove(0);
    		 if(s.length()-curr.getText().length()==1)
    		 {
    		 if(curr.getChild(s.charAt(s.length()-1)).endsWord())
    		 {
    			 completions.add(s);
    			 i++;
    			Set<Character> ch3=curr.getChild(s.charAt(s.length()-1)).getValidNextCharacters();
    			for(char ch4:ch3)
    			{
    				queue.add(prefix+Character.toString(ch4));
    			}
    		 }
    		 }
    		 else
    		 {
    			 int index=curr.getText().length();
    			 while(s.length()-curr.getText().length()==1)
    			 {
    				 
    				 curr=curr.getChild(s.charAt(index));
    				 index++;
    			 }
    		 }
    		 
    	 }
    	 // 1. Find the stem in the trie.  If the stem does not appear in the trie, return an
    	 //    empty list
    	 // 2. Once the stem is found, perform a breadth first search to generate completions
    	 //    using the following algorithm:
    	 //    Create a queue (LinkedList) and add the node that completes the stem to the back
    	 //       of the list.
    	 //    Create a list of completions to return (initially empty)
    	 //    While the queue is not empty and you don't have enough completions:
    	 //       remove the first Node from the queue
    	 //       If it is a word, add it to the completions list
    	 //       Add all of its child nodes to the back of the queue
    	 // Return the list of completions
    	 
         return completions;*/
    	 LinkedList<TrieNode> ns = new LinkedList<TrieNode>();
    	 List<String> completions = new LinkedList<String>();
    	 TrieNode nod = root;
    	 prefix = prefix.toLowerCase();
    	 for (char c : prefix.toCharArray()) {
    		 nod = nod.getChild(c);
    		 if (nod== null) {
    			 return completions;
    		 }
    	 }
    	 ns.add(nod);
    	 
    	 while (!ns.isEmpty() && completions.size() < numCompletions) {
    		 nod = ns.remove();
    		 if (nod.endsWord()==true) {
    			 completions.add(nod.getText());
    		 }
    		 
    		 Set<Character> children = nod.getValidNextCharacters();
    		 for (char c : children) {
    			 ns.add(nod.getChild(c));
    		 }
    	 }
    	 return completions;
     }

 	// For debugging
 	
 	

     

 	// For debugging
 	public void printTree()
 	{
 		printNode(root);
 	}
 	
 	/** Do a pre-order traversal from this node down */
 	public void printNode(TrieNode curr)
 	{
 		if (curr == null) 
 			return;
 		
 		System.out.println(curr.getText());
 		
 		TrieNode next = null;
 		for (Character c : curr.getValidNextCharacters()) {
 			next = curr.getChild(c);
 			printNode(next);
 		}
 	}
 	

	
}
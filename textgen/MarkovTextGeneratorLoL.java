package textgen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.*;
import java.util.ArrayList;
import java.util.ArrayList;/** 
 * An implementation of the MTG interface that uses a list of lists.
 * @author UC San Diego Intermediate Programming MOOC team 
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	// The list of words with their next words
	private List<ListNode> wordList; 
	
	// The starting "word"
	private String starter;
	
	// The random number generator
	private Random rnGenerator;
	
	public MarkovTextGeneratorLoL(Random generator)
	{
		wordList = new LinkedList<ListNode>();
		starter = "";
		rnGenerator = generator;
	}
	
	protected List<String> getTokens(String pattern)
	{
		String text=wordList.toString();
		ArrayList<String> tokens = new ArrayList<String>();
		Pattern tokSplitter = Pattern.compile(pattern);
		Matcher m = tokSplitter.matcher(text);
		
		while (m.find()) {
			tokens.add(m.group());
		}
		
		return tokens;
	}
	
	/** Train the generator by adding the sourceText */
	@Override
	public void train(String sourceText)
	{ 
		
		ArrayList<String> tokens = new ArrayList<String>();
		Pattern tokSplitter = Pattern.compile("[a-z||A-Z]+");
		Matcher m = tokSplitter.matcher(sourceText);
		
		while (m.find()) {
			tokens.add(m.group());
		}
		for(String s2:tokens)
		{
		starter=s2;
		break;
		}
		String prevword=starter;
		int j=-1;
	  for(String s:tokens)
	  {
		  j++;
		  if(s==starter)
			  continue;
		  int x=0;
		  int y=0;
		  for(ListNode ln:wordList)
		  {
			  if(ln.getWord().equals(prevword))
			  {
				  y++;
				  break;
			  }
			  x++;
		  }
		  if(y==1)
		  {
			  
			  (wordList.get(x)).addNextWord(s);
			 
			  
		  }
		  else
		  {
			  ListNode s1=new ListNode(prevword);
			  wordList.add(s1);
			  s1.addNextWord(s);
		  }
		  prevword=s;
		  }
	  
			String s3=tokens.get(j);
			int x=0,y=0;
			for(ListNode ln:wordList)
			  {
				  if(ln.getWord().equals(s3))
				  {
					  y++;
					  break;
				  }
				  x++;
			  }
		
				if(y==1)
				  {
					  
					  (wordList.get(x)).addNextWord(starter);
					 
					  
				  }
				  else
				  {
					  ListNode s1=new ListNode(s3);
					  wordList.add(s1);
					  s1.addNextWord(starter);
				  }
		}		// TODO: Implement this method
	
	  
	
	/** 
	 * Generate the number of words requested.
	 */
	@Override
	public String generateText(int numWords) {
	    // TODO: Implement this method
		String currWord=starter;
		String output=null;
		output=currWord;
		int i=1;
		while(i<=numWords)
		{
			int x=0;
			ListNode ln2=null;
			for(ListNode ln:wordList)
			  {
				  if((ln.getWord()).equals(currWord))
				  {
					  ln2=ln;
					  break;
				  }
				  x++;
			  }
			String random=ln2.getRandomNextWord(rnGenerator);
			output=output+" "+random;
			currWord=random;
	  i++;
		}
		return output;
	}
	
	
	// Can be helpful for debugging
	@Override
	public String toString()
	{
		String toReturn = "";
		for (ListNode n : wordList)
		{
			toReturn += n.toString();
		}
		return toReturn;
	}
	
	/** Retrain the generator from scratch on the source text */
	@Override
	public void retrain(String sourceText)
	{
		for(ListNode ln:wordList)
		{
			String s=ln.toString(); 
			
		}
		
		// TODO: Implement this method.
	}
	
	// TODO: Add any private helper methods you need here.
	
	
	/**
	 * This is a minimal set of tests.  Note that it can be difficult
	 * to test methods/classes with randomized behavior.   
	 * @param args
	 */
	public static void main(String[] args)
	{
		String textString1="hi there hi Leo.";
		// feed the generator a fixed random value for repeatable behavior
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(42));
		String textString = "Hello.  Hello there.  This is a test.  Hello there.  Hello Bob.  Test again.";
		System.out.println(textString);
		gen.train(textString);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
		String textString2 = "You say yes, I say no, "+
				"You say stop, and I say go, go, go, "+
				"Oh no. You say goodbye and I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"I say high, you say low, "+
				"You say why, and I say I don't know. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"Why, why, why, why, why, why, "+
				"Do you say goodbye. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"You say yes, I say no, "+
				"You say stop and I say go, go, go. "+
				"Oh, oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello,";
		
		System.out.println(textString2);
		gen.retrain(textString2);
		System.out.println(gen);
		System.out.println(gen.generateText(20));

	}

}

/** Links a word to the next words in the list 
 * You should use this class in your implementation. */
class ListNode
{
    // The word that is linking to the next words
	private String word;
	
	// The next words that could follow it
	private List<String> nextWords;
	
	ListNode(String word)
	{
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public String getWord()
	{
		return word;
	}

	public void addNextWord(String nextWord)
	{
		nextWords.add(nextWord);
	}
	
	public String getRandomNextWord(Random generator)
	{
		int upperbound=nextWords.size();
		String s= nextWords.get(generator.nextInt(upperbound));
		
		// TODO: Implement this method
	    // The random number generator should be passed from 
	    // the MarkovTextGeneratorLoL class
	    return s;
	}

	public String toString()
	{
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}
	
}



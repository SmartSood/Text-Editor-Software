 package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @SmarthSood UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E>
{
	LLNode<E> head;
	LLNode<E> tail;
	int size;
	E objElement;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		
		head= new LLNode<E>(null);
		tail=new LLNode<E>(null);
		size=0;
		head.next=tail;
		tail.prev=head;
		tail.next=head;
		head.prev=tail;
	
		// TODO: Implement this method
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		if(element==null)
		{
			throw (new NullPointerException());
		
		}
		else
		{
			
		 
		 LLNode<E> current;
		 current=new LLNode<E>(element);
		current.next=tail;
		current.prev=tail.prev;
		tail.prev.next=current;
		tail.prev=current;
		
		
		 
		 
			size++;
			return true;
		}
		// TODO: Implement this method
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
	if(index<0||(index>=size))
		throw new IndexOutOfBoundsException();
	else
	{
		int i=0;
		LLNode<E> check= head.next;
		while(true)
		{   
			if(i==index)
			{
			
				return check.data;
			}
			else
			{
				check=check.next;
				i++;
			}
		}
	}
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		if(element==null) {
			
		
			throw new NullPointerException();
		}
		if(index>size||index<0)
		{
			
			throw new IndexOutOfBoundsException();
		}
		else
		{
			
			int j=0;
			 LLNode<E> ref=head.next;
			while(j!=index)
			{
			 ref=ref.next;
			 j++;
			}
			 LLNode<E> nodeplace=new LLNode<E>(element);
			 nodeplace.next=ref;
			 nodeplace.prev=ref.prev;
			 ref.prev.next=nodeplace;
			 ref.prev=nodeplace;
			 size++;
			 }
		// TODO: Implement this method
	}


	/** Return the size of the list */
	public int size() 
	{
		
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		if(index<0||index>size)
		{
		throw new IndexOutOfBoundsException();
		}
		else {
		int j=0;
		 LLNode<E> ref=head.next;
		while(j!=index)
		{
		 ref=ref.next;
		 j++;
		}
		ref.next.prev=ref.prev;
		ref.prev.next=ref.next;
		ref.next=null;
		ref.prev=null;
		size--;
		//by commenting the above two lines the refrence
		//of ref to the next and prev will be restored
		
		// TODO: Implement this method
		return ref.data;
	}
}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if(index<0||index>=size)
			throw new IndexOutOfBoundsException();
		else
		{
			int j=0;
			 LLNode<E> ref=head.next;
			while(j!=index)
			{
			 ref=ref.next;
			 j++;
			}
			E old=ref.data;
			ref.data=element;
		return old;
	}   
}
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}

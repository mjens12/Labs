package lab10;

public class LinkListLab {
	private Node top;

	public LinkListLab() {
		top = null;
	}

	/****************************************************************
	 *   Determines the size, that is, the number of elements in the
	 * list
	 *
	 * @return  the size of the list  
	 ****************************************************************/
	public int getLen() {
		int count = 0;

		Node temp = top;

		if (top == null)
			return 0;

		else {
			while (temp.getNext() != null) {
				temp = temp.getNext();
				count++;
			}
		}

		return count;
	}

	/****************************************************************
	 *   Inserts a node before a specific index.  When the list is empty
	 * that is, top = null, then the index must be 0. After the first
	 * element is added, index must be:  0 <= index < size of list    
	 * 
	 * @param index
	 *            a specific index into the list.  
	 * @throws IllegalArgumentStringxception
	 *             if index < 0 or  index >= size of the list
	 * 
	 ****************************************************************/

	public void insertBefore(int index, String data) {
		if ((index < 0) || (index >= getLen())) {
			throw new IllegalArgumentException();
		} else {
			if (top == null) {
				top = new Node(data, null);
			} else {
				Node temp = top;
				// gets to the node at index
				for (int i = 0; i < index; i++) {
					temp = temp.getNext();
				}

			}
		}
	}

	/****************************************************************
	 *   Inserts a node after a specific index.  When the list is empty
	 * that is, top = null, then the index must be 0. After the first
	 * element is added, index must be:  0 <= index < size of list    
	 * 
	 * @param index
	 *            a specific index into the list.    * @throws
	 *            IllegalArgumentStringxception if index < 0 or  index
	 *            >= size of the list
	 * 
	 ****************************************************************/

	public void insertAfter(int index, String data) {
		// place your code here
	}

	/****************************************************************
	 *   Removes the top element of the list  
	 * 
	 * @return returns the element that was removed.  
	 * @throws RuntimeStringxception
	 *             if top == null, that is,   there is no list.  
	 ****************************************************************/

	public String removeTop() {
		return null;
	}

	/****************************************************************
	 *   This Method removes a node at the specific index position.  The
	 * first node is index 0.  
	 * 
	 * @param index
	 *            the position in the linked list that is to be 
	 *            removed.  The first position is zero.    
	 * @throws IllegalArgumentStringxception
	 *             if index < 0 or  index >= size of the list  
	 ****************************************************************/
	public boolean delAt(int index) {
		return false;
	}

	// A simple testing program.  Not complete but a good start.

	public static void main(String[] args) {
		LinkListLab list = new LinkListLab();

		list.display();
		System.out.println("Current length = " + list.getLen());

		list.insertBefore(0, "apple");
		list.insertBefore(0, "pear");
		list.insertBefore(1, "peach");
		list.insertBefore(1, "cherry");
		list.insertBefore(3, "donut");
		list.insertAfter(0, "apple");
		list.insertAfter(0, "pear");
		list.insertAfter(1, "peach");
		list.insertAfter(1, "cherry");
		list.insertAfter(3, "donut");
		list.display();

		list.removeTop();
		list.delAt(4);
		list.delAt(2);
		list.delAt(0);
		list.removeTop();
		list.removeTop();

		list.display();
	}

	public void display() {
		Node temp = top;

		System.out.println("___________ List ________________________");
		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}
}

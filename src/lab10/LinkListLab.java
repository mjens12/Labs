package lab10;

public class LinkListLab {
	private Node top;
	private Node tail;

	public LinkListLab() {
		top = null;
		tail = null;
	}

	/****************************************************************
	 * Determines the size, that is, the number of elements in the list
	 *
	 * @return  the size of the list  
	 ****************************************************************/
	public int getLen() {
		int count = 1;

		Node temp = top;

		if (temp == null)
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
	 * Inserts a node before a specific index.  When the list is empty that is, top
	 * = null, then the index must be 0. After the first element is added, index
	 * must be:  0 <= index < size of list    
	 * 
	 * @param index
	 *            a specific index into the list.  
	 * @throws IllegalArgumentStringxception
	 *             if index < 0 or  index >= size of the list
	 * 
	 ****************************************************************/

	public void insertBefore(int index, String data) {
		if (top == null) {
			tail = top = new Node(data, null);
		} else {
			if ((index < 0) || (index >= getLen())) {
				throw new IllegalArgumentException();
			} else {
				Node temp = top;
				Node newNode = new Node(data, null);
				if (index == 0) {
					top = newNode;
					newNode.setNext(temp);
					newNode.setPrev(null);
				} else {
					// Gets to the node 1 before the index
					for (int i = 0; i < (index - 1); i++) {
						temp = temp.getNext();
					}
					newNode.setNext(temp.getNext());
					temp.setNext(newNode);
					newNode.setPrev(temp);
					temp = temp.getNext();
					temp = temp.getNext();
					temp.setPrev(newNode);
				}
			}
		}
	}

	/****************************************************************
	 *   Inserts a node after a specific index.  When the list is empty that is, top
	 * = null, then the index must be 0. After the first element is added, index
	 * must be:  0 <= index < size of list    
	 * 
	 * @param index
	 *            a specific index into the list.    
	 * @throws IllegalArgumentStringxception
	 *             if index < 0 or  index >= size of the list
	 * 
	 ****************************************************************/

	public void insertAfter(int index, String data) {
		if ((index < 0) || (index >= getLen())) {
			throw new IllegalArgumentException();
		} else {
			if (top == null) {
				tail = top = new Node(data, null);
			} else {
				Node temp = top;
				Node newNode = new Node(data, null);

				// gets to the node at index
				for (int i = 0; i < index; i++) {
					temp = temp.getNext();
				}
				if (temp.getNext() == null) {
					temp.setNext(newNode);
					newNode.setNext(null);
					newNode.setPrev(temp);
					tail = newNode;
				} else {
					newNode.setNext(temp.getNext());
					newNode.setPrev(temp);
					temp.setNext(newNode);
					temp = temp.getNext();
					temp = temp.getNext();
					temp.setPrev(newNode);

				}

			}
		}
	}

	/****************************************************************
	 * Removes the top element of the list  
	 * 
	 * @return returns the element that was removed.  
	 * @throws RuntimeStringxception
	 *             if top == null, that is,   there is no list.  
	 ****************************************************************/

	public String removeTop() {
		Node temp = top;
		Node returnTemp = top;
		if (top == null)
			throw new RuntimeException();
		else {
			if (top == tail) {
				top = null;
				tail = null;
			} else {
				top = temp.getNext();
			}
		}
		return (String) returnTemp.getData();
	}

	/****************************************************************
	 * This Method removes a node at the specific index position.  The first node is
	 * index 0.  
	 * 
	 * @param index
	 *            the position in the linked list that is to be  removed.  The first
	 *            position is zero.    
	 * @throws IllegalArgumentStringxception
	 *             if index < 0 or  index >= size of the list  
	 ****************************************************************/
	public boolean delAt(int index) {
		Node n1 = top;
		Node n2 = null;

		if ((index < 0) || (index >= getLen())) {
			throw new IllegalArgumentException();
		} else {
			if (top == tail) {
				top = null;
				tail = null;
			} else {
				if (index == (getLen() - 1)) {
					// gets to next to last index
					for (int i = 0; i < (index - 1); i++) {
						n1 = n1.getNext();
					}
					n1.setNext(null);
					tail=n1;
				}

				else {
					n1 = top;
					n2 = top;
					// gets to the next to last index
					for (int i = 0; i < (index - 1); i++) {
						n1 = n1.getNext();
					}
					// gets to index+1
					for (int i = 0; i < (index + 1); i++) {
						n2 = n2.getNext();
					}
					n1.setNext(n2);
					n2.setPrev(n1);
				}
			}
		}
		return true;
	}

	// A simple testing program.  Not complete but a good start.

	public static void main(String[] args) {
		LinkListLab list = new LinkListLab();

		list.display();
		System.out.println("Current length = " + list.getLen());

		list.insertBefore(0, "5");
		System.out.println("Current length = " + list.getLen());
		list.insertBefore(0, "4");
		System.out.println("Current length = " + list.getLen());
		list.insertBefore(0, "2");
		System.out.println("Current length = " + list.getLen());
		list.insertBefore(0, "0");
		System.out.println("Current length = " + list.getLen());
		list.insertBefore(1, "1");
		System.out.println("Current length = " + list.getLen());
		list.insertBefore(3, "3");
		System.out.println("Current length = " + list.getLen());
		list.display();
		list.insertAfter(0, "apple");
		System.out.println("Current length = " + list.getLen());
		list.insertAfter(0, "pear");
		System.out.println("Current length = " + list.getLen());
		list.insertAfter(1, "peach");
		System.out.println("Current length = " + list.getLen());
		list.insertAfter(1, "cherry");
		System.out.println("Current length = " + list.getLen());
		list.insertAfter(3, "donut");
		System.out.println("Current length = " + list.getLen());
		list.display();
		
		 list.removeTop();
			System.out.println("Current length = " + list.getLen());
		 list.delAt(4);
			System.out.println("Current length = " + list.getLen());
		 list.delAt(2);
			System.out.println("Current length = " + list.getLen());
		 list.delAt(0);
			System.out.println("Current length = " + list.getLen());
		 list.removeTop();
			System.out.println("Current length = " + list.getLen());
		 list.removeTop();
			System.out.println("Current length = " + list.getLen());
		
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

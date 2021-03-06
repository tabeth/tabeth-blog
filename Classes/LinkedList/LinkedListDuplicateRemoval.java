import java.util.*;

// LinkedListDuplicateRemoval.java
public class LinkedListDuplicateRemoval {
    public static void main(String[] args){
	LinkedListNode test = new LinkedListNode(0);
	test.add(0);
	test.add(1);
	test.add(2);
	test.print();
	
	/* test  = {0 - > 0 - > 1 -> 2 - > null}
	   test' = {0 -> 1 -> 2 -> null}
	   */

	removeDuplicates(test);
	removeDuplicatesAlt(test);
    }

    public static void removeDuplicates(LinkedListNode node){
	HashMap<Integer, Boolean> seen = new HashMap<Integer, Boolean>();
	LinkedListNode start = node;
	LinkedListNode print = node;

	while (start.next != null){
	    if(!seen.containsKey(start.data)){
		seen.put(start.data, true);
	    }

	    else {
		start.delete();
	    }

	    start = start.next;
	}

	print.print();
    }

    public static void removeDuplicatesAlt (LinkedListNode node){
	LinkedListNode equalToThis = node;

	while (equalToThis.next != null){
	    LinkedListNode currentNode = equalToThis.next;

	    while (currentNode.next != null){
		if (currentNode.data == equalToThis.data)
		    currentNode.delete();

		currentNode = currentNode.next;
	    }

	    equalToThis = equalToThis.next;
	    node.print();
	}
    }
}

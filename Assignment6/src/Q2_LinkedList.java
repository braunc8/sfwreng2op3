/* Assignment 6 (100 marks in total; 5% of the final score of this course)
 *
 * Question 2 (40 marks)
    Use java to implement a data structure named LinkedList, and implement several methods of the LinkedList.

 */

class Node {
    int data; // 'data' stores the value of a node.
    Node next; // 'next' refers/points to the next node

    // the construction method of class Node.
    Node(int d) {
        data = d;
        next = null;
    }
}

class Q2_LinkedList {
    Node head;

    // Insert 'new_data' at the beginning of the LinkedList
    // (5 marks)
    public void insertAtBeginning(int new_data) {
        Node newData=new Node(new_data);
        newData.next=head;
        head=newData;
    }

    // Insert 'new_data' at the end of the LinkedList
    // (5 marks)
    public void insertAtEnd(int new_data) {
        if(head==null){
            head=new Node(new_data);
            return;
        }

        Node end=head;//this creates a reference copy of head
        while (end.next!=null){//checks if next Node is the empty nod
            end=end.next;//if not it moves onto the next
        }
        end.next=new Node(new_data);//in the null Node, it inserts the Node with the new data
    }

    // Insert 'new_data' after a node referred to as 'prev_node'
    // (10 marks)
    public void insertAfter(Node prev_node, int new_data) {
        if (prev_node==head){
            head.data=new_data;
            return;
        }

        Node pos=head;//this creates a reference copy of head
        while (pos.next!=prev_node){//checks if next Node is desired node
            pos=pos.next;
        }
        pos.next.data=new_data;
    }

    // Delete a node located in 'position' of the Linked List. The first element of the LinkedList has a position=0.
    // (10 marks)
    void deleteNode(int position) {
        if(position==0){//when the desired deletion is at 0
            head=head.next;
            return;
        }

        //when the desired deletion is not at 0
        int currentPos=0;
        Node pos=head;
        //finds the position of the node to be deleted
        while (currentPos<(position-1)){
            pos=pos.next;
            currentPos++;//the node at position is at pos.next!
        }
        pos.next=pos.next.next;
    }

    // Search for a node containing the value of 'key' in the LinkedList.
    // If there is a node in the LinkedList whose value is equal to 'key', then return 'true'.
    // If there is no node in the LinkedList whose value is equal to 'key', then return 'false'.
    // (15 marks)
    boolean search(Node head, int key) {
        if(head.data==key){//when the desired deletion is at 0
            return true;
        }

        Node search=head;
        while (search.data!=key && search.next!=null){
            if (search.next.data==key){
                return true;
            }
            search=search.next;
        }
        return false;
    }

    // Sort the nodes in the LinkedList in ascending orders of their values.
    // Requirement: please use bubble sort.
    // Example: for a LinkedList: head->3->5->1->4->2, the sorted LinkedList should be head->1->2->3->4->5.
    // (15 marks)
    void sortLinkedList(Node head) {/* place your code here */
        Node it=head;
        while(it.next!=null){//this iterates through each item in the list
            int min=it.data;//establishes the minimum as the first item in the list
            Node ref=it;//establishes the rest of the list we will iterate through
            Node posAt=ref;//establishes the position of the minimum

            //iterates through the rest of the list, when it finds a smaller minimum it replaces the minimum and the position of it
            while(ref.next!=null){
                if (ref.data>ref.next.data){
                    min=ref.next.data;
                    posAt=ref.next;
                }
                ref=ref.next;
            }

            //swaps the variable we have been comparing and the minimum variable
            insertAfter(posAt,it.data);
            it.data=min;
            it=it.next;
        }
    }

    // Print the linked list
    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }

    public static void main(String[] args) {
        /* TA may test different functions of the LinkedList here */
        /* The following is just an example of how to do the test. */

        Q2_LinkedList llist = new Q2_LinkedList();

        llist.insertAtEnd(1);
        llist.insertAtBeginning(2);
        llist.insertAtBeginning(3);
        llist.insertAtEnd(4);
        llist.insertAfter(llist.head.next, 5);

        System.out.println("Linked list: ");
        llist.printList();

        System.out.println("\nAfter deleting an element: ");
        llist.deleteNode(3);
        llist.printList();

        System.out.println();
        int item_to_find = 3;
        if (llist.search(llist.head, item_to_find))
            System.out.println(item_to_find + " is found");
        else
            System.out.println(item_to_find + " is not found");

        llist.sortLinkedList(llist.head);
        System.out.println("\nSorted List: ");
        llist.printList();
    }
}
package implmentation;

import myinterface.SinglyLinkedListADT;

public class MySinglyLinkedList implements SinglyLinkedListADT {
    //head or Start of linked list, this will refer to first element
    // of linked list
    private Node head;
    //tail or end  of linked list, this will refer to last element
    // of linked list
    private Node tail;
    //total number of elements in linked list
    private int size;
    //constructor
    public MySinglyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    //method to check if linked list is empty
    public boolean isEmpty(){
        return head == null;
    }

    @Override
    //to get the number of element in linked list
    public int size(){
        return size;
    }

    @Override
    //adding element at head or
    //adding a new node at head
    //insertAtBeginning
    public void addFirst(int element){
        //create a node
        Node node = new Node(element);
        //checking if linked list is empty
        // if linked list is empty, we have to update head and tail both references
        if(isEmpty()){
            head = node;
            tail = node;
            size++;
        }
        //updating only head reference
        else{
            node.setNext(head);
            head = node;
            size++;
        }
    }
    //adding last element
    //adding at end
    //insertAtTail
    @Override
    public void addLast(int element){
        Node node = new Node(element);
        //special case
        // if linked list is empty, we have to update both head and tail references
        if(isEmpty()){
            head = node;
            tail = node;
            //addFirst(element) method can be called
            size++;
        }
        //updating only tail reference
        else{
            tail.setNext(node);
            tail = node;
            size++;
        }
    }
    @Override
    //traversing the linked list
    public void traverse(){
        //storing head reference in temp, if head reference is updated then linked list will be lost
        Node temp = head;
        //iterating till we find null in temp reference
        while(temp != null){
            //printing the element stored at current node that is referred by temp
            System.out.print(temp.getData() + "-->");
            //updating temp to refer to next node
            temp = temp.getNext();
        }
        System.out.println("null");
    }
    @Override
    //removing the firstNode from the list
    //deleteFromBeginning
    //deleteFromHead
    public int removeFirst(){
        //special case. when list is empty
        if(isEmpty()){
            return -1;//using -1 for, considering as invalid data
        }
        //deleting from head
         else{
              Node response = head;
            //special case, when only a single node,
            //have to update head and tail both
             if(head == tail){
                   
                    head = null;
                    tail = null;

             }
             //if more than one nodes in list , then update head only
             else{
                
                 head = head.getNext();
             }
            size--;
            return response.getData();
         }
        
    }
    @Override
    /* * deleting last node of the linked list,
    * for this purpose we have to traverse the complete linked list,
    * there will be a special case if only single node in linked list
    */
    public int removeLast(){
        //checking if list is empty
        if(isEmpty()){
            return -1;
        }
        //otherwise traverse the list,
        // by using two references temp and previous. temp will reach to last node
        // and previous will reach to second last node.
        // we will use previous to delete last node
        else{
            //declaring two references, temp will refer to head, and previous will refer to null
            Node temp = head;
            Node previous = null;
            //traversing the list to reach last and second last node
            while(temp.getNext() != null ){
                previous = temp;
                temp = temp.getNext();
            }
            //special case if there only a single node, then previous will refer to null
            // we will update both head and tail
            if(previous == null){
                head = null;
                tail = null;
                size--;
                
            }
            // otherwise will update the next reference of second last node which is referred byr previous
            // and update the tail
            else{
                previous.setNext(null);
                tail = previous;
                size--;
            }
            //as temp contains last node we will return data of that node
            return temp.getData();
        }
            
    }

    @Override
    public int first() {
      if(isEmpty()){
          return -1; //considering -1 as invalid
      }
      else{
          return head.getData();
      }
    }

    @Override
    public int last() {
        if(isEmpty()){
            return -1;//considering -1 as invalid
        }
        else{
            return tail.getData();
        }
    }

    @Override
    public int lastWithoutTail() {
        if(!isEmpty()){
            Node temp = head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            return temp.getData();
        }
        return -1;
    }

    @Override
    public boolean addAfterGivenElement(int element, int givenElement) {
        boolean response = false;
        if(!isEmpty()){
            Node temp = head;
            while(temp != null){
                if(temp.getData() == givenElement){
                   break;
                }
                temp = temp.getNext();
            }
            if(temp != null) {
                Node node = new Node(element);
                node.setNext(temp.getNext());
                temp.setNext(node);
                response = true;
                size++;
                if(temp == tail){
                    tail = node;
                }
            }
        }

        return response;
    }

    @Override
    public boolean addBeforeGivenElement(int element, int givenElement) {
        return false;
    }
    //
    //printing in reverse using recursion
    public void traverseRecursion(Node node){
        if(node == null){
            return;
        }
        else{
            traverseRecursion(node.getNext());
            System.out.print(node.getData() + ",");
        }
    }

    public Node getHead() {
        return head;
    }
    //reversing singly linked list
    public void reversingByRecursion(Node node, Node previous){
        if(node.getNext() == null){
            tail = head;
            head = node;
            node.setNext(previous);
        }
        else{
            reversingByRecursion(node.getNext(), node);
            node.setNext(previous);
        }
    }
}

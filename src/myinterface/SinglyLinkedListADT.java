package myinterface;

public interface SinglyLinkedListADT {
    void addFirst(int element);//O(1)
    boolean isEmpty();//O(1)
    int size();//O(1)
    void addLast(int element);//O(1)
    void traverse();//O(N)
    //deleteFromBeginning
    //deleteFromHead
    int removeFirst();//O(1)
    //deleteFromEnd
    int removeLast(); // O(N)
    //will bring the first element, that is the data of first node
    int first();//O(1)
    //will bring the last element, that is the data of last node
    int last();//O(1)
    //will bring the without using tail reference last element, that is the data of last node
    int lastWithoutTail();
    //this method will add element after given element if givenElement
    //is present
    boolean addAfterGivenElement(int element, int givenElement);
    //this method will add element before given element if givenElement
    //is present
    boolean addBeforeGivenElement(int element, int givenElement);
}

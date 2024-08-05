
// Creating a Node
class Node{
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
    }
}

class SingleLinkedList{
    Node head = null;

    // Inserting an Element at the Beginning of List
    public void insertAtBeginning(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

    }

    // Insert At End
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;

    }

    // Insert At Position
    public void insertAtPosition(int position, int data) {
        Node newNode = new Node(data);
        if(position == 0) {
            newNode.next = head;
            head = newNode;
        }
        Node current = head;
        int index = 0;
        while (current != null && index < position - 1) {
            current = current.next;
            index++;
        }
        if(current == null) {
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Delete At Beginning
    public void deleteAtBeginning() {
        if(head == null) {
            return;
        }
        head.next = head;
    }

    // Delete At end
    public void deleteAtEnd() {
        if(head == null || head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        Node prev = null;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        prev.next = null;
    }

    // Delete At Specific Position
    public void deleteAtSpecificPosition(int position) {
        if(head == null) {
            return;
        }
        if(position == 0) {
            head = head.next;
            return;
        }
        Node current = head;
        Node prev = null;
        int index = 0;
        while (current != null &&  index < position) {
            prev = current;
            current = current.next;
            index ++;

        }
        if(current == null) {
            return;
        }
        prev.next = current.next;
    }



    //Traversal
    public void traversal() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
    }

    // Searching
    public boolean search(int val) {
        Node current = head;
        while (current != null) {
            if (current.data == val) {
                return true;
            }
            current = current.next;
        }
        return false;

    }




}


public class Main {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.insertAtBeginning(1);
        list.insertAtEnd(3);
        list.insertAtPosition(2, 1);
        list.traversal(); // Output: 1 2 3
        list.deleteAtBeginning();
        list.deleteAtEnd();
        list.deleteAtSpecificPosition(0);
        list.traversal(); // Output: empty (if no elements are left)
        System.out.println(list.search(2)); // Output: false

    }


}


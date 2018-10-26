public class LinkedList implements List {
    // Instance Variables
    private int size;
    private LLNode root;

    // Constructor
    public LinkedList() {
        this.size = 0;
        this.root = new LLNode(null);
    }

    // Node Class
    private class LLNode {
        // Instance Variables
        Object data;
        LLNode next;
        // Constructor
        LLNode(Object data) {
            this.data = data;
            this.next = null;
        }


    }

    // Public Instance Methods
    public void add(Object obj) {
        if (this.size == 0) {       // IF there's nothing in the list yet
            this.root.data = obj;
            this.size++;
            return;
        } else {                    // IF there's something, move it out of the way
            LLNode oldRoot = this.root;
            this.root = new LLNode(obj);
            this.root.next = oldRoot;
            this.size++;
            return;
        }
    }

    public void add(int index, Object obj) {
        if (index > this.size) {       // Make sure the index is valid
            throw new IndexOutOfBoundsException("Index past the end of the LinkedList");
        } else if (index == 0) {  // Handle the case when index = 0
            LLNode newNode = new LLNode(obj);
            newNode.next = this.root;
            this.root = newNode;
        } else {
            int i = 0;
            LLNode currentNode = this.root;
            for (i = 1; i < index; i++) {
                // Go to the ith node
                currentNode = currentNode.next;     // Keep track of the last node so we can add there.
            }

            size ++;
            LLNode newNode = new LLNode(obj);
            newNode.next = currentNode.next;
            currentNode.next = newNode;

            return;
        }
    }

    public Object get(int index) {
        if (index >= this.size) {       // Make sure the index is valid
            throw new IndexOutOfBoundsException("Index past the end of the LinkedList");
        } else {
            int i = 0;
            LLNode currentNode = this.root;
            for (i = 1; i <= index; i++) {
                // Go to the ith node
                currentNode = currentNode.next;
            }
            return currentNode.data;
        }
    }

    public Object remove(int index) {
        if (index >= this.size) {       // Make sure the index is valid
            throw new IndexOutOfBoundsException("Index past the end of the LinkedList");
        } else {
            int i = 0;
            LLNode currentNode = this.root;
            LLNode lastNode = new LLNode(null);     // It got mad at me when i didn't initialize it, so i'm giving it a dummy node
            for (i = 1; i <= index; i++) {
                // Go to the ith node
                lastNode = currentNode;
                currentNode = currentNode.next;     // Keep track of the last node so we can remove the given node.
            }
            lastNode.next = currentNode.next;       // Remove the node from the linkedlist
            this.size--;
            return currentNode.data;
        }
    }

    public int size() {
        return this.size;
    }

    private void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.print("index " + i + ": ");
            System.out.println(this.get(i).toString());
        }
        System.out.println();
    }


    // Main method for testing:
    public static void main(String[] args) {
        LinkedList friend = new LinkedList();
        friend.add("a");
        friend.print();
        friend.add("b");
        friend.print();
        friend.add("c");
        friend.print();
        friend.add("d");

        friend.print();

//        System.out.println(friend.get(2));
//        System.out.println(friend.remove(2));
//        System.out.println(friend.get(2));

    }

}

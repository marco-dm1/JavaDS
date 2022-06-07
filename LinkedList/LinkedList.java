/*
    Marco Diaz Moore © June 2022
    Linked List implementation
*/

public class LinkedList {
    Node headNode;
    Node tailNode;

    public LinkedList(){
        this.tailNode = new Node(1, null);
        this.headNode = new Node(0, this.tailNode);
    }

    private Node findNode(Node currentNode, Node targetNode){
        if(currentNode == targetNode || currentNode == null) {
            return currentNode;
        }else{
            return findNode(currentNode.next, targetNode);
        }
    }

    private int findNodeIndex(Node currentNode, Node targetNode, int currentCount){
        // Return -1 if we are searching for a non-null node and the current node is null.
        if(targetNode != null && currentNode == null) return -1;

        if(currentNode == targetNode){
            return currentCount;
        }
        return findNodeIndex(currentNode.next, targetNode, ++currentCount);
    }

    public int getSize(){
        return findNodeIndex(this.headNode, null, 0);
    }

    public int indexOf(Node targetNode){
        return findNodeIndex(this.headNode, targetNode, 0);
    }

    private Node getSecondLastNode(Node currentNode){
        if(currentNode.next == null){
            return currentNode;
        }

        return getSecondLastNode(currentNode.next);
    }

    public void addFirst(Node newHead){
        newHead.next = this.headNode;
        this.headNode = newHead;
    }

    public void addLast(Node newTail){
        this.tailNode.next = newTail;
        this.tailNode = newTail;
        this.tailNode.next = null; // Ensure there are no attached nodes
    }

    public void removeFirst(){
        if(getSize() <= 2) return;

        this.headNode = this.headNode.next;
    }

    public void removeLast(){
        if(getSize() <= 2) return;

        this.tailNode = getSecondLastNode(this.headNode);
    }

    public boolean contains(Node targetNode){
        if(findNode(this.headNode, targetNode) != null){
            return true;
        }
        return false;
    }
}

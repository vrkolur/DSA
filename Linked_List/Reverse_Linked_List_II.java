package Linked_List;

public class Reverse_Linked_List_II {
    class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    node head;

    public void addfirst(int data) {
        node newnode = new node(data);

        if (head == null) {
            head = newnode;
            return;
        }
        newnode.next = head;
        head = newnode;
    }

    public void addlast(int data) {
        node newnode = new node(data);

        if (head == null) {
            addfirst(data);
            return;
        }
        node p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = newnode;
    }

    public void display(node head) {
        node p = head;
        while (p != null) {
            System.out.print(p.data + "->");
            p = p.next;
        }
        System.out.println("null");
        // System.out.println();
    }

    public void reverselist(node head, int l, int r) {
        if (head == null)
            return;

        node prev = null;
        node currNode = head;

        while (l > 1) {
            prev = currNode;
            currNode = currNode.next;
            l--;
            r--;
        }

        node connection = prev;
        node tail = currNode;

        while (r > 0) {
            node nextNode = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = nextNode;
            r--;
        }

        if (connection != null) {
            connection.next = prev;
        } else {
            head = prev;
        }
        tail.next = currNode;
        display(head);
    }

    public static void main(String[] args) {
        Reverse_Linked_List_II list = new Reverse_Linked_List_II();
        list.addlast(1);
        list.addlast(2);
        list.addlast(3);
        list.addlast(4);
        list.addlast(5);
        list.addlast(6);
        list.addlast(7);
        list.reverselist(list.head, 2, 5);
    }
}

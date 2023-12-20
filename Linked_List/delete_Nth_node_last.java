package Linked_List;

public class delete_Nth_node_last {
    
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

    public void display() {
        node p = head;
        while (p != null) {
            System.out.print(p.data + "->");
            p = p.next;
        }
        System.out.println("null");
        // System.out.println();
    }

    public int  count() {
        int count = 0;
        node p = head;
        while (p != null) {
            p = p.next;
            count += 1;
        }
        return count;
    } 

    public void delete(int key) {
        int size = count();
        int pos = size - key%size;
        node p = head, q = null;
        for (int i = 0; i < pos; i++) {
            q = p;
            p = p.next;
        }
        q.next = p.next;
        p.next = null;
    }

    public static void main(String[] args) {
        delete_Nth_node_last list = new delete_Nth_node_last();
        // list.addlast(0);
        list.addlast(1);
        list.addlast(2);
        list.addlast(3);
        list.addlast(4);
        list.addlast(5);
        list.delete(98);
        list.display();
    }
}

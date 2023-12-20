package Linked_List;

public class Rotate_List {
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

    public void rotateList(int k) {

        if (k == 0)
            return;
        node cur = head;
        int count = 0;
        while (cur.next != null) {
            count++;
            cur = cur.next;
        }
        count++;
        // System.out.println(count);

        int x = count - k - 1;

        node last = cur;
        cur = head;
        for (int i = 0; i < x; i++) {
            cur = cur.next;
        }
        // System.out.println(cur.data);
        // System.out.println(last.data);
        last.next = head;
        head = cur.next;
        cur.next = null;
    }

    public static void main(String[] args) {
        
        Rotate_List list = new Rotate_List();
        list.addlast(0);
        list.addlast(1);
        list.addlast(2);
        list.addlast(3);
        list.addlast(4);
        list.addlast(5);
        list.rotateList(2);
        list.display();
    }
}

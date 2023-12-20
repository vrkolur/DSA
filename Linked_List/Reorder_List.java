package Linked_List;

public class Reorder_List {

    // Linkedin Question.

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
        System.out.print("null");
    }

    public node findMiddle() {
        node p = head, q = head;
        while (p.next != null && p.next.next != null) {
            p = p.next.next;
            q = q.next;
        }
        return q;
    }

    private node reverse(node head) {
        node p = head, q = null, r = null;

        while (p != null) {
            r = q;
            q = p;
            p = p.next;
            q.next = r;
        }
        return q;
    }

    public void reorderList() {
        node p = head;
        if (p == null || p.next == null)
            return;
        node middle = findMiddle();
        node second = reverse(middle.next);
        node first = head;
        node q = null, r = null;

        while (second != null) {
            q = first.next;
            r = second.next;
            first.next = second;
            second.next = q;
            first = q;
            second = r;
        }
        q.next = null;
    }

    public static void main(String[] args) {
        Reorder_List list = new Reorder_List();
        list.addfirst(0);
        list.addlast(1);
        list.addlast(2);
        list.addlast(3);
        list.addlast(4);
        list.addlast(5);
        list.reorderList();
        list.display();
    }
}

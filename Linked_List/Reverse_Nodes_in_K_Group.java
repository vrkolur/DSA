package Linked_List;

public class Reverse_Nodes_in_K_Group {
    
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

    public void reversenodes(int k)
    {
        node p = head;
        if (p == null)
            return;
        node dummy = new node(0);
        dummy.next = head;
        node cur = dummy, nex = dummy, pre = dummy;
        int count = 0;
        while (p != null) {
            p = p.next;
            count++;
        }

        while (count >= k) {
            cur = pre.next;
            nex = cur.next;
            for (int i = 1; i < k; i++) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;
            count -= k;
        }
        display(dummy.next);
    }
    
    public static void main(String[] args) {
        Reverse_Nodes_in_K_Group list = new Reverse_Nodes_in_K_Group();
        list.addlast(0);
        list.addlast(1);
        list.addlast(2);
        list.addlast(3);
        list.addlast(4);
        list.addlast(5);
        // list.display();
        list.reversenodes(2);
    }
}
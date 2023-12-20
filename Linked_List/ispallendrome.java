package Linked_List;

public class ispallendrome {
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

    // private node reverse(node head) {
    //     node p = head;
    //     node q = null;

    //     while (p != null) {
    //         node r = p.next;
    //         p.next = q;
    //         q = p;
    //         p = r;
    //     }
    //     return q;
    // }

    private node reverse1(node head) {
        node p = head, q = null, r = null;

        while (p != null) {
            r = q;
            q = p;
            p = p.next;
            q.next = r;
        }
        return q;
    }

    private node findmiddle() {
        node p = head, q = head;

        while (p.next != null && p.next.next != null) {
            p = p.next.next;
            q = q.next;
        }
        return q;
    }

    private boolean palendrome() {
        if (head == null || head.next == null) {
            return true;
        }

        node middle = findmiddle();
        // node secondhalfstart = reverse(middle.next);
        node secondhalfstart = reverse1(middle.next);
        node firsthalfstart = head;

        while (secondhalfstart != null) {
            if (firsthalfstart.data != secondhalfstart.data) {
                return false;
            }
            firsthalfstart = firsthalfstart.next;
            secondhalfstart = secondhalfstart.next;
        }
        return true;
    }


    public static void main(String[] args) {
        ispallendrome listNode = new ispallendrome();
        listNode.addfirst(0);
        listNode.addlast(1);
        listNode.addlast(2);
        listNode.addlast(3);
        listNode.addlast(3);
        listNode.addlast(2);
        listNode.addlast(1);
        listNode.addlast(0);
        listNode.display();
        System.out.println(listNode.palendrome());
    }
}

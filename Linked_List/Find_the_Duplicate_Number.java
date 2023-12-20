package Linked_List;

public class Find_the_Duplicate_Number {
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
        while (p.next!=null) {
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

    public int findDuplicate() {
        int sum = 0, count = 0, tsum = 0;
        node cur = head;
        while (cur != null) {
            tsum += cur.data;
            count++;
            cur = cur.next;
        }

        count--;
        sum = (count * (count + 1)) / 2;
        return tsum - sum;
    }

    public static void main(String[] args) {
        Find_the_Duplicate_Number list = new Find_the_Duplicate_Number();
        list.addlast(1);
        list.addlast(2);
        list.addlast(2);
        list.addlast(3);
        list.addlast(4);
        int duplicate = list.findDuplicate();
        System.out.println(duplicate);
    }
}

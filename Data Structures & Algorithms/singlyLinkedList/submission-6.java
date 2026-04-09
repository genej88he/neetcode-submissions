class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;

    }
}

class LinkedList {
    private ListNode head;

    public LinkedList() {
        this.head = null;
    }

    public int get(int index) {
        ListNode curr = head;
        int i = 0;
        while (curr != null) {
            if (i == index) {
                return curr.data;
            }
            curr = curr.next;
            i++;
        }
        return -1;

    }

    public void insertHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
    }

    public void insertTail(int val) {
        if (head == null) {
            head = new ListNode(val);
        } else { 
            ListNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new ListNode(val);
        }
    }

    public boolean remove(int index) {
        if (head == null) {
            return false;
        }
        ListNode curr = head;
        int i = 0;
        if (i == index) {
            head = curr.next;
            return true;
        }
        while (curr != null && curr.next != null) {
            if (i == index - 1) {
                curr.next = curr.next.next;
                return true;
            }
            curr = curr.next;
            i++;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> array = new ArrayList<Integer>();
        ListNode curr = head;
        while (curr != null) {
            array.add(curr.data);
            curr = curr.next;
        }
        return array;
    }
}

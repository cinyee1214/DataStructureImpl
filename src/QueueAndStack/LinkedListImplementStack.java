package QueueAndStack;

public class LinkedListImplementStack {
    ListNode head;
    int size;

    //optional
    public LinkedListImplementStack() {
        head = null;
        size = 0;
    }

    public Integer pop() {
        if (head == null) {
            return null;
        }

        ListNode prev = head;
        head = head.next;
        prev.next = null; // optional
        size--;
        return prev.val;
    }

    public void push(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
        size++;
    }

    //return special value
    public Integer top() {
        return head == null ? null : head.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}

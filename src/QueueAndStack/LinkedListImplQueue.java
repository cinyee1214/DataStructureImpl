package QueueAndStack;

public class LinkedListImplQueue {
    ListNode head, tail;
    int size;

    public LinkedListImplQueue() {
        head = tail = null;
        size = 0;
    }

    //insert on tail
    public void offer(int val) {
        if (head == null) {
            tail = head = new ListNode(val);
            return;
        }
        tail.next = new ListNode(val);
        tail = tail.next;
        size++;

    }

    //delete on head
    public Integer poll() {
        if (head == null) {
            return null;
        }

        ListNode prev = head;
        head = head.next;
        prev.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return prev.val;
    }

    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.val;
    }
    public int size() {
        return size();
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

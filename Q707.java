/**
 * Test cases:
 * 1: Input & Output:
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
 * linkedList.get(1);            // returns 2
 * linkedList.deleteAtIndex(1);  // now the linked list is 1->3
 * linkedList.get(1);            // returns 3
 *
 */


class MyLinkedList {

  class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
      this.next = null;
    }
  }

  private ListNode head;
  private int size;

  /** Initialize your data structure here. */
  public MyLinkedList() {
    this.head = null;
    this.size = 0;
  }

  /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
  public int get(int index) {
    if(index<0 || index>=size) {
      return -1;
    }

    //0=<index<size
    int count = 0;
    ListNode pointer = this.head;
    while(count<index) {
      pointer = pointer.next;
      count++;
    }
    return pointer.val;
  }

  /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
  public void addAtHead(int val) {
    ListNode node = new ListNode(val);
    node.next = this.head;
    this.head = node;
    this.size++;
  }

  /** Append a node of value val to the last element of the linked list. */
  public void addAtTail(int val) {
    ListNode node = new ListNode(val);
    if(this.head==null) {
      this.head = node;
      this.size++;
      return;
    }

    //this.head!=null
    ListNode pointer = this.head;
    while(pointer.next!=null) {
      pointer = pointer.next;
    }
    pointer.next = node;
    this.size++;
  }

  /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
  public void addAtIndex(int index, int val) {
    if(index>this.size) {
      return;
    }
    if(index==this.size) {
      this.addAtTail(val);
      return;
    }

    //index<this.size
    if(index<=0) {
      this.addAtHead(val);
      return;
    }

    //0<index<this.size
    ListNode node = new ListNode(val);
    int count = 0;
    ListNode pointer = this.head;
    while(count<index-1) {
      pointer = pointer.next;
      count++;
    }
    node.next = pointer.next;
    pointer.next = node;
    this.size++;
  }

  /** Delete the index-th node in the linked list, if the index is valid. */
  public void deleteAtIndex(int index) {
    if(index<0||index>=this.size) {
      return;
    }

    if(index==0) {
      this.head = this.head.next;
      this.size--;
      return;
    }

    //0<index<this.size
    int count = 0;
    ListNode pointer = this.head;
    while(count<index-1) {
      pointer = pointer.next;
      count++;
    }
    pointer.next = pointer.next.next;
    this.size--;
  }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
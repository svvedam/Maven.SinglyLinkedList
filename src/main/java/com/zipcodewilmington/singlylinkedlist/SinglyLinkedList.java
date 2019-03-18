package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {
    Node head;

    public void insert(Integer data){

        Node node = new Node();//create new node
        node.data = data;
        node.next = null;
        if(head==null) // if list is null
        {
            head=node;
        }
        else // if list is not null add to the end of the list
        {
            Node n = head;//n is temp node to traverse
            while(n.next!=null)
            {
                n=n.next;
            }
            n.next = node;

        }
    }

    //add -- add an element to the list
    public void insertAtStart(Integer data){
        Node node = new Node();//create new node
        node.data = data;
        node.next = null;
        node.next = head;//first assign the head node to the new node's next pointer

        head = node;
    }
    //add -- add an element to the list at a specific index
    public void insertAt(Integer index, Integer data){
        Node node = new Node();//create new node
        node.data = data;
        node.next = null;

        if(index==0){
            insertAtStart(data);
        }
        else{
            Node n = head;//traverse with node n

            for(int i=0;i<index-1;i++){//next goes to next node so use index-1
                n= n.next;
            }
            node.next = n.next;
            n.next=node;
        }
    }
    //remove -- remove an element (specified by numeric index) from the list
    public void deleteAt(Integer index){
        if(index==0){
            head= head.next;
        }
        else
        {
            Node n = head;//traverse with node n
            Node n1 = null; // used to point to the node to be deleted
            for(int i=0;i<index-1;i++)
            {//next goes to next node so use index-1
                n= n.next;
            }
            n1 = n.next;
            n.next = n1.next;
            System.out.println("n1 "+n1.data);
            n1=null;
        }

    }

    //size -- returns the current size of the list
    public Integer size(){
        Integer count =1;
        if(head==null) // if list is null
            return 0;
        else // if list is not null traverse to the end of the list and get the size
        {
            Node n = head;//n is temp node to traverse
            while(n.next!=null)
            {
                n=n.next;
                count++;
            }
        }
        return count;
    }
    //contains -- returns true if the element is in the list, false otherwise
    public Boolean contains(Integer data){
        Boolean returnValue = false;
        if(head==null) // if list is null
            returnValue = false;
        else{
                Node n = head;//n is temp node to traverse
                while(n.next!=null)
                {
                     if(n.data==data)
                     {
                        returnValue = true;
                        break;
                     }
                    n=n.next;
                }
            }
        return returnValue;
    }
    //find -- returns the element's index if it is in the list, -1 otherwise
    public Integer find(Integer data){
        Integer returnValue=0;
        Integer size = size();
        Node n = head;//traverse with node n
        for(int i=0;i<size;i++)
        {
                if(n.data!=data)
                    n= n.next;
                else if(n.data==data)
                {
                    returnValue= i;
                }
        }
        return returnValue;
    }
    //copy -- returns a new linked list containing the same values (look up deep versus shallow copy)
    public Node copyList(Node head)
    {
        Node current = head;	// used to iterate over original list
        Node newList = null; // head of the new list
        Node tail = null;	// point to last node in new list

        while (current != null)
        {
            // special case for the first new node
            if (newList == null)
            {
                newList = new Node();
                newList.data = current.data;
                newList.next= null;
                tail = newList;
            }
            else
            {
                tail.next = new Node();
                tail = tail.next;
                tail.data = current.data;
                tail.next = null;
            }
            current = current.next;
        }

        return newList;
    }


    //sort -- sorts the list using your algorithm of choice. You must perform the sorting yourself (no fair using someone else's library)
    public Node sortedMerge(Node a, Node b)
    {
        Node result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if ((Integer)a.data <= (Integer)b.data)
        {
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else
        {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;

    }
    public Node mergeSort(Node head)
    {
        // Base case : if head is null
        if (head == null || head.next == null)
        {
            return head;
        }

        // get the middle of the list
        Node middle = getMiddle(head);
        Node nextofmiddle = middle.next;

        // set the next of middle node to null
        middle.next = null;

        // Apply mergeSort on left list
        Node left = mergeSort(head);

        // Apply mergeSort on right list
        Node right = mergeSort(nextofmiddle);

        // Merge the left and right lists
        Node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }
    // Utility function to get the middle of the linked list
    public Node getMiddle(Node head)
    {
        //Base case
        if (head == null)
            return head;
        Node fastptr = head.next;
        Node slowptr = head;

        // Move fastptr by two and slow ptr by one
        // Finally slowptr will point to middle node
        while (fastptr != null)
        {
            fastptr = fastptr.next;
            if(fastptr!=null)
            {
                slowptr = slowptr.next;
                fastptr=fastptr.next;
            }
        }
        return slowptr;
    }
    //get -- returns the element at the specified index
    public void show(){
        Node node = head;
        while(node.next!=null){
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println(node.data);//for last element you have to print manually since while stops once the null value is reached

    }
    //get -- returns the element at the specified index
    public Integer get(Integer index) {
        Integer size = size();
        if(index <0 || index>=size)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            Node n = head;//traverse with node n
            Node n1 = null; // used to point to the node to be deleted
            for(int i=0;i<index;i++)
            {//next goes to next node so use index-1
                n= n.next;
            }
            return (Integer)n.data;
        }
    }
}

package problem5.circularqueue;
//to implement circular queue

import problem5.node.Node;
import problem5.student.Student;

public class MyCircularQueue {
    // a field to refer rear end of queue
    private Node rear;
    // a field to refer front end of queue
    private Node front;
    private int size;// total number of elements in the queue

    // constructor
    public MyCircularQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean processStudents() {
        Node node = front;
        Student stu = node.getStudent();
        if (stu.getAppearingCount() > stu.getBackLogCounter()) {
            stu.setAppearingCount(stu.getBackLogCounter());
        }
        stu.setBackLogCounter(stu.getBackLogCounter() - stu.getAppearingCount());
        if (stu.getBackLogCounter() <= 0) {
            dequeue();
            System.out.println(stu + "'s Backlogs Cleared (" + stu.getAppearingCount() + " Appearances)!!!");
            if (size == 0) return false;
        } else {
            System.out.println(stu + " Processed - Remaining Backlogs (" + stu.getAppearingCount() + " Appearances) = " + stu.getBackLogCounter());
        }
        return true;
    }

    // a method to check whether queue is empty
    public boolean isEmpty() {
        boolean response = false;
        if (size == 0) {
            response = true;
        }
        return response;
    }

    // a method to add a new element in queue
    public void enqueue(Student element) {
        Node node = new Node(element);
        if (isEmpty()) {
            rear = node;
            front = node;
            rear.setNext(front);
            size++;
        } else {
            rear.setNext(node);
            rear = node;
            node.setNext(front);
            size++;
        }
    }

    public Node dequeue() {
        Node res = null;
        if (!isEmpty()) {
            if (front.getNext() != front) {
                res = front;
                front = front.getNext();
                rear.setNext(front);
                res.setNext(null);
                size--;
            } else {
                res = front;
                //res.getNext(null);//redundant
                front = null;
                rear = null;
                size--;
            }
        } else {
            System.out.println("Queue UnderFlow");
        }
        return res;

    }

    // a method to get front element without removing it
    public Node peek() {
        Node response = null;
        if (!isEmpty()) {
            response = new Node(front.getStudent());
        }
        return response;
    }


    public void display() {
        System.out.print("Display : ");
        Node temp = front;
        while (temp != rear) {
            System.out.print(temp.getStudent());
            if (temp.getNext() != null) {
                System.out.print("<---");
            }
            temp = temp.getNext();
        }
        if (rear != null)
            System.out.print(rear.getStudent());
        System.out.println();
    }

    // a method to get size of queue
    public int getSize() {
        return size;
    }

    public Node rear() {
        return rear;
    }
}

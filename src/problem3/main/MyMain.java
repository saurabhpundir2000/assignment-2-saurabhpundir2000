  
/*
 *  Created by IntelliJ IDEA.
 *  User: Vaibhav
 *  Date: 23-Mar-20
 *  Time: 7:13 PM
 */
package problem3.main;
// executable class
// use problem5.student.Student class to create object of student

import java.util.*;
public class MyMain {
    public static void main(String[] args) {
        Queue<Integer> integerPriorityQueue = new PriorityQueue<>();
            integerPriorityQueue.add(1);
            integerPriorityQueue.add(6);
            integerPriorityQueue.add(4);
            integerPriorityQueue.add(3);
            integerPriorityQueue.add(5);
            integerPriorityQueue.add(2);
            integerPriorityQueue.add(9);
            integerPriorityQueue.add(7);
            integerPriorityQueue.add(8);
            integerPriorityQueue.add(10);
        for(int i=0;i<10;i++){
            Integer in = integerPriorityQueue.poll();
            System.out.println(" Roll:-"+in);
        }
    }
}

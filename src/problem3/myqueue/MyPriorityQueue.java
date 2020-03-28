/*
 *  Created by IntelliJ IDEA.
 *  User: Vaibhav
 *  Date: 23-Mar-20
 *  Time: 7:15 PM
 */
package problem3.myqueue;

import problem3.node.Node;

import java.util.*;

public class MyPriorityQueue {
        public static Comparator<Node> rollComparator = new Comparator<Node>() {

            @Override
            public int compare(Node r1, Node r2) {
                return (int) (r1.getRoll() - r2.getRoll());
            }
        };
        public static void addDataToQueue(Queue<Node> studentPriorityQueue) {
            for(int i=0; i<10; i++) {
                int roll = i;
                studentPriorityQueue.add(new Node(roll));
            }
        }
        public static void pollDataFromQueue(Queue<Node> studentPriorityQueue) {
            while(true){
                Node stu = studentPriorityQueue.poll();
                if(stu == null) break;
                System.out.println("student roll="+stu.getRoll());
            }
        }

    }

/*
 *  Created by IntelliJ IDEA.
 *  User: Vaibhav
 *  Date: 23-Mar-20
 *  Time: 7:08 PM
 */
package problem4.main;
// executable class
// use problem1.mybst.MyBinarySearchTree class for creating binary tree

import problem4.myqueue.MyQueue;

import static problem4.myqueue.MyQueue.*;

public class MyMain {
    public static void main(String args[])
    {
        MyQueue.Node ROOT = null;
        int a[] = {56,65,89,25,36,14,24,67,27,13,35,61,21,98};
        int n = a.length;
        for(int i = 0 ; i < n; i++)
        {
            System.out.printf("Inserting %2d.....", a[i]);
            ROOT = insert(a[i], ROOT, null);
            System.out.printf("Finished Insertion.\n");
        }
        System.out.printf("\nPre-Order Traversal : ");
        preOrder(ROOT);
        System.out.printf("\n=====================================");
        System.out.printf("\n%-10s%s\n", "Key","Pre-Order Successor");
        System.out.printf("=====================================\n");
        Node successor = null;
        for(int i = 0 ; i < n; ++i)
        {
            successor = preOrderSuccessor(a[i], ROOT);
            if(successor != null)
                System.out.printf("%-10d%d\n", a[i],successor.key);
            else
                System.out.printf("%-10dDo Not Exist.\n", a[i]);
        }
    }
}

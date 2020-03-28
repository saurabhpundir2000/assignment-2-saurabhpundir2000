/*
 *  Created by IntelliJ IDEA.
 *  User: Vaibhav
 *  Date: 23-Mar-20
 *  Time: 7:11 PM
 */
package problem4.myqueue;
// to create queue to store pre - order successor
import java.util.*;
public class MyQueue {
       public static class Node
       {
            public int key;
            Node left;
            Node right;
            Node parent;
        }

        public static Node insert(int key, Node root,Node parent)
        {
            if(root == null)
            {
                Node node = new Node();
                if(node != null)
                {
                    node.key = key;
                    node.left = node.right = null;
                    node.parent = parent;
                    return node;
                }
                else
                    System.out.printf("Could not allocate memory.");
            }
            else if(key == root.key)
                System.out.printf("Duplicates are not" + " allowed in BST.");
            else if(key > root.key)
                root.right = insert(key, root.right, root);
            else
                root.left = insert(key, root.left, root);
            return root;
        }
        static Node search(int key, Node root)
        {
            if(root == null)
                return null;
            else if( key == root.key)
                return root;
            else if(key > root.key)
                return search(key, root.right);
            else
                return search(key, root.left);
        }
        public static Node preOrderSuccessor(int key,Node root)
        {
            Node node = search(key, root);
            if(node == null)
            {
                System.out.printf("%d do not exists" + " in BST.\n", key);
                return null;
            }
            if(node.left != null)
                return node.left;

            else if(node.right != null)
                return node.right;

            else
            {
                Node temp = node.parent;
                while(temp != null)
                {
                    if(key < temp.key && temp.right != null)
                        break;
                    temp = temp.parent;
                }
                return temp != null ? temp.right : null;
            }
        }
        public static void preOrder(Node root)
        {
            if(root != null)
            {
                System.out.printf("%d ", root.key);
                preOrder(root.left);
                preOrder(root.right);
            }
        }
    }

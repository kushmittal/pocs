package kushagra;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TreeImp
{
  private int n; // Size
  private Node top;

  public TreeImp(Node node)
  {
    this.top = node;
  }

  private static class Node
  {
    private int data;
    private Node leftChild;
    private Node rightChild;
  }

  public void insert(Node root, int data)
  {
    if (root == null)
      return;
    if (root.data > data)
    {
      if (root.leftChild != null)
      {
        insert(root.leftChild, data);
      }
      else
      {
        Node node = new Node();
        node.data = data;
        root.leftChild = node;
      }
    }
    else if (root.data < data)
    {
      if (root.rightChild != null)
      {
        insert(root.rightChild, data);
      }
      else
      {
        Node node = new Node();
        node.data = data;
        root.rightChild = node;
      }
    }
    else
    {
      System.out.println("Already exist");
    }
  }

  public boolean delete(Node root, int data)
  {
    boolean success = false;
    if (root == null)
      return false;
    if (root.data > data)
    {
      if (root.leftChild != null)
      {
        Node node = root.leftChild;
        if (node.data == data)
        {
          root.leftChild = null;
          success = true;
        }
        else
        {
          delete(root.leftChild, data);
        }
      }
    }
    else if (root.data < data)
    {
      if (root.rightChild != null)
      {
        Node node = root.rightChild;
        if (node.data == data)
        {
          root.rightChild = null;
          success = true;
        }
        else
        {
          delete(root.rightChild, data);
        }
      }
    }
    else
    {
      root = null;
      success = true;
    }
    return success;
  }

  public void inOrderTraversal(Node root)
  {
    if (root == null)
      return;
    if (root.leftChild != null)
    {
      inOrderTraversal(root.leftChild);
    }
    System.out.println(root.data);
    if (root.rightChild != null)
    {
      inOrderTraversal(root.rightChild);
    }
  }

  public void preOrderTraversal(Node root)
  {
    if (root == null)
      return;
    System.out.println(root.data);
    if (root.leftChild != null)
      preOrderTraversal(root.leftChild);
    if (root.rightChild != null)
      preOrderTraversal(root.rightChild);
  }

  public void postOrderTraversal(Node root)
  {
    if (root == null)
      return;
    if (root.leftChild != null)
      postOrderTraversal(root.leftChild);
    if (root.rightChild != null)
      postOrderTraversal(root.rightChild);
    System.out.println(root.data);
  }

  public void bfsTraversal(Node root)
  {
    if (root == null)
      return;
    Queue<Node> queue = new ConcurrentLinkedQueue<Node>();
    queue.add(root);
    while (!queue.isEmpty())
    {
      Node n = (Node) queue.poll();
      System.out.println(n.data);
      if (n.leftChild != null)
      {
        queue.add(n.leftChild);
      }
      if (n.rightChild != null)
      {
        queue.add(n.rightChild);
      }
    }
  }

  public boolean isSibling(Node root, int data1, int data2)
  {
    if (root == null || root.leftChild == null || root.rightChild == null)
      return false;
    else
    {
      if ((root.leftChild.data == data1 && root.rightChild.data == data2)
          || (root.leftChild.data == data2 && root.rightChild.data == data1)
          || isSibling(root.leftChild, data1, data2) || isSibling(root.rightChild, data1, data2))
      {
        return true;
      }
      else
        return false;
    }
  }

  public int level(Node root, int data, int level)
  {
    if (root == null)
      return 0;
    if (root.data == data)
      return level;
    int lvl = 0;
    if (root.leftChild != null)
      lvl = level(root.leftChild, data, level + 1);
    if (lvl != 0)
      return lvl;
    if (root.rightChild != null)
      lvl = level(root.rightChild, data, level + 1);
    return lvl;
  }

  public static void main(String... args)
  {
    Node node = new TreeImp.Node();
    node.data = 7;
    TreeImp treeImp = new TreeImp(node);
    treeImp.insert(node, 9);
    treeImp.insert(node, 5);
    treeImp.insert(node, 6);
    treeImp.insert(node, 4);
    treeImp.insert(node, 8);
    /*
     * Node node = new TreeImp.Node(); node.data = 6; TreeImp treeImp = new
     * TreeImp(node); treeImp.insert(node, 1); treeImp.insert(node, 2);
     * treeImp.insert(node, 3); treeImp.insert(node, 4); treeImp.insert(node,
     * 5); treeImp.insert(node, 7); treeImp.insert(node, 8);
     * treeImp.insert(node, 9); treeImp.insert(node, 10); treeImp.insert(node,
     * 11);
     */
    // treeImp.preOrderTraversal(node);
    // treeImp.postOrderTraversal(node);
    // treeImp.inOrderTraversal(node);
    // treeImp.delete(node, 8);
    // treeImp.delete(node, 8);
    treeImp.bfsTraversal(node);
   /* System.out.println(treeImp.level(node, 7, 1) + "level");
    System.out.println(treeImp.isSibling(node, 5, 9) + "sibling");*/
  }
}

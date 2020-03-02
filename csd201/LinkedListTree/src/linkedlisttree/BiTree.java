/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlisttree;

/**
 *
 * @author Admin
 */
public class BiTree {

    Node root;

    BiTree() {
        root = null;
    }

    void PreOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + "");
            PreOrder(root.l);
            PreOrder(root.r);

        }
    }

    void Pre() {
        PreOrder(root);
    }

    void PostOrder(Node root) {
        if (root != null) {
            PostOrder(root.l);
            PostOrder(root.r);
            System.out.print(root.data + "");
        }
    }

    void Post() {
        PostOrder(root);
    }

    void InOrder(Node root) {
        if (root != null) {
            InOrder(root.l);
            System.out.print(root.data + "");
            InOrder(root.r);
        }
    }

    void In() {
        InOrder(root);
    }

    Node insertRec(int x, Node root) {
        if (root == null) {
            root = new Node(x);
            return root;
        } else if (x < root.data) {
            root.l = insertRec(x, root.l);
        } else if (x > root.data) {
            root.r = insertRec(x, root.r);
        } else {
            System.out.println("trung");
        }
        return root;
    }

    void insert(int x) {
        root = insertRec(x, root);
    }

    Node search(int x, Node root) {
        if (root == null) {
            return null;
        }
        if (root.data == x) {
            return root;
        }
        if (x < root.data) {
            return search(x, root.l);
        } else {
            return search(x, root.r);
        }
    }

    Node delRec(int x, Node root) {
        if (root == null) {
            return root;
        }
        if (x < root.data) {
            root.l = delRec(x, root.l);
        } else if (x > root.data) {
            root.r = delRec(x, root.r);
        } else if (x == root.data) {
            if (root.l == null) {
                return root.r;
            } else if (root.r == null) {
                return root.l;
            } else {
                root.data = minNode(root.r);
            }
            root.r = delRec(root.data, root.r);
        }
        return root;
    }

    int minNode(Node root) {
        int m = root.data;
        while (root.l != null) {
            m = root.l.data;
            root = root.l;
        }
        return m;
    }

    void Delete(int x) {
        delRec(x, root);
    }

    void BFT() {
        if (root == null) {
            System.out.println("Tree is null");
            return;
        }
        Queue Q = new Queue();
        Q.enqueue(root);
        Node p;
        while (!Q.isEmpty()) {
            p = (Node) Q.dequeue();
            if (p.l != null) {
                Q.enqueue(p.l);
            }
            if (p.r != null) {
                Q.enqueue(p.r);
            }
            System.out.println(p.data + "");
        }
    }

    public static void main(String[] args) {
        BiTree bt = new BiTree();
        bt.insert(5);
        bt.insert(3);
        bt.insert(2);
        bt.insert(4);
        bt.insert(7);
        bt.insert(6);
        System.out.print("\nPre Order: ");
        bt.Pre();
//        bt.Delete(2);
        System.out.print("\nBTF: ");
        bt.BFT();
//        System.out.print("\nIn Order: ");
//        bt.In();
//        System.out.print("\nPost Order: ");
//        bt.Post();
//        System.out.print("\nFind x=2: ");
//        Node p = bt.search(2, bt.root);
//        if (p != null) {
//            System.out.print("\nFound x= " + p.data);
//        } else {
//            System.out.println("\nNot found x=2");
//        }
    }

}

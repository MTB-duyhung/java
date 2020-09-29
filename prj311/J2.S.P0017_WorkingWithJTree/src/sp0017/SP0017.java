/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp0017;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.border.Border;

public class SP0017 extends JFrame {

    public static JLabel f;
    private Border lineBorder = BorderFactory.createLineBorder(Color.blue);

    public SP0017() throws HeadlessException {
        initializeUI();
    }

    private void initializeUI() {
        setSize(500, 600);
        f = new JLabel();
        f.setSize(600, 200);
        f.setBounds(10, 300, 400, 200);
        f.setBorder(lineBorder);
        add(f);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("The Java Series");
        DefaultMutableTreeNode Programmers = new DefaultMutableTreeNode("Books for Java Programmers");
        Book[] books = new Book[]{
            new Book("The Java Tutorial: A Short Course on the Basics", "/2.png", "html/1.html"),
            new Book("The Java Tutorial Continued: The Rest of the JDK", "/2.png", "html/2.html"),
            new Book("The JFC Swing Tutorial: A Guide to Constructing GUIs", "/2.png", "html/3.html"),
            new Book("Effective Java Programming Language Guide", "/1.png", "html/4.html"),
            new Book("The Java Programming Language", "/1.png", "html/5.html"),
            new Book("The Java Developers Almanac", "/1.png", "html/6.html"),};

        for (Book book : books) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(book);
            Programmers.add(node);
        }

        DefaultMutableTreeNode Implementers = new DefaultMutableTreeNode("Books for Java Implementers");
        books = new Book[]{
            new Book("The Java Virtual Machine Specification", "/1.png", "html/7.html"),
            new Book("The Java Language Specification", "/1.png", "html/8.html")
        };

        for (Book book : books) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(book);
            Implementers.add(node);
        }

        root.add(Programmers);
        root.add(Implementers);

        final JTree tree = new JTree(root);
        tree.setCellRenderer(new BookTreeCellRenderer());

        JScrollPane pane = new JScrollPane(tree);
        pane.setPreferredSize(new Dimension(200, 400));

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(pane, BorderLayout.CENTER);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (node == null) {
                    return;
                }
                Object nodeInfo = node.getUserObject();
                if (node.isLeaf()) {
                    Book book = (Book) nodeInfo;
                    ReadHTML r = new ReadHTML();
                    String s = r.readHTML(book.html);
                    f.setText(s);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SP0017().setVisible(true);
            }
        });
    }

    class ReadHTML {

        public String readHTML(String html) {
            String s, a = "";
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(html));
                while ((s = br.readLine()) != null) {
                    a += s;
                    s = br.readLine();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return a;
        }
    }

    class BookTreeCellRenderer implements TreeCellRenderer {

        private JLabel label;

        BookTreeCellRenderer() {
            label = new JLabel();
        }

        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
                boolean leaf, int row, boolean hasFocus) {
            Object o = ((DefaultMutableTreeNode) value).getUserObject();
            if (o instanceof Book) {
                Book book = (Book) o;
                URL imageUrl = getClass().getResource(book.getIcon());
                if (imageUrl != null) {
                    label.setIcon(new ImageIcon(imageUrl));
                }
                label.setText(book.getName());
            } else {
                label.setIcon(null);
                label.setText("" + value);
            }
            return label;
        }
    }

    class Book {

        private String name;
        private String icon;
        private String html;

        Book(String name, String icon, String html) {
            this.name = name;
            this.icon = icon;
            this.html = html;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setFlagIcon(String icon) {
            this.icon = icon;
        }

        public String getHtml() {
            return html;
        }

        public void setHtml(String html) {
            this.html = html;
        }

    }
}

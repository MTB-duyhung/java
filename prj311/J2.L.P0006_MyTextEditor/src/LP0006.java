
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.undo.UndoManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class LP0006 extends javax.swing.JFrame {

    String textOriginal = "";//text of file before edit
    JFileChooser fChooser = new JFileChooser();
    File file;
    boolean isNewFile = true;
    String filePath = "";
    UndoManager un;

    public LP0006() {
        initComponents();
        setIcon();
        setTitle("Untitled.txt");
        addFonts();
        un = new UndoManager();
        txtText.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                un.addEdit(e.getEdit());
            }
        });

    }

    //set size for icon
    private ImageIcon loadImage(String imageIcon) {
        ImageIcon img = null;
        img = new ImageIcon(imageIcon);
        Image i = img.getImage();
        Image image = i.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        img = new ImageIcon(image);
        return img;
    }

    //set icons for menus
    private void setIcon() {
        mnNew.setIcon(loadImage("new.png"));
        mnOpen.setIcon(loadImage("open.png"));
        mnSave.setIcon(loadImage("save.png"));
        mnSaveAs.setIcon(loadImage("saveAs.png"));
        mnExit.setIcon(loadImage("exit.png"));
        mnSelectAll.setIcon(loadImage("selectAll.png"));
        mnCut.setIcon(loadImage("cut.png"));
        mnCopy.setIcon(loadImage("copy.png"));
        mnPaste.setIcon(loadImage("paste.png"));
        mnUndo.setIcon(loadImage("undo.png"));
        mnRedo.setIcon(loadImage("redo.png"));
        mnFind.setIcon(loadImage("find.png"));
        mnReplace.setIcon(loadImage("replace.png"));
        mnChangeFont.setIcon(loadImage("changeFont.png"));
    }

    //add all available fonts to combo box
    private void addFonts() {
        GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] list = g.getAvailableFontFamilyNames();//get all available fonts 
        for (String fonts : list) {//add all fonts to combo box
            cbbFont.addItem(fonts);
        }
    }

    class MyHighlightPainter extends DefaultHighlighter.DefaultHighlightPainter {

        public MyHighlightPainter(Color c) {
            super(c);
        }

    }
    Highlighter.HighlightPainter myHighlightPainter = new MyHighlightPainter(Color.yellow);

    //hightlight selected letters in the text
    private void highlight(JTextComponent text, String pattern) {
        try {
            Highlighter h = text.getHighlighter();
            Document doc = text.getDocument();
            String t = doc.getText(0, doc.getLength());
            int pos = 0, count = 0;
            while ((pos = t.toUpperCase().indexOf(pattern.toUpperCase(), pos)) >= 0) {
                h.addHighlight(pos, pos + pattern.length(), myHighlightPainter);
                count++;
                pos += pattern.length();
            }
            lbNoteFind.setText("" + count);
        } catch (Exception e) {
        }
    }

    //remove all highlight in the text 
    private void removeHighlight(JTextComponent text) {
        Highlighter h = text.getHighlighter();
        h.removeAllHighlights();
        lbNoteFind.setText("0");
    }

    //write text in text field to file
    public void Write(String path, String content) {
        try {
            PrintWriter fw = new PrintWriter(new FileOutputStream(path), true);
            String s[] = content.split("\n");
            for (int i = 0; i < s.length; i++) {
                String string = s[i];
                fw.print(string + "\r\n");
            }
            fw.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    //check if the text is change then ask to save file or not
    private boolean Verify_Save() {
        if (!textOriginal.equals(txtText.getText())) {
            int result;
            Object[] options = {"Save", "Don't save", "Cancel"};
            if (!isNewFile) {
                result = JOptionPane.showOptionDialog(this,
                        "Do you want to save change to"
                        + filePath, "Notepad",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            } else {
                result = JOptionPane.showOptionDialog(this,
                        "Do you want to save change to"
                        + file, "Notepad",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            }
            if (result == JOptionPane.YES_OPTION) {
                if (!isNewFile) {
                    try {
                        Write(filePath, txtText.getText());
                    } catch (Exception e) {
                    }
                } else {
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
                    fChooser.setFileFilter(filter);
                    int option = fChooser.showSaveDialog(this);
                    if (option == JFileChooser.APPROVE_OPTION) {
                        try {
                            BufferedWriter out = new BufferedWriter(new FileWriter(fChooser.getSelectedFile().getPath() + ".txt"));
                            out.write(this.txtText.getText());
                            out.close();
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
            } else if (result == JOptionPane.CANCEL_OPTION) {
                return false;
            }
        }
        return true;
    }

    //save text as another text file
    private void saveAs() {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        fChooser.setFileFilter(filter);
        int option = fChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                textOriginal = txtText.getText();
                filePath = fChooser.getSelectedFile().getPath() + ".txt";
                Write(filePath, textOriginal);
                isNewFile = false;
                setTitle(fChooser.getSelectedFile().getName() + ".txt");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FindDialog = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        btnGoFind = new javax.swing.JButton();
        btnCancelFind = new javax.swing.JButton();
        lbNoteFind = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ReplaceDialog = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        txtFindReplace = new javax.swing.JTextField();
        btnGoReplace = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtReplace = new javax.swing.JTextField();
        FontDialog = new javax.swing.JDialog();
        jLabel5 = new javax.swing.JLabel();
        cbbFont = new javax.swing.JComboBox<>();
        lbFont = new javax.swing.JLabel();
        btnOKFont = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtText = new javax.swing.JTextArea();
        mnBar = new javax.swing.JMenuBar();
        mnFile = new javax.swing.JMenu();
        mnNew = new javax.swing.JMenuItem();
        mnOpen = new javax.swing.JMenuItem();
        mnSave = new javax.swing.JMenuItem();
        mnSaveAs = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnExit = new javax.swing.JMenuItem();
        mnEdit = new javax.swing.JMenu();
        mnSelectAll = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mnCut = new javax.swing.JMenuItem();
        mnCopy = new javax.swing.JMenuItem();
        mnPaste = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnUndo = new javax.swing.JMenuItem();
        mnRedo = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mnFind = new javax.swing.JMenuItem();
        mnReplace = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        mnChangeFont = new javax.swing.JMenuItem();

        FindDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                FindDialogWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                FindDialogWindowClosing(evt);
            }
        });

        jLabel1.setText("Find");

        btnGoFind.setText("Go");
        btnGoFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoFindActionPerformed(evt);
            }
        });

        btnCancelFind.setText("Cancel");
        btnCancelFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelFindActionPerformed(evt);
            }
        });

        lbNoteFind.setForeground(new java.awt.Color(255, 0, 0));
        lbNoteFind.setText("0");

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Found:");

        javax.swing.GroupLayout FindDialogLayout = new javax.swing.GroupLayout(FindDialog.getContentPane());
        FindDialog.getContentPane().setLayout(FindDialogLayout);
        FindDialogLayout.setHorizontalGroup(
            FindDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FindDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FindDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FindDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FindDialogLayout.createSequentialGroup()
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGoFind)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelFind))
                    .addComponent(lbNoteFind))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FindDialogLayout.setVerticalGroup(
            FindDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FindDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FindDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGoFind)
                    .addComponent(btnCancelFind))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FindDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbNoteFind))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        ReplaceDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                ReplaceDialogWindowClosing(evt);
            }
        });

        jLabel2.setText("Find");

        btnGoReplace.setText("Go");
        btnGoReplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoReplaceActionPerformed(evt);
            }
        });

        jLabel3.setText("Reaplce");

        javax.swing.GroupLayout ReplaceDialogLayout = new javax.swing.GroupLayout(ReplaceDialog.getContentPane());
        ReplaceDialog.getContentPane().setLayout(ReplaceDialogLayout);
        ReplaceDialogLayout.setHorizontalGroup(
            ReplaceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReplaceDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ReplaceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGroup(ReplaceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ReplaceDialogLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(txtFindReplace, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ReplaceDialogLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtReplace)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGoReplace)
                .addGap(0, 8, Short.MAX_VALUE))
        );
        ReplaceDialogLayout.setVerticalGroup(
            ReplaceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReplaceDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ReplaceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFindReplace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ReplaceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtReplace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGoReplace))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        FontDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                FontDialogWindowOpened(evt);
            }
        });

        jLabel5.setText("Font");

        cbbFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbFontActionPerformed(evt);
            }
        });

        lbFont.setText("This font is Tahoma");

        btnOKFont.setText("OK");
        btnOKFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKFontActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FontDialogLayout = new javax.swing.GroupLayout(FontDialog.getContentPane());
        FontDialog.getContentPane().setLayout(FontDialogLayout);
        FontDialogLayout.setHorizontalGroup(
            FontDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FontDialogLayout.createSequentialGroup()
                .addGroup(FontDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FontDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(32, 32, 32)
                        .addComponent(cbbFont, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FontDialogLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lbFont)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FontDialogLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnOKFont)
                .addGap(33, 33, 33))
        );
        FontDialogLayout.setVerticalGroup(
            FontDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FontDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FontDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbbFont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbFont)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOKFont)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txtText.setColumns(20);
        txtText.setRows(5);
        jScrollPane1.setViewportView(txtText);

        mnBar.setBackground(new java.awt.Color(0, 204, 255));

        mnFile.setText("File");

        mnNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mnNew.setText("New");
        mnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnNewActionPerformed(evt);
            }
        });
        mnFile.add(mnNew);

        mnOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mnOpen.setText("Open");
        mnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnOpenActionPerformed(evt);
            }
        });
        mnFile.add(mnOpen);

        mnSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mnSave.setText("Save");
        mnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSaveActionPerformed(evt);
            }
        });
        mnFile.add(mnSave);

        mnSaveAs.setText("Save As");
        mnSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSaveAsActionPerformed(evt);
            }
        });
        mnFile.add(mnSaveAs);
        mnFile.add(jSeparator1);

        mnExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        mnExit.setText("Exit");
        mnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnExitActionPerformed(evt);
            }
        });
        mnFile.add(mnExit);

        mnBar.add(mnFile);

        mnEdit.setText("Edit");

        mnSelectAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        mnSelectAll.setText("Select All");
        mnSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSelectAllActionPerformed(evt);
            }
        });
        mnEdit.add(mnSelectAll);
        mnEdit.add(jSeparator4);

        mnCut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        mnCut.setText("Cut");
        mnCut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCutActionPerformed(evt);
            }
        });
        mnEdit.add(mnCut);

        mnCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        mnCopy.setText("Copy");
        mnCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCopyActionPerformed(evt);
            }
        });
        mnEdit.add(mnCopy);

        mnPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        mnPaste.setText("Paste");
        mnPaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPasteActionPerformed(evt);
            }
        });
        mnEdit.add(mnPaste);
        mnEdit.add(jSeparator2);

        mnUndo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        mnUndo.setText("Undo");
        mnUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnUndoActionPerformed(evt);
            }
        });
        mnEdit.add(mnUndo);

        mnRedo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        mnRedo.setText("Redo");
        mnRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnRedoActionPerformed(evt);
            }
        });
        mnEdit.add(mnRedo);
        mnEdit.add(jSeparator5);

        mnFind.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        mnFind.setText("Find");
        mnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnFindActionPerformed(evt);
            }
        });
        mnEdit.add(mnFind);

        mnReplace.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        mnReplace.setText("Replace");
        mnReplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnReplaceActionPerformed(evt);
            }
        });
        mnEdit.add(mnReplace);
        mnEdit.add(jSeparator6);

        mnChangeFont.setText("Change Font");
        mnChangeFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnChangeFontActionPerformed(evt);
            }
        });
        mnEdit.add(mnChangeFont);

        mnBar.add(mnEdit);

        setJMenuBar(mnBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnNewActionPerformed
        if (!Verify_Save()) {
            return;
        }
        textOriginal = "";
        isNewFile = true;
        file = null;
        filePath = "";
        txtText.setText("");
        setTitle("Untitled.txt");
        txtText.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                un.addEdit(e.getEdit());
            }
        });
    }//GEN-LAST:event_mnNewActionPerformed

    private void mnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnOpenActionPerformed
        if (!Verify_Save()) {
            return;
        }
        BufferedReader br = null;
        try {
            int returnVal = fChooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = fChooser.getSelectedFile();
                filePath = fChooser.getSelectedFile().getPath();
                setTitle(fChooser.getSelectedFile().getName());
            }
            br = new BufferedReader(new FileReader(file.getAbsolutePath()));
            txtText.read(br, null);
            textOriginal = txtText.getText();
            isNewFile = false;
            txtText.getDocument().addUndoableEditListener(new UndoableEditListener() {
                @Override
                public void undoableEditHappened(UndoableEditEvent e) {
                    un.addEdit(e.getEdit());
                }
            });
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "File not found");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_mnOpenActionPerformed

    private void mnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSaveActionPerformed
        if (!textOriginal.equals(txtText.getText())) {
            if (!isNewFile) {
                try {
                    textOriginal = txtText.getText();
                    Write(filePath, textOriginal);
                } catch (Exception e) {
                }
            } else {
                saveAs();
            }
        }
    }//GEN-LAST:event_mnSaveActionPerformed

    private void mnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnExitActionPerformed
        if (!Verify_Save()) {
            return;
        }
        System.exit(0);
    }//GEN-LAST:event_mnExitActionPerformed

    private void mnCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCopyActionPerformed
        txtText.copy();
    }//GEN-LAST:event_mnCopyActionPerformed

    private void mnCutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCutActionPerformed

        txtText.cut();
    }//GEN-LAST:event_mnCutActionPerformed

    private void mnPasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPasteActionPerformed
        txtText.paste();
    }//GEN-LAST:event_mnPasteActionPerformed

    private void mnSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSelectAllActionPerformed
        txtText.selectAll();
    }//GEN-LAST:event_mnSelectAllActionPerformed

    private void mnSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSaveAsActionPerformed
        saveAs();
    }//GEN-LAST:event_mnSaveAsActionPerformed

    private void mnUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnUndoActionPerformed
        if (un.canUndo()) {
            un.undo();
        }
    }//GEN-LAST:event_mnUndoActionPerformed

    private void mnRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnRedoActionPerformed
        if (un.canRedo()) {
            un.redo();
        }
    }//GEN-LAST:event_mnRedoActionPerformed

    private void mnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnFindActionPerformed
        FindDialog.setSize(450, 100);
        FindDialog.setVisible(true);
    }//GEN-LAST:event_mnFindActionPerformed

    private void mnReplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnReplaceActionPerformed
        ReplaceDialog.setSize(400, 120);
        ReplaceDialog.setVisible(true);
    }//GEN-LAST:event_mnReplaceActionPerformed

    private void mnChangeFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnChangeFontActionPerformed
        FontDialog.setSize(300, 150);
        FontDialog.setVisible(true);
    }//GEN-LAST:event_mnChangeFontActionPerformed

    private void btnGoFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoFindActionPerformed
        removeHighlight(txtText);
        highlight(txtText, txtFind.getText());
    }//GEN-LAST:event_btnGoFindActionPerformed

    private void btnCancelFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelFindActionPerformed
        removeHighlight(txtText);
        txtFind.setText("");
    }//GEN-LAST:event_btnCancelFindActionPerformed

    private void btnGoReplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoReplaceActionPerformed
        String s1 = txtFindReplace.getText();
        String s2 = txtReplace.getText();
        String str = txtText.getText();
        String text = str.replaceAll(s1, s2);
        txtText.setText(text);
    }//GEN-LAST:event_btnGoReplaceActionPerformed

    private void FindDialogWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_FindDialogWindowClosed

    }//GEN-LAST:event_FindDialogWindowClosed

    private void FindDialogWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_FindDialogWindowClosing
        removeHighlight(txtText);
    }//GEN-LAST:event_FindDialogWindowClosing

    private void ReplaceDialogWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_ReplaceDialogWindowClosing
//        removeHighlight(txtText);
    }//GEN-LAST:event_ReplaceDialogWindowClosing

    private void cbbFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbFontActionPerformed
        String f = cbbFont.getSelectedItem().toString();
        Font font = new Font(f, Font.PLAIN, 12);
        lbFont.setText("This font is " + f);
        lbFont.setFont(font);
    }//GEN-LAST:event_cbbFontActionPerformed

    private void FontDialogWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_FontDialogWindowOpened

    }//GEN-LAST:event_FontDialogWindowOpened

    private void btnOKFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKFontActionPerformed
        String f = cbbFont.getSelectedItem().toString();
        Font font = new Font(f, Font.PLAIN, 12);
        txtText.setFont(font);
        FontDialog.dispose();
    }//GEN-LAST:event_btnOKFontActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (!Verify_Save()) {
            return;
        }
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LP0006.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LP0006.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LP0006.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LP0006.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LP0006().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog FindDialog;
    private javax.swing.JDialog FontDialog;
    private javax.swing.JDialog ReplaceDialog;
    private javax.swing.JButton btnCancelFind;
    private javax.swing.JButton btnGoFind;
    private javax.swing.JButton btnGoReplace;
    private javax.swing.JButton btnOKFont;
    private javax.swing.JComboBox<String> cbbFont;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JLabel lbFont;
    private javax.swing.JLabel lbNoteFind;
    private javax.swing.JMenuBar mnBar;
    private javax.swing.JMenuItem mnChangeFont;
    private javax.swing.JMenuItem mnCopy;
    private javax.swing.JMenuItem mnCut;
    private javax.swing.JMenu mnEdit;
    private javax.swing.JMenuItem mnExit;
    private javax.swing.JMenu mnFile;
    private javax.swing.JMenuItem mnFind;
    private javax.swing.JMenuItem mnNew;
    private javax.swing.JMenuItem mnOpen;
    private javax.swing.JMenuItem mnPaste;
    private javax.swing.JMenuItem mnRedo;
    private javax.swing.JMenuItem mnReplace;
    private javax.swing.JMenuItem mnSave;
    private javax.swing.JMenuItem mnSaveAs;
    private javax.swing.JMenuItem mnSelectAll;
    private javax.swing.JMenuItem mnUndo;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtFindReplace;
    private javax.swing.JTextField txtReplace;
    private javax.swing.JTextArea txtText;
    // End of variables declaration//GEN-END:variables
}

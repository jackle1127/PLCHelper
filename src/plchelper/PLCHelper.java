package plchelper;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.tools.PDFText2HTML;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class PLCHelper extends javax.swing.JFrame {

    JFileChooser chooser = new JFileChooser();
    ArrayList<String> definitionsList = new ArrayList<>();
    ArrayList<String> keysList = new ArrayList<>();
    PlzWait waitFrame = new PlzWait();

    public PLCHelper() {
        initComponents();
        this.setLocationRelativeTo(null);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileFilter(new FileNameExtensionFilter("PDF files", "pdf"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        kToD = new javax.swing.JRadioButton();
        dToK = new javax.swing.JRadioButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(kToD);
        kToD.setText("Key to definition");
        kToD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kToDActionPerformed(evt);
            }
        });

        buttonGroup1.add(dToK);
        dToK.setSelected(true);
        dToK.setText("Definition to key");
        dToK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dToKActionPerformed(evt);
            }
        });

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setResizeWeight(0.8);

        jList1.setModel(new DefaultListModel());
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jSplitPane1.setRightComponent(jScrollPane2);

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Open PDF");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dToK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kToD)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kToD)
                    .addComponent(dToK)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dToKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dToKActionPerformed
        refreshList();
    }//GEN-LAST:event_dToKActionPerformed

    private void kToDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kToDActionPerformed
        refreshList();
    }//GEN-LAST:event_kToDActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        try {
            if (kToD.isSelected()) {
                jTextArea1.setText("Answer: \n" + definitionsList.get(jList1.getSelectedIndex()));
            } else {
                jTextArea1.setText("Answer: \n" + keysList.get(jList1.getSelectedIndex()));
            }
            this.setTitle((jList1.getSelectedIndex() + 1) + "/"
                    + definitionsList.size() + " entries");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jList1ValueChanged

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            waitFrame.show();
            Thread thready = new Thread(new Runnable() {
                @Override
                public void run() {
                    definitionsList.clear();
                    keysList.clear();
                    try {
                        if (chooser.getSelectedFile().getPath().endsWith(".pdf")) {
                            PDFText2HTML stripper = new PDFText2HTML();
                            PDDocument pdDoc = PDDocument.load(chooser.getSelectedFile());
                            stripper.setStartPage(1);
                            stripper.setEndPage(pdDoc.getNumberOfPages());
                            String xml = stripper.getText(pdDoc);
                            xml = xml.substring(xml.indexOf("<body>"),
                                    xml.indexOf("</body>") + "</body>".length());
                            xml = xml.replaceAll("<i>", "").replaceAll("</i>", "");
                            pdDoc.close();

                            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                            InputSource inputSource = new InputSource(new StringReader(xml));
                            Document doc = dBuilder.parse(inputSource);

                            doc.getDocumentElement().normalize();
                            NodeList p = doc.getElementsByTagName("p");

                            String currentEntry = "";
                            LinkedList<String> keys = new LinkedList<>();
                            for (int i = 0; i < p.getLength(); i++) {
                                if (p.item(i).getChildNodes().getLength() > 0) {
                                    // Skip topic header
                                    if (p.item(i).getChildNodes().getLength() == 1
                                            && p.item(i).getChildNodes().item(0).getNodeName().equals("b")) {
                                        continue;
                                    }
                                    // Skip footer
                                    if (p.item(i).getTextContent()
                                            .toLowerCase().contains("csc")) {
                                        continue;
                                    }
                                    
                                    NodeList children = p.item(i).getChildNodes();
                                    for (int j = 0; j < children.getLength(); j++) {
                                        Node child = children.item(j);
                                        String currentString = child.getTextContent()
                                                .replaceAll("\n", "");

                                        if (currentString.contains("•")) {
                                            currentString = currentString.substring(
                                                    currentString.indexOf("•"));
                                            if (currentEntry.length() > 0 && keys.size() > 0) {
                                                String key = "";
                                                for (String dummy : keys) {
                                                    key += "    •   " + dummy + "\n";
                                                }
                                                definitionsList.add(currentEntry);
                                                keysList.add(key);
                                            }
                                            currentEntry = "";
                                            keys.clear();
                                        }

                                        if (child.getNodeName().equals("b")) {
                                            currentEntry += currentString
                                                    .replaceAll("[^\\s]", "_");
                                            keys.add(currentString);
                                        } else {
                                            currentEntry += currentString;
                                        }
                                    }
                                }
                            }
                            if (currentEntry.length() > 0 && keys.size() > 0) {
                                String key = "";
                                for (String dummy : keys) {
                                    key += dummy + " - ";
                                }
                                definitionsList.add(currentEntry);
                                keysList.add(key);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    waitFrame.hide();
                    refreshList();
                }
            });
            thready.start();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        refreshList();
    }//GEN-LAST:event_jButton1ActionPerformed

    void refreshList() {
        DefaultListModel listModel = (DefaultListModel) jList1.getModel();
        listModel.removeAllElements();
        if (kToD.isSelected()) {
            for (String key : keysList) {
                listModel.addElement(key);
            }
        } else {
            for (String key : definitionsList) {
                listModel.addElement(key);
            }
        }
        this.setTitle(definitionsList.size() + " entries");
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(PLCHelper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PLCHelper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PLCHelper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PLCHelper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PLCHelper().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton dToK;
    private javax.swing.JButton jButton1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JRadioButton kToD;
    // End of variables declaration//GEN-END:variables
}

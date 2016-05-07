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
    PlzWait frmWait = new PlzWait();

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
        rdioKToD = new javax.swing.JRadioButton();
        rdioDToK = new javax.swing.JRadioButton();
        splpMainSplitPane = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstMainList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAnswer = new javax.swing.JTextArea();
        btnRefresh = new javax.swing.JButton();
        mbarMain = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuOpen = new javax.swing.JMenuItem();
        mnuExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(rdioKToD);
        rdioKToD.setText("Key to definition");
        rdioKToD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdioKToDActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdioDToK);
        rdioDToK.setSelected(true);
        rdioDToK.setText("Definition to key");
        rdioDToK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdioDToKActionPerformed(evt);
            }
        });

        splpMainSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        splpMainSplitPane.setResizeWeight(0.8);

        lstMainList.setModel(new DefaultListModel());
        lstMainList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstMainListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstMainList);

        splpMainSplitPane.setLeftComponent(jScrollPane1);

        txtAnswer.setEditable(false);
        txtAnswer.setColumns(20);
        txtAnswer.setRows(5);
        jScrollPane2.setViewportView(txtAnswer);

        splpMainSplitPane.setRightComponent(jScrollPane2);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        mnuOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mnuOpen.setText("Open PDF");
        mnuOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuOpenActionPerformed(evt);
            }
        });
        jMenu1.add(mnuOpen);

        mnuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        mnuExit.setText("Exit");
        mnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitActionPerformed(evt);
            }
        });
        jMenu1.add(mnuExit);

        mbarMain.add(jMenu1);

        setJMenuBar(mbarMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(splpMainSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdioDToK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdioKToD)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdioKToD)
                    .addComponent(rdioDToK)
                    .addComponent(btnRefresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(splpMainSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdioDToKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdioDToKActionPerformed
        refreshList();
    }//GEN-LAST:event_rdioDToKActionPerformed

    private void rdioKToDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdioKToDActionPerformed
        refreshList();
    }//GEN-LAST:event_rdioKToDActionPerformed

    private void lstMainListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstMainListValueChanged
        try {
            if (rdioKToD.isSelected()) {
                txtAnswer.setText("Answer: \n" + definitionsList.get(lstMainList.getSelectedIndex()));
            } else {
                txtAnswer.setText("Answer: \n" + keysList.get(lstMainList.getSelectedIndex()));
            }
            this.setTitle((lstMainList.getSelectedIndex() + 1) + "/"
                    + definitionsList.size() + " entries");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lstMainListValueChanged

    private void mnuOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuOpenActionPerformed
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            frmWait.show();
            Thread tempThread = new Thread(new Runnable() {
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
                    frmWait.hide();
                    refreshList();
                }
            });
            tempThread.start();
        }
    }//GEN-LAST:event_mnuOpenActionPerformed

    private void mnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnuExitActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refreshList();
    }//GEN-LAST:event_btnRefreshActionPerformed

    void refreshList() {
        DefaultListModel listModel = (DefaultListModel) lstMainList.getModel();
        listModel.removeAllElements();
        if (rdioKToD.isSelected()) {
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
    private javax.swing.JButton btnRefresh;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstMainList;
    private javax.swing.JMenuBar mbarMain;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenuItem mnuOpen;
    private javax.swing.JRadioButton rdioDToK;
    private javax.swing.JRadioButton rdioKToD;
    private javax.swing.JSplitPane splpMainSplitPane;
    private javax.swing.JTextArea txtAnswer;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autocorrectpoo;

/**
 *
 * @author davidzarate
 */
public class AutoCorrectMainPanel extends javax.swing.JPanel {

    /**
     * Creates new form AutoCorrectMainPanel
     */
    public AutoCorrectMainPanel() {
        initUserGeneratedComponents();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        archivosScrollPane = new javax.swing.JScrollPane();
        listaArchivos = new javax.swing.JList();
        autoresLabel = new javax.swing.JLabel();
        archivosLabel = new javax.swing.JLabel();
        modificarButton = new javax.swing.JButton();
        autoresScrollPane = new javax.swing.JScrollPane();
        listaAutores = new javax.swing.JList();
        escribirButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        listaArchivos.setModel(modeloArchivos);
        archivosScrollPane.setViewportView(listaArchivos);

        autoresLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        autoresLabel.setText("Autores:");

        archivosLabel.setText("Archivos del autor:");

        modificarButton.setText("Modificar Archivo");

        listaAutores.setModel(modeloAutores);
        autoresScrollPane.setViewportView(listaAutores);

        escribirButton.setText("Escribir");
        escribirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escribirButtonClick(evt);
            }
        });

        jButton1.setText("Agregar Autor");

        jButton2.setText("Eliminar Autor");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(autoresLabel)
                        .addGap(207, 207, 207)
                        .addComponent(archivosLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addComponent(autoresScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(modificarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(escribirButton))
                            .addComponent(archivosScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(autoresLabel)
                    .addComponent(archivosLabel))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(archivosScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                    .addComponent(autoresScrollPane))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificarButton)
                    .addComponent(escribirButton)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void escribirButtonClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escribirButtonClick
        WriteEntryDialog dialog = new WriteEntryDialog(new Autor());
    }//GEN-LAST:event_escribirButtonClick


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel archivosLabel;
    private javax.swing.JScrollPane archivosScrollPane;
    private javax.swing.JLabel autoresLabel;
    private javax.swing.JScrollPane autoresScrollPane;
    private javax.swing.JButton escribirButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JList listaArchivos;
    private javax.swing.JList listaAutores;
    private javax.swing.JButton modificarButton;
    // End of variables declaration//GEN-END:variables
    private javax.swing.DefaultListModel modeloAutores, modeloArchivos;
    
    private void initUserGeneratedComponents(){
        modeloAutores = new javax.swing.DefaultListModel();
        modeloArchivos = new javax.swing.DefaultListModel();
    }
    
    private class WriteEntryDialog extends javax.swing.JDialog{
        public PanelEscritura panelEscritura;
        public WriteEntryDialog(Autor autor){
            super();
            panelEscritura = new PanelEscritura(autor, this);
            this.getContentPane().add(panelEscritura);
            setTitle("Nueva Entrada");
            setSize(485, 609);
            setVisible(true);
            setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        }
    }
}

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
public class PanelModificacion extends javax.swing.JPanel {

    /**
     * Creates new form PanelModificacion
     * @param autor
     * @param indexOfFile
     * @param fileString
     */
    public PanelModificacion(Autor autor, int indexOfFile, String fileString, javax.swing.JDialog parentDialog) {
        this.autor = autor;
        this.indexOfFile = indexOfFile;
        this.parentDialog = parentDialog;
        initComponents();
        escrituraTextArea.setText(fileString);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entryScrollPane = new javax.swing.JScrollPane();
        escrituraTextArea = new javax.swing.JTextArea();
        corregirButton = new javax.swing.JButton();
        guardarEnDiccionarioButton = new javax.swing.JButton();
        guardarButton = new javax.swing.JButton();

        escrituraTextArea.setColumns(20);
        escrituraTextArea.setRows(5);
        entryScrollPane.setViewportView(escrituraTextArea);

        corregirButton.setText("Corregir Ortografía");
        corregirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                corregirOrtografiaClick(evt);
            }
        });

        guardarEnDiccionarioButton.setText("Guardar en Diccionario");
        guardarEnDiccionarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarDiccionarioClick(evt);
            }
        });

        guardarButton.setText("Guardar y Salir");
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarArchivoClick(evt);
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
                        .addComponent(entryScrollPane)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(corregirButton)
                        .addGap(6, 6, 6)
                        .addComponent(guardarEnDiccionarioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(guardarButton)
                        .addGap(6, 6, 6))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(entryScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(guardarEnDiccionarioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(guardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(corregirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void corregirOrtografiaClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_corregirOrtografiaClick
        String texto = escrituraTextArea.getText();
        String textoChecado = Corrector.corregirTexto(texto);
        escrituraTextArea.setText(texto + "\n\n\n" + "Propuesta:\n" + textoChecado);
    }//GEN-LAST:event_corregirOrtografiaClick

    private void guardarDiccionarioClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarDiccionarioClick
        String palabra = javax.swing.JOptionPane.showInputDialog("Agregar palabra");
        if(palabra!=null){
            Corrector.agregarPalabraADiccionario(palabra);
        }
    }//GEN-LAST:event_guardarDiccionarioClick

    private void guardarArchivoClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarArchivoClick
        FormatterTool.initialize(autor.getNombre()+Integer.toString(indexOfFile));
        FormatterTool.getFormatter().format(escrituraTextArea.getText());
        FormatterTool.closeFormatter();
        parentDialog.dispose();
    }//GEN-LAST:event_guardarArchivoClick


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton corregirButton;
    private javax.swing.JScrollPane entryScrollPane;
    private javax.swing.JTextArea escrituraTextArea;
    private javax.swing.JButton guardarButton;
    private javax.swing.JButton guardarEnDiccionarioButton;
    // End of variables declaration//GEN-END:variables
    private Autor autor;
    private int indexOfFile;
    private javax.swing.JDialog parentDialog;
}

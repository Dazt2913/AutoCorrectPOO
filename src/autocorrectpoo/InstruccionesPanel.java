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
public class InstruccionesPanel extends javax.swing.JPanel {

    /**
     * Creates new form InstruccionesPanel
     */
    public InstruccionesPanel() {
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

        instruccionesScrollPane = new javax.swing.JScrollPane();
        instruccionesTextArea = new javax.swing.JTextArea();

        instruccionesTextArea.setEditable(false);
        instruccionesTextArea.setColumns(20);
        instruccionesTextArea.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        instruccionesTextArea.setLineWrap(true);
        instruccionesTextArea.setRows(5);
        instruccionesTextArea.setText("Esta aplicación tiene la siguiente funcionalidad:\n\n1.- Escribir archivos y especificar el autor desde un principio\n2.- Escribir archivos sin autor\n3.- Verificar la ortografía de dichos archivos\n4.- Verificar la autoría de un archivo eligiendo un autor o comparándolo con todos los autores\n\n- Para escribir un archivo y especificar el autor, simplemente seleccione el autor y oprima el botón \"Escribir\".\n- Para escribir un archivo sin autor, seleccione [sin autor]\" de la lista de autores.\n- Para validar un archivo seleccione un archivo en la pestaña \"Validar\", presione el botón \"Validar\" y siga las instrucciones.");
        instruccionesTextArea.setWrapStyleWord(true);
        instruccionesScrollPane.setViewportView(instruccionesTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(instruccionesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(instruccionesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane instruccionesScrollPane;
    private javax.swing.JTextArea instruccionesTextArea;
    // End of variables declaration//GEN-END:variables
}
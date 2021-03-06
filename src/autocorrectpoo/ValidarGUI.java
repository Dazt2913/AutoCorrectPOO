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
public class ValidarGUI extends javax.swing.JPanel {

    /**
     * Creates new form ValidarGUI
     */
    public ValidarGUI() {
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

        instruccionesLabel = new javax.swing.JLabel();
        validarButton = new javax.swing.JButton();
        mainScrollPane = new javax.swing.JScrollPane();
        listaArchivosAll = new javax.swing.JList();

        instruccionesLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        instruccionesLabel.setText("Seleccione un archivo para validar...");

        validarButton.setText("Validar");
        validarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validarButtonClick(evt);
            }
        });

        listaArchivosAll.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        listaArchivosAll.setModel(modeloArchivosAll);
        mainScrollPane.setViewportView(listaArchivosAll);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(mainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(instruccionesLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(validarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(instruccionesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void validarButtonClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validarButtonClick
        java.util.LinkedList<Autor> autores = new java.util.LinkedList<>();
        Autor[] as = AutorLab.get().getAutores();
        for(int i = 1; i < as.length; i++){
            autores.add(as[i]);
        }
        int indexSelected = listaArchivosAll.getSelectedIndex();
        java.io.File file = (java.io.File)modeloArchivosAll.get(indexSelected);
        
        Validador val = new Validador();
        java.util.LinkedList<String> res = val.Validate(autores, file);
        
        String res2 = "";
        
        for(int i = res.size()-1; i >= 0; i--){
            res2 += res.get(i);
        }
        
        javax.swing.JOptionPane.showMessageDialog(null, res2);
    }//GEN-LAST:event_validarButtonClick


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel instruccionesLabel;
    private javax.swing.JList listaArchivosAll;
    private javax.swing.JScrollPane mainScrollPane;
    private javax.swing.JButton validarButton;
    // End of variables declaration//GEN-END:variables

    private javax.swing.DefaultListModel modeloArchivosAll;
    
    private void initUserGeneratedComponents(){
        modeloArchivosAll = new javax.swing.DefaultListModel();
//        Autor[] autores = AutorLab.get().getAutores();
//        Autor sinAutor = autores[0];
//        java.util.LinkedList<java.io.File> linkedFiles = sinAutor.getEntradas();
//        
//        for(int i = 0; i <linkedFiles.size(); i++){
//            System.out.println(linkedFiles.get(i));
//            modeloArchivosAll.addElement(linkedFiles.get(i));
//        }
    }
}
